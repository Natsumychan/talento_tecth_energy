package com.talentotech.energies.Controllers;

import com.talentotech.energies.DTO.UserRequest;
import com.talentotech.energies.Entities.User;
import com.talentotech.energies.Entities.User_role;
import com.talentotech.energies.Repositories.User_roleRepository;
import com.talentotech.energies.Services.UserRoleService;
import com.talentotech.energies.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserControllers {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    /*// Post users
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User users) {
        User savedUser = userService.saveUser(users);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }*/

    // Post users
    @PostMapping
    public User createUser(@RequestBody UserRequest user) {
        int role = user.getRole();
        Optional<User_role> roleId = userRoleService.getUserRoleById(role);
        User createUsers = user.getUsers();
        return userService.createUser(createUsers, roleId);
    }

    // Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Get all users
    @GetMapping("/{documentId}")
    public ResponseEntity<User> getDocumentById(@PathVariable String documentId) {
        Optional<User> users = userService.getUserById(documentId);
        return users.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    // Delete user by Id
    @DeleteMapping("/{documentId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String documentId) {
        userService.deleteUser(documentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Update user by Id
    @PutMapping ("/{documentId}")
    public ResponseEntity<User> updateUser(@PathVariable String documentId, @RequestBody User users) {
        User partialUpdateUser = new User();
        if (users.getUserName() != null) {
            partialUpdateUser.setUserName(users.getUserName());
        }
        if (users.getUserLastName() != null) {
            partialUpdateUser.setUserLastName(users.getUserLastName());
        }
        if (users.getEmail() != null) {
            partialUpdateUser.setEmail(users.getEmail());
        }
        if (users.getPassword() != null) {
            partialUpdateUser.setPassword(users.getPassword());
        }
        if (users.getCreateAcounteDate() != null) {
            partialUpdateUser.setCreateAcounteDate(users.getCreateAcounteDate());
        }
        User updUser = userService.updateUserById(documentId, partialUpdateUser);
        return new ResponseEntity<>(updUser, HttpStatus.OK);
    }

    // Update user rol by Id
    @PutMapping ("/rol/{documentId}")
    public ResponseEntity<User> updateRole(@PathVariable String documentId, @RequestBody User_role roleId) {
        User updateUser = userService.updateUserRol(documentId, roleId);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

}
