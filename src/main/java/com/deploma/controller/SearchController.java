package com.deploma.controller;

import com.deploma.service.DiseaseService;
import com.deploma.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class SearchController {
    private final DiseaseService diseaseService;
    private final SymptomService symptomService;

    @Autowired
    public SearchController(DiseaseService diseaseService, SymptomService symptomService) {
        this.diseaseService = diseaseService;
        this.symptomService = symptomService;
    }

    @PostMapping(value = "/search")
    public String search(@RequestParam("query") String symptoms
            , ModelMap modelMap) {
        Boolean role;
        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        role = !Objects.equals(auth.toString(), "anonymousUser");
        modelMap.addAttribute("role", role);
        modelMap.addAttribute("diseases", diseaseService.search(symptoms));
        return "searchResult";
    }

    @GetMapping(value = "/help")
    public String helpPage(ModelMap modelMap) {
        Boolean role;
        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        role = !Objects.equals(auth.toString(), "anonymousUser");
        modelMap.addAttribute("role", role);
        return "help";
    }

    @GetMapping(value = "/test")
    public String test(){
        diseaseService.test();
        return "home";
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
