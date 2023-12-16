package com.example.notes2.users.api.requests;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UpdateUserRequest {
    private String name;
}
