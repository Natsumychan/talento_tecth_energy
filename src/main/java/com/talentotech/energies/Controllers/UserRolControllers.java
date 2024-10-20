package com.talentotech.energies.Controllers;

import com.talentotech.energies.Entities.User;
import com.talentotech.energies.Entities.User_role;
import com.talentotech.energies.Services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class UserRolControllers {

    @Autowired
    private UserRoleService userRoleService;

    // Create user role
    @PostMapping
    public ResponseEntity<User_role> createUserRole(@RequestBody User_role userRole) {
        User_role savedUserRole = userRoleService.createUserRole(userRole);
        return new ResponseEntity<>(savedUserRole, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User_role>> getAllUserRole() {
        List<User_role> userRoles = userRoleService.getAllUserRole();
        return new ResponseEntity<>(userRoles, HttpStatus.OK);
    }

}
