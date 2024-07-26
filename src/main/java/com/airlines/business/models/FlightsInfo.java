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
@Table(name = "FLIGHTS_INFO")
public class FlightsInfo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FLIGHT_NUMBER")
    private String flightNumber;

    @Column(name = "DEPARTURE_AIRPORT")
    private String departureAirport;

    @Column(name = "ARRIVAL_AIRPORT")
    private String arrivalAirport;

    @Column(name = "DEPARTURE_TIME")
    private Date departureTime;

    @Column(name = "ARRIVAL_TIME")
    private Date arrivalTime;
}
