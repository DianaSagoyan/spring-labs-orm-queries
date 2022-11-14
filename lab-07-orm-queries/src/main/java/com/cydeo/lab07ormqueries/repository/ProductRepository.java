package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //Write a derived query to get top 3 product order by price desc
    List<Product> findTop3ByPriceOrderByPriceDesc();

    //Write a derived query to get product by specific name
    Product findByName(String name);

    //Write a derived query to get product by specific category
    List<Product> findByCategory(String category);

    //Write a derived query to get count by price greater than specific amount
    int countByPriceGreaterThan(BigDecimal price);

    //Write a derived query to get all product by quantity greater than or equal specific count
    List<Product> findByQuantityGreaterThanEqual(int count);

    //Write a native query to get all product by price greater than specific amount and quantity lower than specific count
    @Query(nativeQuery = true, value = "select * from product where price > ?1 and quantity < ?2")
    List<Product> retrieveByPriceAndQuantity(int price, int quantity);

    //Write a native query to get all product by specific categoryId
    @Query(value = "select * from product p join product_category_rel pl on pl.p_id = p.id where pl.c_id = ?1", nativeQuery = true)
    List<Product> retrieveProductByCategoryId(Long id);

    //Write a native query to get all product by specific categoryId and price greater than specific amount
    @Query(value = "select * from product p join product_category_rel pl on pl.p_id = p.id where pl.c_id in(?1) " +
            " p.price > ?2", nativeQuery = true)
    List<Product> retrieveProductByCategoryIdAndPrice(Long id, int amount);

}
