package com.example.notes2.api.Users.responses;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserResponse {
    private Integer id;
    private String name;
}
