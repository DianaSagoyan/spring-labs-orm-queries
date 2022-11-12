package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    //Write a derived query to get top 5 orders by order by total price desc
    List<Order> findTop5ByTotalPriceOrderByDesc();

    //Write a derived query to get all orders by customer email
    List<Order>findByCustomer_Email(String email);

    //Write a derived query to get all orders by specific payment method
    List<Order> findByPaymentPaymentMethod(String method);


    //Write a derived query to check is there any orders by customer email
    boolean existsByCustomer_Email(String email);

    //Write a native query to get all orders by specific product name
    @Query(nativeQuery = true, value = "select * from orders o join product p where p.name = ?1") //???
    List<Order> retrieveOrdersByProductName(String name);

    //Write a native query to get all orders by specific categoryId
    @Query(nativeQuery = true, value = "select * from orders join category c where c.id = ?1") //??
    List<Order> retrieveOrdersByCategoryId(Long id);

    //Write a derived query to get all orders by totalPrice and paidPrice are equals
    List<Order> findByTotalPriceEqualsPaidPrice(); //??

    //Write a derived query to get all orders by totalPrice and paidPrice are not equals and discount is not null
    List<Order> findByTotalPriceNotEqualPaidPriceAndDiscountNotNull();  //??


}
