package com.space.ajit.universe.model.company;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class Vehicle {

    @Id
    private UUID _id;


    private String make;
    private String model;
    private String registrationNumber;

    public Vehicle() {
    }

    public Vehicle(String make, String model, String registrationNumber) {
        this._id = UUID.randomUUID();
        this.make = make;
        this.model = model;
        this.registrationNumber = registrationNumber;
    }

    public UUID get_id() {
        return _id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "_id=" + _id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;

        Vehicle vehicle = (Vehicle) o;

        if (get_id() != null ? !get_id().equals(vehicle.get_id()) : vehicle.get_id() != null) return false;
        if (getMake() != null ? !getMake().equals(vehicle.getMake()) : vehicle.getMake() != null) return false;
        if (getModel() != null ? !getModel().equals(vehicle.getModel()) : vehicle.getModel() != null) return false;
        return getRegistrationNumber() != null ? getRegistrationNumber().equals(vehicle.getRegistrationNumber()) : vehicle.getRegistrationNumber() == null;
    }

    @Override
    public int hashCode() {
        int result = get_id() != null ? get_id().hashCode() : 0;
        result = 31 * result + (getMake() != null ? getMake().hashCode() : 0);
        result = 31 * result + (getModel() != null ? getModel().hashCode() : 0);
        result = 31 * result + (getRegistrationNumber() != null ? getRegistrationNumber().hashCode() : 0);
        return result;
    }

}
