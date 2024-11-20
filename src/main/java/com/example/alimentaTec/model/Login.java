package com.example.alimentaTec.model;

import com.example.alimentaTec.enums.Rolname;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    @JsonProperty("idUser")
    private int idUser;
    
    @Column(name = "username")
    @JsonProperty("username")
    private String username;
    
    @Column(name = "passwordUser")
    @JsonProperty("passwordUser")
    private String passwordUser;
    
    @Column(name = "email")
    @JsonProperty("email")
    private String email;
    
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Rolname role;

    // Getters y Setters existentes...

    
    public int getIdUser() {
        return idUser;
    }
    
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPasswordUser() {
        return passwordUser;
    }
    
    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }  
    // Getters and Setters
    public Rolname getRole() {
        return role;
    }

    public void setRole(Rolname role) {
        this.role = role;
    }
}
