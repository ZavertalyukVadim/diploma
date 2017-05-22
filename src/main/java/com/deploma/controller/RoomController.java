package com.deploma.controller;


import com.deploma.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Controller
@RequestMapping(value = "/room")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    String getAllRooms(ModelMap modelMap){
        Boolean role;
        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        role = !Objects.equals(auth.toString(), "anonymousUser");
        modelMap.addAttribute("role", role);
        modelMap.addAttribute("rooms", roomService.getAllRooms());
        return "rooms";
    }

    @GetMapping(value = "/{id}")
    String getRoom(@PathVariable(value = "id") Integer id, ModelMap modelMap){
        Boolean role;
        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        role = !Objects.equals(auth.toString(), "anonymousUser");
        modelMap.addAttribute("role", role);
        modelMap.addAttribute("room", roomService.getRoom(id));
        return "room";
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
