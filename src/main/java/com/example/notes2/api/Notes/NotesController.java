package com.example.notes2.api.Notes;

import com.example.notes2.api.Notes.requests.CreateNoteRequest;
import com.example.notes2.api.Notes.requests.UpdateNoteRequest;
import com.example.notes2.api.Notes.responses.NoteResponse;
import com.example.notes2.api.Notes.responses.NotesResponse;
import com.example.notes2.service.notesService.NotesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notes")
public class NotesController {
    private final NotesService notesService;

    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping
    public NotesResponse getNotes() {
        return notesService.getNotes();
    }

    @GetMapping("/{id}")
    public NoteResponse getNote(@PathVariable Integer id) {
        return notesService.getNote(id);
    }

    @PostMapping
    public void createNote(@RequestBody CreateNoteRequest request) {
        notesService.createNote(request);
    }

    @PatchMapping("/{id}")
    public void updateNote(@PathVariable Integer id, @RequestBody UpdateNoteRequest request) {
        notesService.updateNote(id, request);
    }

    @DeleteMapping("/{id}")
    public void updateNote(@PathVariable Integer id) {
        notesService.deleteNote(id);
    }
}
