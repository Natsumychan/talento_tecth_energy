package com.talentotech.energies.Services;

import com.talentotech.energies.Entities.User;
import com.talentotech.energies.Entities.enums.UserRol;
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

    // Update user by documentId
    public User updateUserById(String documentoId, User updateUser) {

        // Check if user exists
        return userRepository.findById(documentoId).map(existingUser ->{
            // if exists update user
            if(updateUser.getUserName() != null) {
                existingUser.setUserName(updateUser.getUserName());
            }
            if(updateUser.getUserLastName() != null) {
                existingUser.setUserLastName(updateUser.getUserLastName());
            }
            if(updateUser.getEmail() != null) {
                existingUser.setEmail(updateUser.getEmail());
            }
            if(updateUser.getPassword() != null) {
                existingUser.setPassword(updateUser.getPassword());
            }
            if(updateUser.getCreateAcounteDate() != null) {
                existingUser.setCreateAcounteDate(updateUser.getCreateAcounteDate());
            }

            // Save the update user
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new RuntimeException("User with ID " + documentoId + " not found"));
    }
}
