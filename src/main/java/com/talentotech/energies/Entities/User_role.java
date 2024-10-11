package com.talentotech.energies.Entities;

import com.talentotech.energies.Entities.enums.UserRol;
import jakarta.persistence.*;

@Entity
@Table(name = "rol_usuarios")
public class User_role {

    @Id
    private int roleId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRol roleName;

    public User_role(int roleId, UserRol roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public UserRol getRoleName() {
        return roleName;
    }

    public void setRoleName(UserRol roleName) {
        this.roleName = roleName;
    }
}
