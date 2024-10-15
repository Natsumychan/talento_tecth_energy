package com.talentotech.energies.Services;

import com.talentotech.energies.Entities.User_role;
import com.talentotech.energies.Repositories.User_roleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRoleService {

    @Autowired
    private User_roleRepository userRoleRepository;

    // Get userRole by Id rol
    public Optional<User_role> getUserRoleById(Integer roleId) {
        return userRoleRepository.findById(roleId);
    }
}
