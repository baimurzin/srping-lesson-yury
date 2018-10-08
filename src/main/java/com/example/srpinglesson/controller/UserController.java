package com.example.srpinglesson.controller;


import com.example.srpinglesson.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.peer.ListPeer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class UserController {


    private static final List<User> listUsers = new ArrayList<>();

    //localhost:8080/user/vlad
    @RequestMapping("/user/{name}")
    public String showUserByName(@PathVariable String name, Model model) {

        //pass string to view
        model.addAttribute("name", name);

        User user = new User(name, 20);

        //pass object to view
        model.addAttribute("user", user);


        //pass list of objects<User> to view
        List<User> userList = new ArrayList<>();
        userList.add(new User("test1", 12));
        userList.add(new User("test2", 15));
        userList.add(new User("test3", 16));
        userList.add(new User("test4", 17));
        userList.add(new User("test5", 13));
        userList.add(new User("test6", 30));

        model.addAttribute("users", userList);

        return "user";
    }


}
