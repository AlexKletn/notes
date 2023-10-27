package com.example.notes2.service.notesService.impl;

import com.example.notes2.domain.entity.Note;
import com.example.notes2.domain.entity.User;
import com.example.notes2.service.notesService.NotesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class NotesServiceImpl implements NotesService {
    @Override
    public List<Note> getNotes() {
        Note note = new Note(374924523525481749L);

        note.setOwner(new User());
        note.setTitle("dgsgsdf");
        note.setDescription("fsdfgsad\nfdsafasdf");

        List<Note> noteList = new ArrayList<Note>();
        noteList.add(note);

        return noteList;
    }

    @Override
    public List<Note> getNotes(Map<String, String> filters) {
        return null;
    }

    @Override
    public Note getNote(Long id) {
        Note note = new Note(id);

        note.setOwner(new User());
        note.setTitle("dgsgsdf");
        note.setDescription("fsdfgsad\nfdsafasdf");

        return note;
    }

    @Override
    public Long createNote(Note noteData) {
        return null;
    }
}
