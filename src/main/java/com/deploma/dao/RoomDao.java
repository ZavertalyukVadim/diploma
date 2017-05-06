package com.deploma.dao;

import com.deploma.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<Room,Integer> {
}
