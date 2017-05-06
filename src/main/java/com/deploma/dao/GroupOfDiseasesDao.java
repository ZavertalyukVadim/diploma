package com.deploma.dao;

import com.deploma.entity.GroupOfDiseases;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupOfDiseasesDao extends JpaRepository<GroupOfDiseases,Integer> {
}
