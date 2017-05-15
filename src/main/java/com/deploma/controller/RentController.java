package com.deploma.controller;

import com.deploma.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/rent")
public class RentController {
    private final RentService rentService;

    @Autowired
    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping
    String getAllRents(ModelMap modelMap){
        modelMap.addAttribute("rents", rentService.getAllRents());
        return "rents";
    }

    @GetMapping(value = "/{id}")
    String getRent(@PathVariable(value = "id") Integer id,ModelMap modelMap){
        modelMap.addAttribute("rent", rentService.getRent(id));
        return "rent";
    }
}
