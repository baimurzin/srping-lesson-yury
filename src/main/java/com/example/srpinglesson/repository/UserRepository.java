package com.example.srpinglesson.repository;

import com.example.srpinglesson.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByName(String name);
    List<User> findAllByOrderByIdAsc();
}
