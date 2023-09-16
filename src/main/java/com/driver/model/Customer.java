package com.driver.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Customer {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;


    private String Mobail;
    private String Password;


    public Customer() {
    }

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
     List<TripBooking> tripBookingList=new ArrayList<>();

    public Integer getCustomerId() {
        return customerId;
    }

    public Customer(String mobail, String password, List<TripBooking> tripBookingList) {
        Mobail = mobail;
        Password = password;
        this.tripBookingList = tripBookingList;
    }

    public Customer(String mobail, String password) {
        Mobail = mobail;
        Password = password;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Customer(Integer customerId, String mobail, String password, List<TripBooking> tripBookingList) {
        this.customerId = customerId;
        Mobail = mobail;
        Password = password;
        this.tripBookingList = tripBookingList;
    }

    public String getMobail() {
        return Mobail;
    }

    public void setMobail(String mobail) {
        Mobail = mobail;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public List<TripBooking> getTripBookingList() {
        return tripBookingList;
    }

    public void setTripBookingList(List<TripBooking> tripBookingList) {
        this.tripBookingList = tripBookingList;
    }
}