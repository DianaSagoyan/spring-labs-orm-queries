package com.cydeo.lab07ormqueries.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product extends BaseEntity{
    private String Name;
    private BigDecimal price;
    private int quantity;
    private int remaining_quantity;

    @ManyToMany
    @JoinTable(name = "productCategoryRel",
            joinColumns = @JoinColumn(name = "p_id"),
            inverseJoinColumns = @JoinColumn(name = "c_id"))
    private List<Category> category;

    public Product(String name, BigDecimal price, int quantity, int remaining_quantity, List<Category> category) {
        Name = name;
        this.price = price;
        this.quantity = quantity;
        this.remaining_quantity = remaining_quantity;
        this.category = category;
    }
}
