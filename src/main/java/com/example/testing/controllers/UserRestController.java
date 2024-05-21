package com.example.testing.controllers;

import com.example.testing.dtos.UserLittleDto;
import com.example.testing.entities.User;
import com.example.testing.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    public UserService userService;

    @GetMapping(value = "/api/hello")
    public String hello() {
        return "Hello \n";
    }
    @GetMapping(value = "/api/users")
    public List<User> findAll() {
        return userService.findAll();
    }
    @PostMapping(value = "/api/users", consumes = "application/json")
    public String save(@RequestBody User user) {
       return userService.save(user);
    }
    @PatchMapping(value = "/api/users", consumes = "application/json")
    public int update(@RequestBody UserLittleDto user){
        return userService.updateUser(user.email);
    }
    @PostMapping(value = "/api/users/delete", consumes = "application/json")
    public int delete(@RequestBody UserLittleDto user) {
        return userService.deleteById(user.email);
    }
}
