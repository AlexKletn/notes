package com.example.notes2.notes.api.responses;

import com.example.notes2.common.list.ListResponse;
import com.example.notes2.notes.domain.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotesResponseMapper {
    private final NoteResponseMapper noteResponseMapper;

    @Autowired
    public NotesResponseMapper(NoteResponseMapper noteResponseMapper) {
        this.noteResponseMapper = noteResponseMapper;
    }

    public ListResponse<NoteResponse> toResponse(List<Note> noteList) {
        List<NoteResponse> noteResponseList = noteList.stream().map(noteResponseMapper::toResponse).toList();

        return ListResponse.create(noteResponseList);
    }
}
