package com.deploma.dao;

import com.deploma.entity.Disease;
import com.deploma.entity.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Transactional
public interface DiseaseDao extends JpaRepository<Disease, Integer> {
    //    Disease getDiseaseBySymptomsHql(@Param("symptoms") Set<Symptom> symptoms);
//    @Query("select d from Disease d where d.symptoms like :symptoms")
    List<Disease> findBySymptomsIn(Set<Symptom> symptoms);
}
