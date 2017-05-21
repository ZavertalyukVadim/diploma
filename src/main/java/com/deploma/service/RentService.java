package com.deploma.service;

import com.deploma.dao.DoctorDao;
import com.deploma.dao.RentDao;
import com.deploma.entity.Doctor;
import com.deploma.entity.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService {
    private final RentDao rentDao;
    private final DoctorDao doctorDao;

    @Autowired
    public RentService(RentDao rentDao, DoctorDao doctorDao) {
        this.rentDao = rentDao;
        this.doctorDao = doctorDao;
    }

    public List<Rent> getAllRents(){
        return rentDao.findAll();
    }

    public Rent getRent(Integer id) {
        return rentDao.findOne(id);
    }

    public Rent addRent(Integer doctor_id,String date) {
        Rent rent =  new Rent();
        List<Rent> rents = rentDao.findAll();
        for (Rent rent1:rents){
            if (rent1.getDate().contains(date))
                return null;
        }
        Doctor doctor = doctorDao.findOne(doctor_id);
        rent.setDoctor(doctor);
        rent.setDate(date);
        return rentDao.save(rent);
    }

    public void deleteRent(Integer id) {
        rentDao.delete(id);
    }
}
