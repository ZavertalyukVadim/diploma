package com.deploma.controller;

import com.deploma.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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
        Boolean role;
        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        role = !Objects.equals(auth.toString(), "anonymousUser");
        modelMap.addAttribute("role", role);
        modelMap.addAttribute("rents", rentService.getAllRents());
        return "rents";
    }

    @GetMapping(value = "/{id}")
    String getRent(@PathVariable(value = "id") Integer id,ModelMap modelMap){
        Boolean role;
        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        role = !Objects.equals(auth.toString(), "anonymousUser");
        modelMap.addAttribute("role", role);
        modelMap.addAttribute("rent", rentService.getRent(id));
        return "rent";
    }

    @PostMapping
    String addRent(ModelMap modelMap,
                   @RequestParam("doctor_id") Integer doctor_id,
                   @RequestParam("date") String date){
        modelMap.addAttribute("rent", rentService.addRent(doctor_id,date));
        Boolean role;
        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        role = !Objects.equals(auth.toString(), "anonymousUser");
        modelMap.addAttribute("role", role);
        return "redirect:/doctor/"+doctor_id;
    }

    @DeleteMapping(value = "/{id}")
    String deleteRent(@PathVariable(value = "id") Integer id){

        rentService.deleteRent(id);
        return "/";
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
