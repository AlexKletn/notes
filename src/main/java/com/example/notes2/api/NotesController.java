package com.example.notes2.api;

import com.example.notes2.domain.entity.Note;
import com.example.notes2.service.notesService.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NotesController {
    private NotesService notesService;

    @Autowired
    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping
    public List<Note> getNotes() {
        return notesService.getNotes();
    }
    @GetMapping("/{id}")
    public Note getNote(@PathVariable("id") Long id) {
        return notesService.getNote(id);
    }
}
