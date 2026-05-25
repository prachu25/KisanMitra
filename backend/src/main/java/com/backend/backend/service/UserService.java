package com.backend.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.backend.entity.User;
import com.backend.backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    // Get All Users
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    // Register
    public String registerUser(User user) {

        // Duplicate Email check
        if (userRepo.existsByEmail(user.getEmail())) {
            return "Email already exists";
        }

        // Password Validation
        if (user.getPassword().length() < 6) {
            return "Password must be atleast 6 characters";
        }

        // Phone Validation
        if (user.getPhone().length() != 10) {
            return "Phone Number Must be least 10 digits";
        }

        userRepo.save(user);

        return "user Register Successfully";
    }

    // Login
    public String loginUser(User user) {

        // Find User
        User existingUser = userRepo.findByEmail(user.getEmail());

        // User Check
        if (existingUser == null) {
            return "User Not Found";
        }

        // Password check
        if (!existingUser.getPassword().equals(user.getPassword())) {
            return "Invalid Password";
        }

        return "Login Successfully";
    }

    // Get User By Id
    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    // Update User Profile
    public String updateUser(Long id, User userUpdate) {

        User existingUser = userRepo.findById(id).orElse(null);

        if (existingUser == null) {
            return "User Not Found";
        }

        existingUser.setName(userUpdate.getName());
        existingUser.setEmail(userUpdate.getEmail());
        existingUser.setPassword(userUpdate.getPassword());
        existingUser.setPhone(userUpdate.getPhone());
        existingUser.setVillage(userUpdate.getVillage());

        userRepo.save(existingUser);

        return "User Updated Successfully";
    }

    // Delete User
    public String deleteUser(Long id) {

        User existingUser = userRepo.findById(id).orElse(null);

        if (existingUser == null) {
            return "User Not Found";
        }

        userRepo.deleteById(id);

        return "User Deleted Successfully";
    }

}
