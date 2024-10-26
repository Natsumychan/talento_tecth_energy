package com.talentotech.energies.Services;

import com.talentotech.energies.Entities.User_role;
import com.talentotech.energies.Repositories.User_roleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService {

    @Autowired
    private User_roleRepository userRoleRepository;

    // Create user role
    public User_role createUserRole(User_role userRole) {
        return userRoleRepository.save(userRole);
    }
    // Get userRole by Id rol
    public Optional<User_role> getUserRoleById(Integer roleId) {
        return userRoleRepository.findById(roleId);
    }

    // Get All user role
    public List<User_role> getAllUserRole() {
        return userRoleRepository.findAll();
    }
}
