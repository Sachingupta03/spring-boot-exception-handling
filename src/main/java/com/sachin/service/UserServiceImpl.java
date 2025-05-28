package com.sachin.service;

import com.sachin.exception.UserEmailNotFoundException;
import com.sachin.exception.UserNameNotFoundException;
import com.sachin.exception.UserNotFoundException;
import com.sachin.model.User;
import com.sachin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll(); // Return all users from DB
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserName(String name) {
        User user = userRepository.getByName(name);
        if (user == null) {
            throw new UserNameNotFoundException("User Name not found with name: " + name);
        }
        return user;
    }

    @Override
    public User getUserEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserEmailNotFoundException("User not found with email: " + email);
        }
        return user;
    }

    @Override
    public User updateUser(Integer id, User updatedUser) {
        User existingUser = getUserById(id);
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        return userRepository.save(existingUser);
    }

    @Override
    public User updateUserEmailOnly(Integer id, String newEmail) {
        User existingUser = getUserById(id);
        existingUser.setEmail(newEmail);
        return userRepository.save(existingUser);
    }
}
