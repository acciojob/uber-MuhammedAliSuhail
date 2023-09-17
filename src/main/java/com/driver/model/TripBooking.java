package com.driver.model;

import javax.persistence.*;

@Entity
@Table
public class TripBooking {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer TripBookingId;

    private String FromLocation;
    private String ToLocation;


    private Integer DistanceInKm;

    public TripBooking(String fromLocation, String toLocation, Integer distanceInKm, TripStatus tripStatus, Integer bill, Customer customer, Driver driver) {
        FromLocation = fromLocation;
        ToLocation = toLocation;
        DistanceInKm = distanceInKm;
        this.tripStatus = tripStatus;
        this.bill = bill;
        this.customer = customer;
        this.driver = driver;
    }

    public TripBooking(String fromLocation, String toLocation, Integer distanceInKm, TripStatus tripStatus) {
        FromLocation = fromLocation;
        ToLocation = toLocation;
        DistanceInKm = distanceInKm;
        this.tripStatus = tripStatus;
    }

    @Enumerated(value = EnumType.STRING)
    private TripStatus tripStatus;

    public TripBooking(Integer ticketBookingId, String fromLocation, String toLocation, Integer distanceInKm, TripStatus tripStatus, Integer bill, Customer customer, Driver driver) {
        TripBookingId = ticketBookingId;
        FromLocation = fromLocation;
        ToLocation = toLocation;
        DistanceInKm = distanceInKm;
        this.tripStatus = tripStatus;
        this.bill = bill;
        this.customer = customer;
        this.driver = driver;
    }

    private Integer bill;


    @ManyToOne
    @JoinColumn
    Customer customer;

    public Integer getTripBookingId() {
        return TripBookingId;
    }

    public void setTripBookingId(Integer tripBookingId) {
        TripBookingId = tripBookingId;
    }

    public String getFromLocation() {
        return FromLocation;
    }

    public void setFromLocation(String fromLocation) {
        FromLocation = fromLocation;
    }

    public String getToLocation() {
        return ToLocation;
    }

    public void setToLocation(String toLocation) {
        ToLocation = toLocation;
    }

    public Integer getDistanceInKm() {
        return DistanceInKm;
    }

    public void setDistanceInKm(Integer distanceInKm) {
        DistanceInKm = distanceInKm;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }

    public Integer getBill() {
        return bill;
    }

    public void setBill(Integer bill) {
        this.bill = bill;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Driver getDriver() {
        return driver;
    }

    public TripBooking() {
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @ManyToOne()
    @JoinColumn
     Driver driver;



}