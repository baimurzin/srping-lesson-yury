package com.example.srpinglesson.repository;

import com.example.srpinglesson.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}