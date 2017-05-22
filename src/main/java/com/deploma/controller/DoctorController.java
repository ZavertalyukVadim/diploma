package com.deploma.controller;


import com.deploma.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Controller
@RequestMapping(value = "/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    String getAllDoctors(ModelMap modelMap) {
        Boolean role;
        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        role = !Objects.equals(auth.toString(), "anonymousUser");
        modelMap.addAttribute("role", role);
        modelMap.addAttribute("doctors", doctorService.getAllDoctors());
        return "doctors";
    }

    @GetMapping(value = "/{id}")
    String getDoctor(@PathVariable(value = "id") Integer id, ModelMap modelMap) {
        Boolean role;
        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        role = !Objects.equals(auth.toString(), "anonymousUser");
        modelMap.addAttribute("role", role);
        modelMap.addAttribute("doctor", doctorService.getDoctor(id));
        return "doctor";
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
