package com.example.srpinglesson.controller;


import com.example.srpinglesson.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {

    private static final List<User> listUsers = new ArrayList<>();

    //localhost:8080/user/vlad
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String showUserByName(Model model) {

        model.addAttribute("users", listUsers);

        return "user";
    }

    @RequestMapping(value = "/user/{user}", method = RequestMethod.POST)
    public String showUserAndAddNewUser(User user, Model model) {
        listUsers.add(user);
        model.addAttribute("users", listUsers);

        return "user";
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser(){

        return "addUser";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUserSave(@PathParam("name") String name, @PathParam("age") int age){
        User user = new User(name,age);
        listUsers.add(user);

        return "redirect:/user";
    }

    @RequestMapping(value = {"/","index"}, method = RequestMethod.GET)
    public String index(){

        return "index";
    }
}


