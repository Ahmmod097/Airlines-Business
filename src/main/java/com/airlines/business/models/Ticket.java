package com.airlines.business.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "TICKET")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SEAT_NUMBER")
    private String seatNumber;

    @Column(name = "TOTAL_SEAT")
    private Integer totalSeat;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "SOLD_DATE")
    private Date soldDate;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private FlightsInfo flightsInfo;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;
}
