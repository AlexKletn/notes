package com.example.notes2.users.api.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CreateUserRequest {
    @NotBlank(message = "Name is mandatory")
    private String name;
}
