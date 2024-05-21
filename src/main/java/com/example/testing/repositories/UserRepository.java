package com.example.testing.repositories;

import com.example.testing.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
 public User findByEmail(String email);
}
