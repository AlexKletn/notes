package com.example.notes2.api.Notes.responses;

import com.example.notes2.api.Common.responses.ListResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper=true)
@Accessors(chain = true)
public class NotesResponse extends ListResponse<NoteResponse> {
}
