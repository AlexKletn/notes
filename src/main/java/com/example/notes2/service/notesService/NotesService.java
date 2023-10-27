package com.example.notes2.service.notesService;

import com.example.notes2.domain.entity.Note;

import java.util.List;
import java.util.Map;

public interface NotesService {
    List<Note> getNotes();
    List<Note> getNotes(Map<String, String> filters);
    Note getNote(Long id);

    Long createNote(Note noteData);
}
