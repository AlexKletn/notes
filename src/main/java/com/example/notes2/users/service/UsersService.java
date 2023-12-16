package com.example.notes2.users.service;

import com.example.notes2.common.itemsList.ItemsList;
import com.example.notes2.common.itemsList.ItemsListRequest;
import com.example.notes2.users.api.requests.CreateUserRequest;
import com.example.notes2.users.domain.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UsersService {
    ItemsList<User> getUsers(ItemsListRequest request);

    User getUser(Integer id);

    void createUser(CreateUserRequest request);
}
