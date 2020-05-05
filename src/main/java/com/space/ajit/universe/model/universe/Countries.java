package com.space.ajit.universe.model.universe;

import com.space.ajit.universe.model.universe.City;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Countries {

    private String countryName;


    private String localName;
    private String webCode;
    private String region;
    private City cities;
    private String continent;
    private long latitude;
    private long longitude;
    private long surfaceArea;
    private long population;


    @Override
    public String toString() {
        return "Countries{" +
                "countryName='" + countryName + '\'' +
                ", localName='" + localName + '\'' +
                ", webCode='" + webCode + '\'' +
                ", region='" + region + '\'' +
                ", continent='" + continent + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", surfaceArea=" + surfaceArea +
                ", population=" + population +
                '}';
    }
}
