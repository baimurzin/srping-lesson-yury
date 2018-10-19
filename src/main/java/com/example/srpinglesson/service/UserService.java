package com.example.srpinglesson.service;

import com.example.srpinglesson.model.User;

import java.util.List;

public interface UserService {
        User getUserById(Integer id);
        void saveUser(User user);
        void updateUser(User user);
        void deleteUser(Integer id);
        List<User> findAll();
}
