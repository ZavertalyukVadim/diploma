package com.deploma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String homePage(ModelMap modelMap){
        return "home";
    }

    @GetMapping(value = "/help")
    public String helpPage(ModelMap modelMap){
        return "help";
    }
}
