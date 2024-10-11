package com.talentotech.energies.Services;

import com.talentotech.energies.Entities.User;
import com.talentotech.energies.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by document
    public Optional<User> getUserById(String documentId) {
        return userRepository.findById(documentId);
    }

    // Delete user by document
    public void deleteUser(String documentId) {
        userRepository.deleteById(documentId);
    }

    // Insert user
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
