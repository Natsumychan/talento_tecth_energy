package com.talentotech.energies.Services;

import com.talentotech.energies.DTO.UserRequest;
import com.talentotech.energies.Entities.User;
import com.talentotech.energies.Entities.User_role;
import com.talentotech.energies.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleService userRoleService;

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

    /*public User createUser(UserRequest userRequest) {
        User users = userRequest.getUsers();
        User user = userRepository.findById(userRequest.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        //List<User> user = userRepository.findAllById(userRequest.getUserIds());
        users.setRoleId(user);

        return userRepository.save(users);
    }*/

    public User createUser(User user, Optional<User_role> roleId) {
        roleId.ifPresent(user::setRoleId);
        return userRepository.save(user);
    }

    // Update user by documentId
    public User updateUserById(String documentId, User user) {

        // Check if user exists
        return userRepository.findById(documentId).map(existingUser ->{

            if(user.getDocumentId() != null) {
                existingUser.setDocumentId(user.getDocumentId());
            }
            if(user.getUserName() != null) {
                existingUser.setUserName(user.getUserName());
            }
            if(user.getUserLastName() != null) {
                existingUser.setUserLastName(user.getUserLastName());
            }
            if(user.getEmail() != null) {
                existingUser.setEmail(user.getEmail());
            }
            if(user.getPassword() != null) {
                existingUser.setPassword(user.getPassword());
            }
            if(user.getCreateAcounteDate() != null) {
                existingUser.setCreateAcounteDate(user.getCreateAcounteDate());
            }

            if (user.getRoleId() != null) {
                Optional<User_role> newRole = userRoleService.getUserRoleById(user.getRoleId().getRole());
                if (newRole.isPresent()) {
                    existingUser.setRoleId(newRole.get());
                } else {
                    throw new RuntimeException("Role with ID " + user.getRoleId().getRole() + " not found");
                }
            }

            // Save the update user
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new RuntimeException("User with ID " + documentId + " not found"));
    }

    // Update user rol
    public User updateUserRol (String documentId, User_role roleId) {
        Optional<User> optionalUser = userRepository.findById(documentId);
        if (optionalUser.isPresent()) {
            User users = optionalUser.get();
            users.setRoleId(roleId);
            return userRepository.save(users);
        } else {
            throw new RuntimeException("User not found with id" + documentId);
        }
    }

    // Metodo login de usuario
    public User loginUser (String documentId, String password) {
        Optional<User> userOptional = userRepository.findById(documentId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new RuntimeException("Documento o contraseña incorreta");
    }
}
