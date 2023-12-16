package com.example.notes2.repository;

import com.example.notes2.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Note, Integer> {
}
