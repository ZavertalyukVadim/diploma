package com.deploma.service;

import com.deploma.dao.DiseaseDao;
import com.deploma.dao.SymptomDao;
import com.deploma.entity.Disease;
import com.deploma.entity.Symptom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class DiseaseService {
    private final DiseaseDao diseaseDao;
    private final SymptomDao symptomDao;

    @Autowired
    public DiseaseService(DiseaseDao diseaseDao, SymptomDao symptomDao) {
        this.diseaseDao = diseaseDao;
        this.symptomDao = symptomDao;
    }

    public Disease search(String symptoms) {
        System.out.println(diseaseDao.findAll());
        String[] test = symptoms.trim().split("\\p{P}?[ \\t\\n\\r]+");
        Set<Symptom> symptomList = new HashSet<>();
        for (String s : test) {
            Symptom symptom = symptomDao.getSymptomByName(s.trim());
            symptomList.add(symptom);
            System.out.println(symptomList);
        }
        System.out.println(diseaseDao.getDiseasesBySymptoms(symptomList));
        return diseaseDao.getDiseaseBySymptoms(symptomList);
    }

    public void test() {
        Symptom symptom = new Symptom();
        symptom.setName("mom");
        symptomDao.save(symptom);
        Symptom symptom1 = new Symptom();
        symptom1.setName("hello");
        symptomDao.save(symptom1);
        Symptom symptom2 = new Symptom();
        symptom2.setName("qwerty");
        symptomDao.save(symptom2);
        Disease disease = new Disease();
        Set<Symptom> symptomList = new HashSet<>();
        symptomList.add(symptom);
        symptomList.add(symptom1);
        symptomList.add(symptom2);
        disease.setSymptoms(symptomList);
        disease.setName("disease");
        diseaseDao.save(disease);
    }
}
