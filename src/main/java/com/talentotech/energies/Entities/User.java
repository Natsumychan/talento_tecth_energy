package com.talentotech.energies.Entities;

import com.talentotech.energies.Entities.enums.UserRol;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "usuarios")
public class User {

    //Atributes

    @Id
    private String documentoId;

    @Column(nullable = false, length = 100)
    private String userName;

    @Column(nullable = false, length = 100)
    private String userLastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRol userRole;

    private Date createAcounteDate;

    public User(String documentoId, String userName, String userLastName, String email, String password, UserRol userRole, Date createAcounteDate) {
        this.documentoId = documentoId;
        this.userName = userName;
        this.userLastName = userLastName;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
        this.createAcounteDate = createAcounteDate;
    }

    public String getUserId() {
        return documentoId;
    }

    public void setUserId(String userId) {
        this.documentoId = userId;
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

    public UserRol getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRol userRole) {
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
                "userId=" + documentoId +
                ", userName='" + userName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userRole='" + userRole + '\'' +
                ", createAcounteDate=" + createAcounteDate +
                '}';
    }
}
