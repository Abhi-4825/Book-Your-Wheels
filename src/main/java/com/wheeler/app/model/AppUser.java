package com.wheeler.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class AppUser {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String Email;
    private String Phone;
    private String Password;
    private String Role;

    public AppUser() {
    }
    public AppUser(int id, String name, String email, String phone, String password, String role) {
        this.id = id;
        this.name = name;
        this.Email = email;
        this.Phone = phone;
        this.Password = password;
        this.Role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }
}
