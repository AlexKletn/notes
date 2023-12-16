package com.example.notes2.notes.api.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UpdateNoteRequest {
    @NotEmpty(message = "Title can't be empty")
    private String title;
    @NotEmpty(message = "Description can't be empty")
    private String description;
}
