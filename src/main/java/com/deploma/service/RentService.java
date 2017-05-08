package com.deploma.service;

import com.deploma.dao.RentDao;
import com.deploma.entity.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService {
    private final RentDao rentDao;

    @Autowired
    public RentService(RentDao rentDao) {
        this.rentDao = rentDao;
    }

    public List<Rent> getAllRents(){
        return rentDao.findAll();
    }
}
