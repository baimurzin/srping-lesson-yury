package com.example.srpinglesson.service;

import com.example.srpinglesson.model.AuthUser;

import java.util.List;

public interface AuthUserService {
    void saveAuthUser(AuthUser authUser);
    void deleteById(int id);
    AuthUser findByLogin(String login);
    List<AuthUser> findAll();
    AuthUser findById(int id);
    void updateAuthUser(AuthUser authUser);
}
