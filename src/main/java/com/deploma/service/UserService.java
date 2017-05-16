package com.deploma.service;

import com.deploma.dao.UserDao;
import com.deploma.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers(){
        User user =  new User();
        user.setFirstName("Petr");
        user.setLastName("Petrov");
        user.setUsername("petryshka");
        userDao.save(user);
        return userDao.findAll();
    }

    public User getUser(Integer id) {
        return userDao.findOne(id);
    }
}
