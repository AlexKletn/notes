package com.example.notes2.notes.api.responses;

import com.example.notes2.notes.domain.entity.Note;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NoteResponseMapper {
    NoteResponseMapper MAPPER = Mappers.getMapper( NoteResponseMapper.class );
    @Mapping(target = "owner_id", expression = "java(note.getOwner().getId())")
    NoteResponse toResponse(Note note);
    Note toEntity(NoteResponse note);
}
