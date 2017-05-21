package com.deploma.controller;

import com.deploma.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/disease")
public class DiseaseController {
    private final DiseaseService diseaseService;

    @Autowired
    public DiseaseController(DiseaseService diseaseService) {
        this.diseaseService = diseaseService;
    }

    @GetMapping
    String getAllDiseases(ModelMap modelMap) {

        modelMap.addAttribute("diseases", diseaseService.getAllDiseases());
        return "diseases";
    }

    @GetMapping(value = "/{id}")
    String getDisease(@PathVariable(value = "id") Integer id, ModelMap modelMap) {
        modelMap.addAttribute("disease", diseaseService.getDisease(id));
        return "disease";
    }
}
