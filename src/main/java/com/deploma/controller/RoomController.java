package com.deploma.controller;


import com.deploma.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/room")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    String getAllRooms(ModelMap modelMap){
        modelMap.addAttribute("rooms", roomService.getAllRooms());
        return "rooms";
    }

}
