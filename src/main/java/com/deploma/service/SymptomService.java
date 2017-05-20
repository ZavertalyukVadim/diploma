package com.deploma.service;

import com.deploma.dao.SymptomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SymptomService {
    private final SymptomDao symptomDao;

    @Autowired
    public SymptomService(SymptomDao symptomDao) {
        this.symptomDao = symptomDao;
    }
}
