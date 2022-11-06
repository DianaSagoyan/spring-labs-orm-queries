package com.cydeo.lab07ormqueries.repository;
import com.cydeo.lab07ormqueries.entity.Cart;
import com.cydeo.lab07ormqueries.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    //Write a derived query to get all cart by specific discount type
    List<Cart> findByDiscount_DiscountType(String type);

    //Write a JPQL query to get all cart by customer
    @Query("select c from Cart c where c.customer.id = ?1")
    List<Cart> retrieveAllCartByCustomerId(Long id);

    //Write a derived query to get all cart by customer and cart state
    List<Cart> findByCustomerIdAndCartState(Long id, String state);

    //Write a derived query to get all cart by customer and cart state and discount is null condition
    List<Cart> findByCustomerIdAndCartStateAndDiscountIsNull(Long id, String state);

    //Write a native query to get all cart by customer and cart state and discount is not null condition
    @Query(nativeQuery = true, value = "select * from cart where customer_id = ?1 and cart_state = ?2 and discount_id <> null")
    List<Cart> retrieveCartByCustomerCartStateAndDiscountNotNull(Long id, String state);

}
