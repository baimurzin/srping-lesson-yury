package com.example.srpinglesson.controller;

import com.example.srpinglesson.model.ResponseFindUserName;
import com.example.srpinglesson.service.UserService;
import com.example.srpinglesson.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
public class UserController {

    private UserService service;

    @Autowired
    public void setUserService(UserService service){
        this.service = service;
    }

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
            try {
                if (service.findName(user.getName()) != null){
                    service.saveUser(user);
                    return "redirect:user";
                }
            } catch (Exception e) {
                model.addAttribute("nameError",e.getLocalizedMessage());
                validateInputForm(result, model);
                return "addUser";
            }
            validateInputForm(result, model);
            return "addUser";
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
            service.updateUser(user);
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

    @PostMapping("/check")
    @ResponseBody
    public ResponseFindUserName checkUser(String name){
        User user = null;
        try {
            user = service.findName(name);
        } catch (Exception e) {
            String result = e.getMessage();
            return new ResponseFindUserName("Error",result);
        }
        if (user != null){
            String result = "true";
            return new ResponseFindUserName("Done",result);
        }else {
            String result = "false";
            return new ResponseFindUserName("Done",result);
        }
    }

    @RequestMapping(value = {"/","index"}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}


