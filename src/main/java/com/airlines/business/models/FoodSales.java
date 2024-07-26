package com.airlines.business.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "FOOD_SALES")
public class FoodSales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "QUANTITY_SOLD")
    private Integer quantitySold;

    @Column(name = "SALE_DATE")
    private Date saleDate;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private FlightsInfo flightsInfo;

    @ManyToOne
    @JoinColumn(name = "food_item_id")
    private FoodItem foodItem;
}
