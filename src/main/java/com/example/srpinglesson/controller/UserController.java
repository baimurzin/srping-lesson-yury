package com.example.srpinglesson.controller;


import com.example.srpinglesson.Service.UserService;
import com.example.srpinglesson.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {

    private UserService service;

    @Autowired
    public void setUserService(UserService service){
        this.service = service;
    }

    private static final List<User> listUsers = new ArrayList<>();

    @GetMapping("/user")
    public String showUserByName(Model model) {
        model.addAttribute("users",service.findAll());
        return "user";
    }

    @PostMapping("/delete")
    public String deleteUser(int id, Model model) {
        service.deleteUser(id);
        model.addAttribute("users", service.findAll());
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
            service.saveUser(user);
            return "redirect:user";
        }
    }

    @GetMapping("/editUser")
    public String formEditUserToList(User user, Model model){
        model.addAttribute("User",user);
        return "editUser";
    }

    @PostMapping("/editUser")
    public String editUserToList(@ModelAttribute("User") @Valid User user, BindingResult result, Model model){
        if (result.hasErrors()){
            if (result.hasFieldErrors("name")){
                model.addAttribute("nameError",result.getFieldError("name").getDefaultMessage());
            }
            validateInputForm(result, model);
            model.addAttribute("User",user);
            return "addUser";
        }else {
            service.updateUser(user.getId(),user.getName(),user.getAge());
            return "redirect:user";
        }
    }

    private String validateInputForm(BindingResult result, Model model) {
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
    }

    @RequestMapping(value = {"/","index"}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}


