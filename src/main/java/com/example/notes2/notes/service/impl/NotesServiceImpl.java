package com.example.notes2.notes.service.impl;

import com.example.notes2.notes.api.requests.CreateNoteRequest;
import com.example.notes2.notes.api.requests.UpdateNoteRequest;
import com.example.notes2.notes.domain.entity.Note;
import com.example.notes2.notes.repository.NotesRepository;
import com.example.notes2.notes.service.NotesService;
import com.example.notes2.users.domain.entity.User;
import com.example.notes2.users.repository.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class NotesServiceImpl implements NotesService {
    @Autowired
    private NotesRepository notesRepository;
    @Autowired
    private UsersRepository usersRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Note> getNotes() {
        return notesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Note getNote(Integer id) {
        return notesRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Note " + id + " is not found"));
    }

    @Override
    @Transactional
    public void createNote(CreateNoteRequest note) {
        User owner = usersRepository
                .findById(note.getOwner_id())
                .orElseThrow(() -> new EntityNotFoundException("Owner " + note.getOwner_id() + " is not found"));

        Note newNote = new Note()
                .setTitle(note.getTitle())
                .setDescription(note.getDescription())
                .setOwner(owner);

        notesRepository.save(newNote);
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
}
