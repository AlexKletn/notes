package com.example.notes2.users.repository;

import com.example.notes2.users.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Integer> {
}
