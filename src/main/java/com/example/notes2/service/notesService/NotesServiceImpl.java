package com.example.notes2.service.notesService;

import com.example.notes2.api.Notes.requests.CreateNoteRequest;
import com.example.notes2.api.Notes.requests.UpdateNoteRequest;
import com.example.notes2.api.Notes.responses.NoteResponse;
import com.example.notes2.api.Notes.responses.NotesResponse;
import com.example.notes2.domain.Note;
import com.example.notes2.domain.User;
import com.example.notes2.repository.notesRepository.NotesRepository;
import com.example.notes2.repository.usersRepository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class NotesServiceImpl implements NotesService {
    private static NotesRepository notesRepository;
    private static UsersRepository usersRepository;

    @Override
    @Transactional(readOnly = true)
    public NotesResponse getNotes() {
        List<Note> notes = notesRepository.findAll();

        return buildNotesResponse(notes);
    }

    @Override
    @Transactional(readOnly = true)
    public NoteResponse getNote(Integer id) {
        return notesRepository
                .findById(id)
                .map(this::buildNoteResponse)
                .orElseThrow(() -> new EntityNotFoundException("Note " + id + " is not found"));
    }

    @Override
    @Transactional
    public void createNote(CreateNoteRequest noteData) {
        buildNoteFromRequest(noteData);
    }

    @Override
    @Transactional
    public void updateNote(Integer id, UpdateNoteRequest request) {
        Note note = notesRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Note " + id + " is not found"));

        ofNullable(request.getTitle()).map(note::setTitle);
        ofNullable(request.getDescription()).map(note::setDescription);
    }

    @Override
    @Transactional
    public void deleteNote(Integer id) {
        notesRepository.deleteById(id);
    }

    private NoteResponse buildNoteResponse(@NotNull Note note) {
        return new NoteResponse()
            .setId(note.getId())
            .setTitle(note.getTitle())
            .setDescription(note.getDescription())
            .setOwner_id(note.getOwner().getId());
    }

    private NotesResponse buildNotesResponse(@NotNull List<Note> notes) {
        List<NoteResponse> notesResponseItems = notes.stream().map(this::buildNoteResponse).toList();

        return (NotesResponse) new NotesResponse()
            .setCount(notesResponseItems.size())
            .setItems(notesResponseItems);
    }

    private void buildNoteFromRequest(@NotNull CreateNoteRequest note) {
        User owner = usersRepository
                .findById(note.getOwner_id())
                .orElseThrow(() -> new EntityNotFoundException("Owner " + note.getOwner_id() + " is not found"));

        new Note()
            .setTitle(note.getTitle())
            .setDescription(note.getDescription())
            .setOwner(owner);
    }

}
