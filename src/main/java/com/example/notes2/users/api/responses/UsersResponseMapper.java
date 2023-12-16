package com.example.notes2.users.api.responses;

import com.example.notes2.common.itemsList.ItemsList;
import com.example.notes2.common.itemsList.ItemsListResponse;
import com.example.notes2.users.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsersResponseMapper {
    private final UserResponseMapper userResponseMapper;

    @Autowired
    public UsersResponseMapper(UserResponseMapper userResponseMapper) {
        this.userResponseMapper = userResponseMapper;
    }

    public ItemsListResponse<UserResponse> toResponse(ItemsList<User> usersList) {
        ItemsList<UserResponse> usersResponseList = new ItemsList<UserResponse>();

        usersResponseList.setItems(usersList.getItems().stream().map(userResponseMapper::toResponse).toList());
        usersResponseList.setTotal(usersList.getTotal());

        return ItemsListResponse.create(usersResponseList);
    }
}
