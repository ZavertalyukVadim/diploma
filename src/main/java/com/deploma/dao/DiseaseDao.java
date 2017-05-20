package com.deploma.dao;

import com.deploma.entity.Disease;
import com.deploma.entity.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiseaseDao extends JpaRepository<Disease,Integer> {
    List<Disease> getDiseaseBySymptoms(List<Symptom> symptoms);
}
