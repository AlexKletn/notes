package com.example.notes2.notes.api.responses;

import com.example.notes2.common.itemsList.ItemsList;
import com.example.notes2.common.itemsList.ItemsListResponse;
import com.example.notes2.notes.domain.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotesResponseMapper {
    private final NoteResponseMapper noteResponseMapper;

    @Autowired
    public NotesResponseMapper(NoteResponseMapper noteResponseMapper) {
        this.noteResponseMapper = noteResponseMapper;
    }

    public ItemsListResponse<NoteResponse> toResponse(ItemsList<Note> noteList) {
        ItemsList<NoteResponse> noteResponseList = new ItemsList<NoteResponse>();

        noteResponseList.setItems(noteList.getItems().stream().map(noteResponseMapper::toResponse).toList());
        noteResponseList.setTotal(noteList.getTotal());

        return ItemsListResponse.create(noteResponseList);
    }
}
