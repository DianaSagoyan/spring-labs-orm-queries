package com.cydeo.lab07ormqueries.entity;

import com.cydeo.lab07ormqueries.enums.PaymentMethod;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Payment extends BaseEntity{
    private BigDecimal paidPrice;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    public Payment(BigDecimal paidPrice, PaymentMethod paymentMethod) {
        this.paidPrice = paidPrice;
        this.paymentMethod = paymentMethod;
    }
}
