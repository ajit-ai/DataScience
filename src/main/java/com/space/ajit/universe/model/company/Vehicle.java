package com.space.ajit.universe.model.company;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Data
public class Vehicle {

    @Id
    private int _id;
    private String make;
    private String model;
    private String registrationNumber;

    public Vehicle() {
    }

    public Vehicle(int _id, String make, String model, String registrationNumber) {
        this._id = _id;
        this.make = make;
        this.model = model;
        this.registrationNumber = registrationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;

        Vehicle vehicle = (Vehicle) o;

        if (get_id() != vehicle.get_id()) return false;
        if (getMake() != null ? !getMake().equals(vehicle.getMake()) : vehicle.getMake() != null) return false;
        if (getModel() != null ? !getModel().equals(vehicle.getModel()) : vehicle.getModel() != null) return false;
        return getRegistrationNumber() != null ? getRegistrationNumber().equals(vehicle.getRegistrationNumber()) : vehicle.getRegistrationNumber() == null;
    }

    @Override
    public int hashCode() {
        int result = get_id();
        result = 31 * result + (getMake() != null ? getMake().hashCode() : 0);
        result = 31 * result + (getModel() != null ? getModel().hashCode() : 0);
        result = 31 * result + (getRegistrationNumber() != null ? getRegistrationNumber().hashCode() : 0);
        return result;
    }
}
