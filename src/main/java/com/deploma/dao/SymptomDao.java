package com.deploma.dao;

import com.deploma.entity.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SymptomDao extends JpaRepository<Symptom,Integer> {
    Symptom getSymptomByName(String s);
}
