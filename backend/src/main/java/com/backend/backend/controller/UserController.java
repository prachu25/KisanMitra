package com.backend.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.entity.User;
import com.backend.backend.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userServ;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userServ.getAllUsers();
    }

    // Register User
    @PostMapping("/auth/register")
    public String registerUser(@RequestBody User user) {
        return userServ.registerUser(user);
    }

    // Login User
    @PostMapping("/auth/login")
    public String loginUser(@RequestBody User user) {
        return userServ.loginUser(user);
    }

    // Get User By Id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userServ.getUserById(id);
    }

    // Update User
    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable Long id,
            @RequestBody User user) {
        return userServ.updateUser(id, user);
    }

    // Delete User
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userServ.deleteUser(id);
    }

}
