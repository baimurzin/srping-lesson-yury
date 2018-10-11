package com.example.srpinglesson.controller;


import com.example.srpinglesson.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {

    private static final List<User> listUsers = new ArrayList<>();

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String showUserByName(Model model) {
        model.addAttribute("users", listUsers);
        return "user";
    }

    @GetMapping("/addUser")
    public String addUser(){
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUserSave(@ModelAttribute("User") @Valid User user, BindingResult result, Model model){
        if (result.hasErrors()){
            if (result.hasFieldErrors("name")){
                model.addAttribute("nameError",result.getFieldError("name").getDefaultMessage());
            }
            if (result.hasFieldErrors("age")){
                try {
                    Integer.parseInt(result.getFieldError("age").getRejectedValue().toString());
                }catch (NumberFormatException e){
                    model.addAttribute("ageError", new String("Введите целое число"));
                    return "addUser";
                }catch (Exception e){
                    model.addAttribute("ageError", new String("Что-то пошло не так."));
                    return "addUser";
                }
                model.addAttribute("ageError",result.getFieldError("age").getDefaultMessage());
            }
            return "addUser";
        }else {
            listUsers.add(user);
            return "redirect:/user";
        }
    }

    @RequestMapping(value = {"/","index"}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}


