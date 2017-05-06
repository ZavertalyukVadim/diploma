package com.deploma.dao;

import com.deploma.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentDao extends JpaRepository<Rent,Integer>{
}
