package com.example.srpinglesson.controller;


import com.example.srpinglesson.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {

    private static final List<User> listUsers = new ArrayList<>();

    @GetMapping("/user")
    public String showUserByName(Model model) {
        model.addAttribute("users", listUsers);
        return "user";
    }

    @PostMapping("/delete")
    public String deleteUser(User user, Model model) {
        listUsers.remove(user);
        model.addAttribute("users", listUsers);
        return "user";
    }

    @GetMapping("/addUser")
    public String formAddUser(){
        return "addUser";
    }

    @PostMapping("/addUser")
    public String saveUserToList(@ModelAttribute("User") @Valid User user, BindingResult result, Model model){
        if (result.hasErrors()){
            if (result.hasFieldErrors("name")){
                model.addAttribute("nameError",result.getFieldError("name").getDefaultMessage());
            }
            validateInputForm(result, model);
            return "addUser";
        }else {
            listUsers.add(user);
            return "redirect:user";
        }
    }

    @GetMapping("/editUser")
    public String formEditUserToList(User user, Model model){
        int id = listUsers.indexOf(user);
        model.addAttribute("id", id);
        model.addAttribute("User",user);
        return "editUser";
    }

    @PostMapping("/editUser")
    public String editUserToList(@ModelAttribute("User") @Valid User user, int id, BindingResult result, Model model){
        if (result.hasErrors()){
            if (result.hasFieldErrors("name")){
                model.addAttribute("nameError",result.getFieldError("name").getDefaultMessage());
            }
            validateInputForm(result, model);
            return "addUser";
        }else {
            listUsers.remove(id);
            listUsers.add(id,user);
            return "redirect:user";
        }
    }

    private void validateInputForm(BindingResult result, Model model) {
        if (result.hasFieldErrors("age")){
            try {
                Integer.parseInt(result.getFieldError("age").getRejectedValue().toString());
            }catch (NumberFormatException e){
                throw new NullPointerException("Введите целое число");
            }
            model.addAttribute("ageError",result.getFieldError("age").getDefaultMessage());
        }
    }

    @RequestMapping(value = {"/","index"}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}


