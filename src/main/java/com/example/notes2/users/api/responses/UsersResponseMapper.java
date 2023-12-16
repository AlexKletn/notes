package com.example.notes2.users.api.responses;

import com.example.notes2.common.list.ListResponse;
import com.example.notes2.users.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersResponseMapper {
    private final UserResponseMapper userResponseMapper;

    @Autowired
    public UsersResponseMapper(UserResponseMapper userResponseMapper) {
        this.userResponseMapper = userResponseMapper;
    }

    public ListResponse<UserResponse> toResponse(List<User> noteList) {
        List<UserResponse> noteResponseList = noteList.stream().map(userResponseMapper::toResponse).toList();

        return ListResponse.create(noteResponseList);
    }
}
