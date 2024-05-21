package com.example.testing.services;

import com.example.testing.entities.User;

import java.util.List;

public interface UserService {
   public List<User> findAll();
   public String save(User user);
   public int deleteById(String email);
   public int updateUser(String email);
}
