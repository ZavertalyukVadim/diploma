package com.deploma.controller;

import com.deploma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping
//    public String getAllUsers(ModelMap modelMap) {
//        Boolean role;
//        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        role = !Objects.equals(auth.toString(), "anonymousUser");
//        modelMap.addAttribute("role", role);
//        modelMap.addAttribute("users", userService.getAllUsers());
//        return "users";
//    }

    @GetMapping()
    String getUser(ModelMap modelMap){
        Boolean role;
        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        role = !Objects.equals(auth.toString(), "anonymousUser");
        modelMap.addAttribute("role", role);
        modelMap.addAttribute("user", userService.getUserByUsername(getPrincipal()));
        return "user";
    }
    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

}
