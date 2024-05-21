package com.example.testing.services.impl;

import com.example.testing.entities.User;
import com.example.testing.repositories.UserRepository;
import com.example.testing.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
    public String save(User userDto) {
        if(userRepository.findByEmail(userDto.getEmail()) == null){
            var user = new User();
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            userRepository.save(user);
            return "Saved \n";
        }{
            return "User already exists \n";
        }
    }
    public int deleteById(String email) {
        try {
            var user = userRepository.findByEmail(email);
            if (user != null) {
                userRepository.deleteById(user.getId());
                return 1;
            }else {
                return 0;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return 0;
    }
    public int updateUser(String email){
        try {
            var user = userRepository.findByEmail(email);
            if(user != null){
                userRepository.save(user);
                return 1;
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }
}
