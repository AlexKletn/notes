package com.example.notes2.notes.service;

import com.example.notes2.common.itemsList.ItemsList;
import com.example.notes2.common.itemsList.ItemsListRequest;
import com.example.notes2.notes.api.requests.CreateNoteRequest;
import com.example.notes2.notes.api.requests.UpdateNoteRequest;
import com.example.notes2.notes.domain.entity.Note;
import org.springframework.stereotype.Service;

@Service
public interface NotesService {
    ItemsList<Note> getNotes(ItemsListRequest request);
    Note getNote(Integer id);

    void createNote(CreateNoteRequest noteData);

    void updateNote(Integer id, UpdateNoteRequest noteData);

    void deleteNote(Integer id);
}
