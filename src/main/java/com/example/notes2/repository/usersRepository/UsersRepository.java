package com.example.notes2.repository.usersRepository;

import com.example.notes2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Integer> {
}
