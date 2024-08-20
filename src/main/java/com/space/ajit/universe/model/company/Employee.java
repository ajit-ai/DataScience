package com.space.ajit.universe.model.company;

import com.space.ajit.universe.model.universe.Address;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class Employee {

    @org.springframework.data.annotation.Id
    private long Id;

    private String firstName;

    private String lastName;


    private Address address;

   /* public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNamr() {
        return lastName;
    }

    public void setLastNamr(String lastNamr) {
        this.lastName = lastNamr;
    }


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }
*/
}
