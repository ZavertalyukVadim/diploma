package com.deploma.dao;

import com.deploma.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorDao extends JpaRepository<Doctor,Integer>{
}
