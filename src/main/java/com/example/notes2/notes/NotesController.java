package com.example.notes2.notes;

import com.example.notes2.common.list.ListResponse;
import com.example.notes2.notes.api.requests.CreateNoteRequest;
import com.example.notes2.notes.api.requests.UpdateNoteRequest;
import com.example.notes2.notes.api.responses.NoteResponse;
import com.example.notes2.notes.api.responses.NoteResponseMapper;
import com.example.notes2.notes.api.responses.NotesResponseMapper;
import com.example.notes2.notes.domain.entity.Note;
import com.example.notes2.notes.service.NotesService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NotesController {
    private final NotesService notesService;
    private final NoteResponseMapper noteResponseMapper;
    private final NotesResponseMapper notesResponseMapper;

    @Autowired
    public NotesController(
        NotesService notesService,
        NoteResponseMapper noteResponseMapper,
        NotesResponseMapper notesResponseMapper
    ) {
        this.notesService = notesService;
        this.noteResponseMapper = noteResponseMapper;
        this.notesResponseMapper = notesResponseMapper;
    }

    @GetMapping
    public ListResponse<NoteResponse> getNotes() {
        List<Note> notes =  notesService.getNotes();

        return notesResponseMapper.toResponse(notes);
    }

    @GetMapping("/{id}")
    public NoteResponse getNote(@PathVariable Integer id) {
        Note note = notesService.getNote(id);

        return noteResponseMapper.toResponse(note);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNote(@Valid @RequestBody CreateNoteRequest request) {
        notesService.createNote(request);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateNote(@NotNull @PathVariable Integer id, @Valid @RequestBody UpdateNoteRequest request) {
        notesService.updateNote(id, request);
    }

    @DeleteMapping("/{id}")
    public void updateNote(@PathVariable Integer id) {
        notesService.deleteNote(id);
    }
}
