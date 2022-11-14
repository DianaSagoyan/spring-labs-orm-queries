package com.cydeo.lab07ormqueries.repository;


import com.cydeo.lab07ormqueries.entity.CartItem;
import com.cydeo.lab07ormqueries.entity.Discount;
import com.cydeo.lab07ormqueries.enums.CartState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    //Write a derived query to get count cart items
    int countAllBy();

    //Write a derived query to get cart items for specific cart state
    List<CartItem> findByCart_CartState(CartState cartState);

    //Write a native query to get cart items for specific cart state and product name
    @Query(nativeQuery = true, value = "select * from cart_item ci join cart c on ci.cart_id = c.id" +
            "join product p on ci.product_id = p.id where c.cart_state = ?1 and p.name = ?2")
    List<CartItem> retrieveCartItemWithSpecificStateAndProductName(String state, String productName);

    //Write a native query to get cart items for specific cart state and without discount
    @Query(nativeQuery = true, value = "select * from cart_item ci join cart c on ci.cart_id = c.id" +
            "where c.cart_state = ?1 and c.discount_id is null")
    List<CartItem> retrieveCartItemsWithCartSateAndNoDiscount(String state);

    //Write a native query to get cart items for specific cart state and with specific Discount type
    @Query(nativeQuery = true, value = "select * from cart_item ci join cart c on ci.cart_id = c.id" +
            "where c.cart_state = ?1 and c.dicount_type = ?2")
    List<CartItem> retrieveCartItemsWithCartSateAndNoSpecificDiscount(String state, Discount discount);

}
