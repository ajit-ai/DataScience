package com.space.ajit.universe.model.universe;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Continent {

    private String id;
    private String name;
    private List<Countries> countriesList;

}
