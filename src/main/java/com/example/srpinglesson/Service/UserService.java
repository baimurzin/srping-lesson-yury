package com.example.srpinglesson.Service;

import com.example.srpinglesson.model.User;

import java.util.List;

public interface UserService {
        User getUserById(Integer id);
        void saveUser(User user);
        void updateUser(Integer id, String name, int age);
        void deleteUser(Integer id);
        List<User> findAll();
}
