package com.example.notes2.notes.api.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CreateNoteRequest {
    @NotNull(message = "owner_id is required")
    private Integer owner_id;

    @NotBlank(message = "Title is mandatory")
    @NotEmpty(message = "Title can't be empty")
    private String title;

    @NotBlank(message = "Description is mandatory")
    @NotEmpty(message = "Description can't be empty")
    private String description;
}
