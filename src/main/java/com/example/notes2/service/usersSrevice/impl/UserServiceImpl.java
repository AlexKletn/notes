package com.example.notes2.service.usersSrevice.impl;

import com.example.notes2.api.Users.requests.CreateUserRequest;
import com.example.notes2.api.Users.requests.UpdateUserRequest;
import com.example.notes2.api.Users.responses.UserResponse;
import com.example.notes2.api.Users.responses.UsersResponse;
import com.example.notes2.domain.User;
import com.example.notes2.repository.UsersRepository;
import com.example.notes2.service.usersSrevice.UsersService;
import jakarta.persistence.EntityNotFoundException;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class UserServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    @Transactional(readOnly = true)
    public UsersResponse getUsers() {
        List<User> users = usersRepository.findAll();

        return buildUsersResponse(users);
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getUser(Integer id) {
        return usersRepository
                .findById(id)
                .map(this::buildUserResponse)
                .orElseThrow(() -> new EntityNotFoundException("User " + id + " is not found"));
    }

    @Override
    @Transactional
    public void createUser(CreateUserRequest request) {
        User user = new User()
                .setName(request.getName());

        usersRepository.save(user);
    }

    @Override
    @Transactional
    public void updateUser(Integer id, UpdateUserRequest request) {
        User user = usersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User " + id + " is not found"));

        ofNullable(request.getName()).map(user::setName);
    }

    private UserResponse buildUserResponse(@NotNull User user) {
        return new UserResponse()
                .setId(user.getId())
                .setName(user.getName());
    }

    private UsersResponse buildUsersResponse(List<User> users) {
        List<UserResponse> notesResponseItems = users.stream().map(this::buildUserResponse).toList();

        return (UsersResponse) new UsersResponse()
                .setCount(notesResponseItems.size())
                .setItems(notesResponseItems);
    }
}
