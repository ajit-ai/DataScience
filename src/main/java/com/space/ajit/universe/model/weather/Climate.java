package com.space.ajit.universe.model.weather;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Climate {

    private String stationCode;
    private String stationName;
    private Long elavation;
    private Long latitude;
    private Long longitude;
    private Long temperature;
}
