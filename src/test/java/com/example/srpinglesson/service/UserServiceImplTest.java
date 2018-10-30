package com.example.srpinglesson.service;

import com.example.srpinglesson.model.User;
import com.example.srpinglesson.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserServiceImplTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository;

    @Before
    public void addEntity(){
        User user = new User("Test 1",22);
        User user2 = new User("Test 2",32);
        User user3 = new User("Test 3",42);
        User user4 = new User("Test 4",52);
        entityManager.persist(user);
        entityManager.persist(user2);
        entityManager.persist(user3);
        entityManager.persist(user4);
        entityManager.flush();
    }

    @Test
    public void getUserById() {
        assertNotNull(repository.findById(4));
    }

    @Test
    public void findByName() {
        assertNotNull(repository.findByName("Test 3"));
     }

     @Test
     public void findAll(){
        assertNotNull(repository.findAllByOrderByIdAsc());
     }
}