package com.space.ajit.universe.model.universe;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Sun {
    private String id;
    private String name;
    private List<Earth> earthList;
}
