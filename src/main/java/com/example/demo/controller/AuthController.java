package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    /**
     * Register a new user
     */
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User savedUser = userService.register(user);
        return ResponseEntity.ok(savedUser);
    }

    /**
     * Login and generate JWT token
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {

        // authenticate user
        User authenticatedUser =
                userService.authenticate(user.getEmail(), user.getPassword());

        // generate JWT
        String jwt = jwtUtil.generateToken(authenticatedUser.getEmail());

        return ResponseEntity.ok(jwt);
    }
}
