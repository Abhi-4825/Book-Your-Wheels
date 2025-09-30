package com.wheeler.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Primary;

@Entity
public class vehicle {
    @Id
    @GeneratedValue
    int Id;
    String VName;
    String VType;
    double VCharge;
    boolean available;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getVName() {
        return VName;
    }

    public void setVName(String VName) {
        this.VName = VName;
    }

    public String getVType() {
        return VType;
    }

    public void setVType(String VType) {
        this.VType = VType;
    }

    public double getVCharge() {
        return VCharge;
    }

    public void setVCharge(double VCharge) {
        this.VCharge = VCharge;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public vehicle(int id, String VName, String VType, double VCharge, boolean available) {
        Id = id;
        this.VName = VName;
        this.VType = VType;
        this.VCharge = VCharge;
        this.available = available;
    }
    public vehicle() {}
}
