package com.example.srpinglesson.service;

import com.example.srpinglesson.model.AuthUser;
import com.example.srpinglesson.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthUserServiceImpl implements AuthUserService{

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private AuthUserRepository authUserRepository;

    @Autowired
    public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder){
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @Autowired
    public void setAuthUserRepository(AuthUserRepository repository){
        this.authUserRepository = repository;
    }

    @Override
    public void saveAuthUser(AuthUser authUser) {
        authUser.setPassword(bCryptPasswordEncoder.encode(authUser.getPassword()));
        authUserRepository.save(authUser);
    }

    @Override
    public void deleteById(int id) {
        authUserRepository.deleteById(id);
    }
}
