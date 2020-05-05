package com.space.ajit.universe.model.company;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Company {

    @Id
    private int id;
    private String name;
    private String Location;
    private List<Product> products;
    private Contact contact;

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                ", contact=" + contact +
                '}';
    }


}
