package com.example.notes2.users.service.impl;

import com.example.notes2.common.itemsList.ItemsList;
import com.example.notes2.common.itemsList.ItemsListRequest;
import com.example.notes2.users.api.requests.CreateUserRequest;
import com.example.notes2.users.domain.entity.User;
import com.example.notes2.users.repository.UsersRepository;
import com.example.notes2.users.service.UsersService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    @Transactional(readOnly = true)
    public ItemsList<User> getUsers(ItemsListRequest request) {
        Sort sort = Sort.by(request.getSortDirection(), request.getSortField());
        Pageable pageable = PageRequest.of(request.getPage() - 1, request.getCount(), sort);

        Integer total = (int) usersRepository.count();
        Page<User> usersPage = usersRepository.findAll(pageable);
        List<User> users = usersPage.stream().toList();

        ItemsList<User> itemsList = new ItemsList<User>();

        itemsList.setItems(users);
        itemsList.setTotal(total);

        return itemsList;
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(Integer id) {
        return usersRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User " + id + " is not found"));
    }

    @Override
    @Transactional
    public void createUser(CreateUserRequest request) {
        User user = new User()
                .setName(request.getName());

        usersRepository.save(user);
    }
}
