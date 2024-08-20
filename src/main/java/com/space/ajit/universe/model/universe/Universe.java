package com.space.ajit.universe.model.universe;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Universe {

    private String id;
    private String name;
    private Long size;
    private List<Galaxy> galaxyList;

}
