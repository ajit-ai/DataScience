package com.space.ajit.universe.model.universe;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class City {


    @Id
    private Long id;
    private String states;
    private String country;
    private int pincode;

    public City(String states, String country, int pincode) {
        this.states = states;
        this.country = country;
        this.pincode = pincode;
    }
}
