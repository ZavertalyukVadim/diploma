package com.deploma.service;

import com.deploma.dao.RoomDao;
import com.deploma.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomDao roomDao;

    @Autowired
    public RoomService(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    public List<Room> getAllRooms(){
        Room room = new Room();
        room.setNumber(20);
        roomDao.save(room);
        return roomDao.findAll();
    }

    public Room getRoom(Integer id) {
        return roomDao.findOne(id);
    }
}
