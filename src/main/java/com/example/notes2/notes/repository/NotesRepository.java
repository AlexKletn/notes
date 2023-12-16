package com.example.notes2.notes.repository;

import com.example.notes2.notes.domain.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Note, Integer> {
}
