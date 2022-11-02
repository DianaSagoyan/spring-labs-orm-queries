package com.cydeo.lab07ormqueries.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address extends BaseEntity{
    private String name;
    private String street;
    private String zipCode;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    public Address(String name, String street, String zipCode, Customer customer) {
        this.name = name;
        this.street = street;
        this.zipCode = zipCode;
        this.customer = customer;
    }
}
