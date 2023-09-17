package com.driver.model;

import javax.persistence.*;


@Entity
@Table
public class Cab {

    public Cab(Integer parkingRate, Boolean available) {
        PerKmRate = parkingRate;
        Status = available;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Cab(Integer parkingRate, Boolean available, Driver driver) {
        PerKmRate = parkingRate;
        Status = available;
        this.driver = driver;
    }

    public Cab() {
    }

    private Integer PerKmRate;

    public Cab(Integer id, Integer parkingRate, Boolean available, Driver driver) {
        this.id = id;
        PerKmRate = parkingRate;
        Status = available;
        this.driver = driver;
    }

    private Boolean Status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPerKmRate() {
        return PerKmRate;
    }

    public void setPerKmRate(Integer perKmRate) {
        PerKmRate = perKmRate;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
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