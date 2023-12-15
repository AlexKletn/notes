package com.example.notes2.service.usersSrevice;

import com.example.notes2.api.Users.requests.CreateUserRequest;
import com.example.notes2.api.Users.requests.UpdateUserRequest;
import com.example.notes2.api.Users.responses.UserResponse;
import com.example.notes2.api.Users.responses.UsersResponse;
import com.example.notes2.domain.User;
import com.example.notes2.repository.usersRepository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UsersService {
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
    public UserResponse createUser(CreateUserRequest request) {
        return buildUserResponse(buildUser(request));
    }

    @Override
    @Transactional
    public UserResponse updateUser(Integer id, UpdateUserRequest request) {
        User user = usersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User " + id + " is not found"));

        ofNullable(request.getName()).map(user::setName);

        return buildUserResponse(user);
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

    private User buildUser(CreateUserRequest request) {
        return new User()
            .setName(request.getName());
    }
}
