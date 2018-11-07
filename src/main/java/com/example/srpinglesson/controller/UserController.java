package com.example.srpinglesson.controller;

import com.example.srpinglesson.exeptions.SeveralFindUsersException;
import com.example.srpinglesson.model.AuthUser;
import com.example.srpinglesson.model.Response;
import com.example.srpinglesson.security.roles.Roles;
import com.example.srpinglesson.service.AuthUserService;
import com.example.srpinglesson.service.UserService;
import com.example.srpinglesson.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    private UserService service;
    private AuthUserService authUserService;

    @Autowired
    public void setService(UserService service, AuthUserService authUserService){
        this.service = service;
        this.authUserService = authUserService;
    }

    @GetMapping("/user")
    public String showAllUsers(Model model) {
        model.addAttribute("users",service.findAllOrderById());
        return "user";
    }

    @PostMapping("/delete")
    public String deleteUserFromDB(int id, Model model) {
        service.deleteUser(id);
        model.addAttribute("users", service.findAll());
        return "user";
    }

    @GetMapping("/addUser")
    public String showFormAddUser(){
        return "addUser";
    }

    @PostMapping("/addUser")
    public String saveUserToDB(@ModelAttribute("User") @Valid User user, BindingResult result, Model model){
        if (result.hasErrors()){
            if (result.hasFieldErrors("name")){
                model.addAttribute("nameError",result.getFieldError("name").getDefaultMessage());
            }
            validateInputForm(result, model);
            return "addUser";
        }else {
            try {
                User findUser = service.findName(user.getName());
                if (findUser == null){
                    service.saveUser(user);
                    return "redirect:user";
                }else {
                    model.addAttribute("nameError","Пользователь уже существует");
                    validateInputForm(result, model);
                    return "addUser";
                }
            } catch (SeveralFindUsersException e) {
                model.addAttribute("nameError",e.getMessage());
                validateInputForm(result, model);
                return "addUser";
            }
        }
    }

    @GetMapping("/editUser")
    public String showFormEditUser(User user, Model model){
        model.addAttribute("User",user);
        return "editUser";
    }

    @PostMapping("/editUser")
    public String editUserFromDB(@ModelAttribute("User") @Valid User user, BindingResult result, Model model){
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
    public Response AjaxCheckExistUser(String name){
        User user = null;
        try {
            user = service.findName(name);
        } catch (Exception e) {
            String result = e.getMessage();
            return new Response("Error",result);
        }
        if (user != null){
            String result = "true";
            return new Response("Done",result);
        }else {
            String result = "false";
            return new Response("Done",result);
        }
    }

    @GetMapping(value = {"/","index"})
    public String index(){
        return "index";
    }

    @GetMapping("/registration")
    public String showRegistrationForm(){
        return "registration";
    }

    @PostMapping("/registration")
    public String saveNewAuthUserToDB(@Valid AuthUser authUser, BindingResult result, String confirmPassword, Model model){
        if (result.hasErrors()){
            if (result.getFieldError("login")!= null){
                model.addAttribute("loginError", result.getFieldError("login").getDefaultMessage());
            }
            if (result.getFieldError("password") != null){
                model.addAttribute("passwordError", result.getFieldError("password").getDefaultMessage());
            }
            if (!authUser.getPassword().equals(confirmPassword)){
                model.addAttribute("confirmPasswordError","Пароли должны совпадать.");
            }
            if (result.getFieldError("email") != null){
                model.addAttribute("emailError",result.getFieldError("email").getDefaultMessage());
            }
            return "registration";
        }else {
            if (authUserService.findByLogin(authUser.getLogin()) == null) {
                authUser.setActive(true);
                Set<Roles> roles = new HashSet<>();
                roles.add(Roles.USER);
                authUser.setRoles(roles);
                authUserService.saveAuthUser(authUser);
                model.addAttribute("success", "Пользователь добавлен");
                return "registration";
            } else {
                model.addAttribute("failure", "Пользователь с таким логином существует");
                return "registration";
            }
        }
    }

    @GetMapping("/login")
    public String loginUser(){
        return "login";
    }

    @GetMapping("/authUser")
    public String showAllAuthUser(Model model){
        List<AuthUser> authUserList = authUserService.findAll();
        for (AuthUser authUser : authUserList) {
            authUser.setPassword("noop");
        }
        model.addAttribute("listAuthUser",authUserList);
        return "authUser";
    }
    @PostMapping("/deleteAuthUser")
    public String deleteAuthUserToId(){
        return "deleteAuthUser";
    }

    @PostMapping("/active")
    public String activeAndDeactivatedAuthUUser(){
        return "active";
    }
}


