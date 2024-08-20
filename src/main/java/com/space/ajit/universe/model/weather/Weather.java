package com.space.ajit.universe.model.weather;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
public class Weather {

    private String location;
    private Date date;
    private Long precipitation;
    private Long temp_max;
    private Long temp_min;
    private Long wind;
    private String weather;

}
