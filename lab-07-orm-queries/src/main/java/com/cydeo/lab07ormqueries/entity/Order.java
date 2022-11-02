package com.cydeo.lab07ormqueries.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "orders")
public class Order extends BaseEntity{
    private BigDecimal paidPrice;
    private BigDecimal totalPrice;

    @OneToOne
    private Cart cart;

    @ManyToOne
    private Customer customer;

    @OneToOne
    private Payment payment;

    public Order(BigDecimal paidPrice, BigDecimal totalPrice, Cart cart, Customer customer, Payment payment) {
        this.paidPrice = paidPrice;
        this.totalPrice = totalPrice;
        this.cart = cart;
        this.customer = customer;
        this.payment = payment;
    }
}
