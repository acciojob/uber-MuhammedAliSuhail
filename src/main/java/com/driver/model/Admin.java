package com.driver.model;


import javax.persistence.*;

@Entity
@Table
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer adminId;


    @Column(nullable = false)
    private String username;

    public Admin(Integer id, String userName, String password) {
        this.adminId = id;
        this.username = userName;
        Password = password;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public Admin() {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Admin(String userName, String password) {
        this.username = userName;
        Password = password;
    }

    @Column(nullable = false)
private  String Password;
}