package com.example.srpinglesson.repository;

import com.example.srpinglesson.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserRepository extends JpaRepository<AuthUser, Integer> {
    AuthUser findByLogin(String login);
}
