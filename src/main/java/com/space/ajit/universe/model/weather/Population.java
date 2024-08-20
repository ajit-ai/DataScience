package com.space.ajit.universe.model.weather;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

@Document
@Data
public class Population {

    private ZonedDateTime year;
    private int age;
    private int sex;
    private int people;

}
