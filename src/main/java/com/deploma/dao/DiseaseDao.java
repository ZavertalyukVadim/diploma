package com.deploma.dao;

import com.deploma.entity.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseDao extends JpaRepository<Disease,Integer> {
}
