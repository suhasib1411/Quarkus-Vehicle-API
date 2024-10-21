package com.example;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Vehicle extends PanacheEntity {
    public String vehicleNumber;
    public String panID;

    // Getters and setters omitted for brevity

    public String getPanID() {
        return panID;
    }

    public void setPanID(String panID) {
        this.panID = panID;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}
