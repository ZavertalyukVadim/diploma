package com.deploma.dao;

import com.deploma.entity.Disease;
import com.deploma.entity.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
@Transactional
public interface DiseaseDao extends JpaRepository<Disease,Integer> {
    Disease getDiseaseBySymptoms(Set<Symptom> symptoms);
    List<Disease> getDiseasesBySymptoms(Set<Symptom> symptoms);
}
