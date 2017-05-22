package com.deploma.dao;

import com.deploma.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer>{
    User getUserByUsername(String username);
}
