package com.space.ajit.universe.model.country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Asia {

    @Id
    private int id;
    private String name;
    private String country;
    private String capital;
    private String astronomy;
}
