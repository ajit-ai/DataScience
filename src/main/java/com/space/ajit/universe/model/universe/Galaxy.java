package com.space.ajit.universe.model.universe;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Galaxy  {

    private String id;
    private String galaxyName;
    private Long size;
    private List<MilkyWay> milkyWayList;
}
