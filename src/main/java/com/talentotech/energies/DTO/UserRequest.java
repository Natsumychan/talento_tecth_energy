package com.talentotech.energies.DTO;

import com.talentotech.energies.Entities.User;

import java.util.List;

public class UserRequest {
    private int role;
    private User users;


    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

}
