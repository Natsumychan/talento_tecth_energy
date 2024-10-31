package com.talentotech.energies.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "usuarios")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "rol_usuario")
public class User {

    //Atributes

    @Id
    private String documentId;

    @Column(nullable = false, length = 100)
    private String userName;

    @Column(nullable = false, length = 100)
    private String userLastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToOne(targetEntity = User_role.class)
    @JoinColumn(name="rol_usuario")
    private User_role roleId;

    private LocalDate createAcounteDate;

    public User() {
    }

    public User(String documentId, String userName, String userLastName, String email, String password, User_role roleId, LocalDate createAcounteDate) {
        this.documentId = documentId;
        this.userName = userName;
        this.userLastName = userLastName;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.createAcounteDate = createAcounteDate;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
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

    public User_role getRoleId() {
        return roleId;
    }

    public void setRoleId(User_role roleId) {
        this.roleId = roleId;
    }

    public LocalDate getCreateAcounteDate() {
        return createAcounteDate;
    }

    public void setCreateAcounteDate(LocalDate createAcounteDate) {
        this.createAcounteDate = createAcounteDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + documentId +
                ", userName='" + userName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userRole='" + roleId + '\'' +
                ", createAcounteDate=" + createAcounteDate +
                '}';
    }
}
