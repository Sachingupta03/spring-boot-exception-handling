package com.sachin.service;

import com.sachin.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Integer id);

    List<User> getAllUser = List.of ();

    List<User> getAllUsers();

    User addUser(User user);

    User getUserName(String name);

    User getUserEmail(String email);

    User updateUserEmailOnly(Integer id, String newEmail);

    User updateUser(Integer id, User updatedUser);

}