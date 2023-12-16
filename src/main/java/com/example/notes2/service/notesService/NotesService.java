package com.example.notes2.service.notesService;

import com.example.notes2.api.Notes.requests.CreateNoteRequest;
import com.example.notes2.api.Notes.requests.UpdateNoteRequest;
import com.example.notes2.api.Notes.responses.NoteResponse;
import com.example.notes2.api.Notes.responses.NotesResponse;
import org.springframework.stereotype.Service;

@Service
public interface NotesService {
    NotesResponse getNotes();
    NoteResponse getNote(Integer id);

    void createNote(CreateNoteRequest noteData);

    void updateNote(Integer id, UpdateNoteRequest noteData);

    void deleteNote(Integer id);
}
