package com.space.ajit.universe.model.universe;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Document
public class Address {

    @org.springframework.data.annotation.Id
    private Long Id;


    private String Landmark;

    @NotEmpty(message = "please provide the city name")
    private String city;

    @NotEmpty(message = "please provide the state name")
    private String State;

    @NotEmpty(message = "please provide country name")
    private String Country;

    @NotNull(message = "please provide the pincode")
    private Integer pinCode;


}
