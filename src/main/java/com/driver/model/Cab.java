package com.driver.model;

import javax.persistence.*;


@Entity
@Table
public class Cab {

    public Cab(Integer parkingRate, Boolean available) {
        ParkingRate = parkingRate;
        Available = available;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Cab(Integer parkingRate, Boolean available, Driver driver) {
        ParkingRate = parkingRate;
        Available = available;
        this.driver = driver;
    }

    public Cab() {
    }

    private Integer ParkingRate;

    public Cab(Integer id, Integer parkingRate, Boolean available, Driver driver) {
        this.id = id;
        ParkingRate = parkingRate;
        Available = available;
        this.driver = driver;
    }

    private Boolean Available;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParkingRate() {
        return ParkingRate;
    }

    public void setParkingRate(Integer parkingRate) {
        ParkingRate = parkingRate;
    }

    public Boolean getAvailable() {
        return Available;
    }

    public void setAvailable(Boolean available) {
        Available = available;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @OneToOne(mappedBy = "cab",cascade = CascadeType.ALL)
      Driver driver;

}