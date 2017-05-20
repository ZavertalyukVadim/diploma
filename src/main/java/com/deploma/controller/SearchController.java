package com.deploma.controller;

import com.deploma.entity.Symptom;
import com.deploma.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/search")
public class SearchController {
    private final DiseaseService diseaseService;

    @Autowired
    public SearchController(DiseaseService diseaseService) {
        this.diseaseService = diseaseService;
    }

    @PostMapping(value = "/search")
    public String search(@RequestParam("symptoms[]") List<Symptom> symptoms
            ,ModelMap modelMap) {
        modelMap.addAttribute("diseases",diseaseService.search(symptoms));
        return "searchResult";
    }
}
