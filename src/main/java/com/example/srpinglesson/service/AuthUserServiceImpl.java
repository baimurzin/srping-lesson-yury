package com.example.srpinglesson.service;

import com.example.srpinglesson.model.AuthUser;
import com.example.srpinglesson.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthUserServiceImpl implements AuthUserService{

    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private AuthUserRepository authUserRepository;

    @Override
    public void saveAuthUser(AuthUser authUser) {
        authUser.setPassword(passwordEncoder().encode(authUser.getPassword()));
        authUserRepository.save(authUser);
    }

    @Override
    public void deleteById(int id) {
        authUserRepository.deleteById(id);
    }

    @Override
    public AuthUser findByLogin(String login) {
        return authUserRepository.findByLogin(login);
    }

    @Override
    public List<AuthUser> findAll() {
        return authUserRepository.findAllByOrderByIdAsc();
    }

    @Override
    public AuthUser findById(int id) {
        return authUserRepository.findById(id);
    }

    @Override
    public void updateAuthUser(AuthUser authUser) {
        authUserRepository.save(authUser);
    }
}
