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

    public Set<Disease> search(String symp) {
        String[] symptomsStrings = symp.trim().split("\\p{P}?[ \\t\\n\\r]+");
        Set<Symptom> symptoms = new HashSet<>();
        for (String s : symptomsStrings) {
            Symptom symptom = symptomDao.getSymptomByName(s);
            symptoms.add(symptom);
        }
        return diseaseDao.findBySymptomsIsIn(symptoms);
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
        Disease disease1 =  new Disease();
        disease1.setName("disease1");
        Set<Symptom> symptomList1 = new HashSet<>();
        symptomList1.add(symptom);
        symptomList1.add(symptom1);
        disease1.setSymptoms(symptomList1);
        diseaseDao.save(disease1);
        Disease disease2 =  new Disease();
        disease2.setName("disease2");
        Set<Symptom> symptomList2 = new HashSet<>();
        symptomList2.add(symptom);
        symptomList2.add(symptom1);
        disease2.setSymptoms(symptomList2);
        diseaseDao.save(disease2);
    }
}
