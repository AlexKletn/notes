package com.example.notes2.users.api.responses;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserResponse {
    private Integer id;
    private String name;
}
