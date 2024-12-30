package com.example.commonProject.controllers;


import com.example.commonProject.DTO.UserDTO;
import com.example.commonProject.entities.User;
import com.example.commonProject.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:127.0.0.1" })
@RestController
@RequestMapping("/users")
public class UserContoller {

    public UserService userService;

    public UserContoller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        UserDTO userDTO = new UserDTO("Jim", "jim@i.ua",23);

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
        System.out.println(user.toString());

        return  userService.create(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.findAll().stream().filter(user -> user.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("User not found"));
    }
}
