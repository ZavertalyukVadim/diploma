package com.deploma.controller;

import com.deploma.service.DiseaseService;
import com.deploma.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        modelMap.addAttribute("diseases", diseaseService.search(symptoms));
        return "searchResult";
    }

    @GetMapping(value = "/help")
    public String helpPage(ModelMap modelMap) {
        return "help";
    }

    @GetMapping(value = "/test")
    public String test(){
        diseaseService.test();
        return "home";
    }
}
