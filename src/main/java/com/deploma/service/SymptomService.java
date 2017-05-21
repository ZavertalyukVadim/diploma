package com.deploma.service;

import com.deploma.dao.SymptomDao;
import com.deploma.entity.Symptom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SymptomService {
    private final SymptomDao symptomDao;

    @Autowired
    public SymptomService(SymptomDao symptomDao) {
        this.symptomDao = symptomDao;
    }

    public Symptom getSymptom(Integer id) {
        return symptomDao.findOne(id);
    }
}
