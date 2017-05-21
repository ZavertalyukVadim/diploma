package com.deploma.dao;

import com.deploma.entity.Disease;
import com.deploma.entity.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface DiseaseDao extends JpaRepository<Disease, Integer> {
    @Query("SELECT d FROM Disease d inner join d.symptoms symptoms where symptoms in :#{#symptoms} group by d ")
    Set<Disease> findBySymptomsIsIn(@Param("symptoms") Set<Symptom> symptoms);
}
