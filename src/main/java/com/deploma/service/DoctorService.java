package com.deploma.service;

import com.deploma.dao.DoctorDao;
import com.deploma.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorDao doctorDao;

    @Autowired
    public DoctorService(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    public List<Doctor> getAllDoctors(){
        return doctorDao.findAll();
    }
}
