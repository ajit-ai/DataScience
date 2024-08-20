package com.space.ajit.universe.model.universe;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Data
@Document
public class UserDetails {

    @Id
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

}
