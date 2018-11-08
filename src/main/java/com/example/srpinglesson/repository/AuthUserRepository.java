package com.example.srpinglesson.repository;

import com.example.srpinglesson.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthUserRepository extends JpaRepository<AuthUser, Integer> {
    AuthUser findByLogin(String login);
    AuthUser findById(int id);
    List<AuthUser> findAllByOrderByIdAsc();
}
