package com.cydeo.lab07ormqueries.repository;


import com.cydeo.lab07ormqueries.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {
    //Write a derived query to check balance exists for specific customer
    boolean existsBalanceByCustomerId(Long id);

    //Write a derived query to get balance for specific customer
    Balance findByCustomerId(Long id);

    //Write a native query to get top 5 max balance
    @Query(nativeQuery = true, value = "select distinct * from balance where amount not null order by amount limit 5")
    List<Balance> retrieveTop5balance();

    //Write a derived query to get all balances greater than or equal specific balance amount
    List<Balance> findByAmountGreaterThanEqual(int amount);


    //Write a native query to get all balances less than specific balance amount
    @Query(nativeQuery = true, value = "select * from balance where amount < ?1")
    List<Balance> retrieveBalanceLessThan(@Param("amount") BigDecimal amount);

}
