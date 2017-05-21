package com.deploma.controller;

import com.deploma.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/symptom")
public class SymptomController {
    private final SymptomService symptomService;

    @Autowired
    public SymptomController(SymptomService symptomService) {
        this.symptomService = symptomService;
    }

    @GetMapping(value = "/{id}")
    String getSymptom(@PathVariable(value = "id") Integer id, ModelMap modelMap) {
        modelMap.addAttribute("symptom", symptomService.getSymptom(id));
        return "symptom";
    }
}
