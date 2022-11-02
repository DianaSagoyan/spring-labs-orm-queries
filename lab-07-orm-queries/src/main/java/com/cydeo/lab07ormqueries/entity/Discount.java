package com.cydeo.lab07ormqueries.entity;

import com.cydeo.lab07ormqueries.enums.DiscountType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigInteger;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Discount extends BaseEntity{
    private BigInteger discount;

    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    private String name;

    public Discount(BigInteger discount, DiscountType discountType, String name) {
        this.discount = discount;
        this.discountType = discountType;
        this.name = name;
    }
}
