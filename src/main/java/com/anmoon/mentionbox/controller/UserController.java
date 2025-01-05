package com.anmoon.mentionbox.controller;

import com.anmoon.mentionbox.entity.UserEntity;
import com.anmoon.mentionbox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
//@Api(tags = "User Controller")
public class UserController { // implments softdelete

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
//    @ApiOperation(value = "Get all users", notes = "Returns a pageable list of all users.")
    public Page<UserEntity> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
//    @ApiOperation(value = "Get user by ID", notes = "Returns a user based on ID.")
    public UserEntity getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping
//    @ApiOperation(value = "Create a new user", notes = "Creates a new user.")
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
//    @ApiOperation(value = "Update user by ID", notes = "Updates a user based on ID.")
    public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity updatedUser) {
        UserEntity existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setPassword(updatedUser.getPassword());
            return userRepository.save(existingUser);
        } else {
            return null; // Handle not found scenario
        }
    }

    @DeleteMapping("/{id}")
//    @ApiOperation(value = "Delete user by ID", notes = "Deletes a user based on ID.")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
