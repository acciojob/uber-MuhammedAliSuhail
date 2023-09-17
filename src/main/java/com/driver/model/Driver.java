package com.driver.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
public class Driver {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer DriverId;


    private String Mobile;

    private String Password;

    public Driver() {
    }

    @OneToOne()
    @JoinColumn
    Cab cab;

    public Driver(String mobileNo, String password) {
        Mobile = mobileNo;
        Password = password;
    }

    public Driver(String mobileNo, String password, Cab cab) {
        Mobile = mobileNo;
        Password = password;
        this.cab = cab;
    }

    public Driver(String mobileNo, String password, Cab cab, List<TripBooking> tripBookingList) {
        Mobile = mobileNo;
        Password = password;
        this.cab = cab;
        this.tripBookingList = tripBookingList;
    }

    public Integer getDriverId() {
        return DriverId;
    }

    public Driver(Integer driverId, String mobileNo, String password, Cab cab, List<TripBooking> tripBookingList) {
        DriverId = driverId;
        Mobile = mobileNo;
        Password = password;
        this.cab = cab;
        this.tripBookingList = tripBookingList;
    }

    public void setDriverId(Integer driverId) {
        DriverId = driverId;
    }

    public String getMobileNo() {
        return Mobile;
    }

    public void setMobileNo(String mobileNo) {
        Mobile = mobileNo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public List<TripBooking> getTripBookingList() {
        return tripBookingList;
    }

    public void setTripBookingList(List<TripBooking> tripBookingList) {
        this.tripBookingList = tripBookingList;
    }

    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
      List<TripBooking> tripBookingList=new ArrayList<>();
}