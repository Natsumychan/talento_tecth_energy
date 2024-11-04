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
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/")
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
    public ResponseEntity<User> updateUser(
            @PathVariable String documentId,
            @RequestBody UserRequest userRequest
    ) {
        Integer roleId = userRequest.getRole();
        Optional<User_role> newRole = userRoleService.getUserRoleById(roleId);
        if (newRole.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        User user = userRequest.getUsers();
        if (!user.getDocumentId().equals(documentId)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User partialUpdateUser = new User();
        if (user.getUserName() != null) {
            partialUpdateUser.setUserName(user.getUserName());
        }
        if (user.getUserLastName() != null) {
            partialUpdateUser.setUserLastName(user.getUserLastName());
        }
        if (user.getEmail() != null) {
            partialUpdateUser.setEmail(user.getEmail());
        }
        if (user.getPassword() != null) {
            partialUpdateUser.setPassword(user.getPassword());
        }
        if (user.getCreateAcounteDate() != null) {
            partialUpdateUser.setCreateAcounteDate(user.getCreateAcounteDate());
        }

        partialUpdateUser.setRoleId(newRole.get());

        User updateUser = userService.updateUserById(documentId, partialUpdateUser);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String documentId = loginRequest.get("documentId");
        String password = loginRequest.get("password");

        try {
            User user = userService.loginUser(documentId, password);
            // Generar token u otra respuesta si es necesario
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

}
