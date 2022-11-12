package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //Write a derived query to get top 3 product order by price desc
    List<Product> findTop3ByPriceOrderByPriceDesc();

    //Write a derived query to get product by specific name
    Product findByName(String name);

    //Write a derived query to get product by specific category
    Product findByCategory(String category);

    //Write a derived query to get count by price greater than specific amount
    int countByPriceGreaterThan(int amount);

    //Write a derived query to get all product by quantity greater than or equal specific count
    List<Product> findByQuantityGreaterThanEqual(int count);

    //Write a native query to get all product by price greater than specific amount and quantity lower than specific count
    @Query(nativeQuery = true, value = "select * from product where price > ?1 and quantity < ?2")
    List<Product> retrieveByPriceAndQuantity(int price, int quantity);

    //Write a native query to get all product by specific categoryId
    @Query(nativeQuery = true, value = "select * from product p join category c on p.id = c.id where c.id = ?1") //??
    List<Product> retrieveProductByCategoryId(Long id);

    //Write a native query to get all product by specific categoryId and price greater than specific amount
    @Query(nativeQuery = true, value = "select * from product p join category c on c.id = p.id where c.id = ?1 and p.price > ?2") //??
    List<Product> retrieveProductByCategoryIdAndPrice(Long id, int amount);

}
