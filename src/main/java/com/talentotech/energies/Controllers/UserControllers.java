package com.talentotech.energies.Controllers;

import com.talentotech.energies.Entities.User;
import com.talentotech.energies.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControllers {

    @Autowired
    private UserService userService;

    // Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
