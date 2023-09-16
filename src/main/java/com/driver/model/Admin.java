package com.driver.model;


import javax.persistence.*;

@Entity
@Table
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(nullable = false)
    private String userName;

    public Admin(Integer id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        Password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public Admin() {
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Admin(String userName, String password) {
        this.userName = userName;
        Password = password;
    }

    @Column(nullable = false)
private  String Password;
}