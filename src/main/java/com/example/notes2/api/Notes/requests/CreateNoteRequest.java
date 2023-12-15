package com.example.notes2.api.Notes.requests;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CreateNoteRequest {
    private Integer owner_id;
    private String title;
    private String description;
}
