package com.example.notes2.repository.notesRepository;

import com.example.notes2.domain.entity.Note;

import java.util.List;

public interface NotesRepository {
    List<Note> find();
    Note findOne();

    Note save(Note note);
}
