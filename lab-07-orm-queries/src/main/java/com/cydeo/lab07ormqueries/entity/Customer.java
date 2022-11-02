package com.cydeo.lab07ormqueries.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer extends BaseEntity{
    private String email;
    private String firstName;
    private String lastName;
    private String userName;

    public Customer(String email, String firstName, String lastName, String userName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }
}
