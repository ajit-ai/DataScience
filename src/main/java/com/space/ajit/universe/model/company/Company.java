package com.space.ajit.universe.model.company;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    private int id;
    private String name;
    private String Location;
    private List<Product> products;
    private List<Contact> contacts;
    private List<Vehicle> vehicles;

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Location='" + Location + '\'' +
                ", products=" + products +
                ", contacts=" + contacts +
                ", vehicles=" + vehicles +
                '}';
    }
}
