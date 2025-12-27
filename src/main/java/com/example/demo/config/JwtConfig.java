package com.example.demo.config;

import com.example.demo.security.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Bean
    public JwtUtil jwtUtil() {
        // Same values used in tests
        String secret = "SuperSecretJwtKeyForDemoProject123";
        long expiration = 3600000; // 1 hour
        return new JwtUtil(secret, expiration);
    }
}
