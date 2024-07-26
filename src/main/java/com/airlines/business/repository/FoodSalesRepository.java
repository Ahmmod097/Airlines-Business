package com.airlines.business.repository;

import com.airlines.business.models.FoodSales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;

@Repository
public interface FoodSalesRepository extends JpaRepository<FoodSales, Long> {
    @Query("SELECT IFNULL(SUM(fs.quantitySold * fi.price),0) FROM FoodSales fs " +
            "JOIN FoodItem fi ON fi.id = fs.foodItem.id " +
            "Where Date(fs.saleDate) = Date(:currentDate)")
    BigDecimal getTotalFoodPrice(@Param("currentDate") Date currentDate);
}
