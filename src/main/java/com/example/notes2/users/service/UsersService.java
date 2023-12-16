package com.example.notes2.users.service;

import com.example.notes2.users.api.requests.CreateUserRequest;
import com.example.notes2.users.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersService {
    List<User> getUsers();

    User getUser(Integer id);

    void createUser(CreateUserRequest request);
}
