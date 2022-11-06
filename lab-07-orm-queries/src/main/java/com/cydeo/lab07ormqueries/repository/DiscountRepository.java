package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
    //Write a derived query to get discount by name
    List<Discount> findByName(String name);

    //Write a derived query to get all discounts greater than discount amount
    List<Discount> findByDiscountGreaterThan(Long amount);

    //Write a derived query to get all discounts by specific discount type
    List<Discount> findByDiscountType(String type);

    //Write a JPQL query to get all discounts amount between range of discount amount
    @Query("select d from Discount d where d.discount between ?1 and ?2")
    List<Discount> retrieveDiscountsBetween(Long amount1, Long amount2);
}
