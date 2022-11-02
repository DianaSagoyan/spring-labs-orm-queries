package com.cydeo.lab07ormqueries.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category extends BaseEntity{
    private String name;

    @ManyToMany(mappedBy = "category")
    private List<Product> product;

    public Category(String name, List<Product> product) {
        this.name = name;
        this.product = product;
    }
}
