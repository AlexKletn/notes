package com.example.notes2.users.api;

import com.example.notes2.common.itemsList.ItemsList;
import com.example.notes2.common.itemsList.ItemsListRequest;
import com.example.notes2.common.itemsList.ItemsListResponse;
import com.example.notes2.users.api.requests.CreateUserRequest;
import com.example.notes2.users.api.responses.UserResponse;
import com.example.notes2.users.api.responses.UserResponseMapper;
import com.example.notes2.users.api.responses.UsersResponseMapper;
import com.example.notes2.users.domain.entity.User;
import com.example.notes2.users.service.UsersService;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    private final UsersService usersService;
    private final UserResponseMapper userResponseMapper;
    private final UsersResponseMapper usersResponseMapper;

    public UsersController(
        UsersService usersService,
        UserResponseMapper userResponseMapper,
        UsersResponseMapper usersResponseMapper
    ) {
        this.usersService = usersService;
        this.userResponseMapper = userResponseMapper;
        this.usersResponseMapper = usersResponseMapper;
    }

    @GetMapping
    public ItemsListResponse<UserResponse> getUsers(@Valid @ParameterObject ItemsListRequest request) {
        ItemsList<User> users = usersService.getUsers(request);

        return usersResponseMapper.toResponse(users);
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Integer id) {
        User user = usersService.getUser(id);

        return userResponseMapper.toResponse(user);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(
            @Valid
            @RequestBody CreateUserRequest request
    ) {
        usersService.createUser(request);
    }

    // TODO: update user using auth vars
}
