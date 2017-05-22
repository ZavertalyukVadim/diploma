package com.deploma.service;

import com.deploma.dao.DoctorDao;
import com.deploma.dao.RentDao;
import com.deploma.dao.UserDao;
import com.deploma.entity.Doctor;
import com.deploma.entity.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService {
    private final RentDao rentDao;
    private final DoctorDao doctorDao;
    private final UserDao userDao;

    @Autowired
    public RentService(RentDao rentDao, DoctorDao doctorDao, UserDao userDao) {
        this.rentDao = rentDao;
        this.doctorDao = doctorDao;
        this.userDao = userDao;
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
        rent.setUser(userDao.getUserByUsername(getPrincipal()));
        rent.setDoctor(doctor);
        rent.setDate(date);
        return rentDao.save(rent);
    }

    public void deleteRent(Integer id) {
        rentDao.delete(id);
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
