package com.deploma.controller;

import com.deploma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping(value = "/{id}")
    String getUser(@PathVariable(value = "id") Integer id, ModelMap modelMap){
        modelMap.addAttribute("user", userService.getUser(id));
        return "user";
    }
}
