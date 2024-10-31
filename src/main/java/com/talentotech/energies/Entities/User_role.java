package com.talentotech.energies.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.talentotech.energies.Entities.enums.UserRol;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rol_usuarios")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "rol_usuario")
public class User_role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roleId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRol roleName;

    @OneToMany(targetEntity = User.class, fetch = FetchType.LAZY, mappedBy = "roleId")
    private List<User> users;

    public User_role() {
    }

    public User_role(int roleId, UserRol roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public int getRole() {
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
