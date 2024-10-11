package com.talentotech.energies.Entities;

import java.util.Date;

public class User {
    //Atributes
    private int userId;
    private String userName;
    private String userLastName;
    private String email;
    private String password;
    private String userRole;
    private Date createAcounteDate;

    public User(int userId, String userName, String userLastName, String email, String password, String userRole, Date createAcounteDate) {
        this.userId = userId;
        this.userName = userName;
        this.userLastName = userLastName;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
        this.createAcounteDate = createAcounteDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Date getCreateAcounteDate() {
        return createAcounteDate;
    }

    public void setCreateAcounteDate(Date createAcounteDate) {
        this.createAcounteDate = createAcounteDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userRole='" + userRole + '\'' +
                ", createAcounteDate=" + createAcounteDate +
                '}';
    }
}
