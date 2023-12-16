package com.example.notes2.notes.api.responses;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class NoteResponse {
    private Integer id;
    private Integer owner_id;
    private String title;
    private String description;
}
