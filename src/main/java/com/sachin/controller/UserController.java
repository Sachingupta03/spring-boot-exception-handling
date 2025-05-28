package com.sachin.controller;

import com.sachin.model.User;
import com.sachin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    // GET User by Name with ResponseEntity
    @GetMapping("/name/{name}")
    public ResponseEntity<User> getUserName(@PathVariable String name) {
        User user = userService.getUserName(name);
        if (user != null) {
            return ResponseEntity.ok(user); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    //  GET User by Email with ResponseEntity
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserEmail(@PathVariable String email){
        User user = userService.getUserEmail(email);
        if (user != null) {
            return ResponseEntity.ok(user); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {
        User user = userService.updateUser(id, updatedUser);
        if (user != null) {
            return ResponseEntity.ok(user); // 200 OK with updated user
        } else {
            return ResponseEntity.notFound().build(); // 404 if user not found
        }
    }


    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
