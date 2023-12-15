package com.example.notes2.api.Users;

import com.example.notes2.api.Users.requests.CreateUserRequest;
import com.example.notes2.api.Users.responses.UserResponse;
import com.example.notes2.api.Users.responses.UsersResponse;
import com.example.notes2.service.usersSrevice.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public UsersResponse getUsers() {
        return usersService.getUsers();
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Integer id) {
        return usersService.getUser(id);
    }

    @PostMapping
    public UserResponse createUser(@RequestBody CreateUserRequest request) {
        return usersService.createUser(request);
    }

    // TODO: update user using auth vars
}
