package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User register(User user) {
        return user; // dummy logic
    }

    @Override
    public User authenticate(String username, String password) {
        User user = new User();
        user.setUsername(username);
        return user;
    }
}
