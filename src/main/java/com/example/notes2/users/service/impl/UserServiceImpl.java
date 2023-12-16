package com.example.notes2.users.service.impl;

import com.example.notes2.users.api.requests.CreateUserRequest;
import com.example.notes2.users.domain.entity.User;
import com.example.notes2.users.repository.UsersRepository;
import com.example.notes2.users.service.UsersService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return usersRepository.findAll();
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
