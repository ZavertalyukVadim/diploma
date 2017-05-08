package com.deploma.controller;

import com.deploma.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/rent")
public class RentController {
    private final RentService rentService;

    @Autowired
    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    String getAllRents(ModelMap modelMap){
        modelMap.addAttribute("rents", rentService.getAllRents());
        return "rent";
    }
}
