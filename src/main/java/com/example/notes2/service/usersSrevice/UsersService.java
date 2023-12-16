package com.example.notes2.service.usersSrevice;

import com.example.notes2.api.Users.requests.CreateUserRequest;
import com.example.notes2.api.Users.requests.UpdateUserRequest;
import com.example.notes2.api.Users.responses.UserResponse;
import com.example.notes2.api.Users.responses.UsersResponse;
import org.springframework.stereotype.Service;

@Service
public interface UsersService {
    UsersResponse getUsers();

    UserResponse getUser(Integer id);

    void createUser(CreateUserRequest request);

    void updateUser(Integer id, UpdateUserRequest request);
}
