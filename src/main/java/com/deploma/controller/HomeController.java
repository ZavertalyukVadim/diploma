package com.deploma.controller;

import com.deploma.entity.TestEntity;
import com.deploma.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class HomeController {
    private final TestService testService;

    @Autowired
    public HomeController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping(value = "/")
    public String homePage(ModelMap modelMap){
        modelMap.addAttribute("tests", testService.getTestData());
        return "home";
    }
}
