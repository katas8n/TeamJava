package com.example.commonProject.controllers;


import com.example.commonProject.DTO.UserDTO;
import com.example.commonProject.entities.User;
import com.example.commonProject.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:5173" })
@RestController
@RequestMapping("/users")
public class UserContoller {

    public UserService userService;

    public UserContoller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        UserDTO userDTO = new UserDTO("Jim", "jim@i.ua");

        System.out.println(userDTO.getName());
        System.out.println(userDTO.getEmail());

        userDTO.setEmail("new@Email");
        userDTO.setName("Something");

        System.out.println(userDTO.getName());
        System.out.println(userDTO.getEmail());

        return userService.findAll();
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return  userService.create(user);
    }
}
