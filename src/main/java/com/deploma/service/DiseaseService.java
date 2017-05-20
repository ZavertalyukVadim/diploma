package com.deploma.service;

import com.deploma.dao.DiseaseDao;
import com.deploma.entity.Disease;
import com.deploma.entity.Symptom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseService {
    private final DiseaseDao diseaseDao;

    @Autowired
    public DiseaseService(DiseaseDao diseaseDao) {
        this.diseaseDao = diseaseDao;
    }

    public List<Disease> search(List<Symptom> symptoms){
        return diseaseDao.getDiseaseBySymptoms(symptoms);
    }
}
