package com.example.notes2.notes.service;

import com.example.notes2.notes.api.requests.CreateNoteRequest;
import com.example.notes2.notes.api.requests.UpdateNoteRequest;
import com.example.notes2.notes.domain.entity.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotesService {
    List<Note> getNotes();
    Note getNote(Integer id);

    void createNote(CreateNoteRequest noteData);

    void updateNote(Integer id, UpdateNoteRequest noteData);

    void deleteNote(Integer id);
}
