package com.deploma.controller;


import com.deploma.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    String getAllDoctors(ModelMap modelMap){

        modelMap.addAttribute("doctors", doctorService.getAllDoctors());
        return "doctor";
    }
}
