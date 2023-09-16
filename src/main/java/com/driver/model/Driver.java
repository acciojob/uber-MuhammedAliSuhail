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


    private String MobileNo;
    private String Password;

    public Driver() {
    }

    @OneToOne()
    @JoinColumn
    Cab cab;

    public Driver(String mobileNo, String password) {
        MobileNo = mobileNo;
        Password = password;
    }

    public Driver(String mobileNo, String password, Cab cab) {
        MobileNo = mobileNo;
        Password = password;
        this.cab = cab;
    }

    public Driver(String mobileNo, String password, Cab cab, List<TripBooking> tripBookingList) {
        MobileNo = mobileNo;
        Password = password;
        this.cab = cab;
        this.tripBookingList = tripBookingList;
    }

    public Integer getDriverId() {
        return DriverId;
    }

    public Driver(Integer driverId, String mobileNo, String password, Cab cab, List<TripBooking> tripBookingList) {
        DriverId = driverId;
        MobileNo = mobileNo;
        Password = password;
        this.cab = cab;
        this.tripBookingList = tripBookingList;
    }

    public void setDriverId(Integer driverId) {
        DriverId = driverId;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
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