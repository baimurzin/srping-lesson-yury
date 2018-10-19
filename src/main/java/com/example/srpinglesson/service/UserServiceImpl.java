package com.example.srpinglesson.service;

import com.example.srpinglesson.model.User;
import com.example.srpinglesson.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository repository;

    @Autowired
    public void setUserRepository(UserRepository repository){
        this.repository = repository;
    }

    @Override
    public User getUserById(Integer id) {
        Optional<User> user = this.repository.findById(id);
        if (user.isPresent()){
            User newUser = user.get();
            return newUser;
        }
        return null;
    }

    @Override
    public void saveUser(User user) {
        repository.save(user);
    }

    @Override
    public void updateUser(User user) {
        repository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        repository.deleteById(id);

    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
