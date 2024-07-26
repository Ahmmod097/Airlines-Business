package com.airlines.business.repository;

import com.airlines.business.models.Ticket;
import com.airlines.business.payload.response.MaxSellDayOfAllTicketsResponse;
import com.airlines.business.payload.response.TopSellingRoutesResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("SELECT IFNULL(SUM(tk.price), 0) FROM Ticket tk " +
            "WHERE Date(tk.soldDate) = Date(:currentDate)")
    BigDecimal getTotalTicketPrice(@Param("currentDate") Date currentDate);

    @Query("SELECT NEW com.airlines.business.payload.response.MaxSellDayOfAllTicketsResponse(tk.soldDate, Count(*) as totalTicketSales) FROM Ticket tk " +
            "WHERE :startDate is Null and :endDate is Null " +
            "Or Date(tk.soldDate) BETWEEN Date(:startDate) And Date(:endDate) " +
            "Group By tk.soldDate " +
            "order by totalTicketSales desc " +
            "limit 1")
    MaxSellDayOfAllTicketsResponse getMaxTicketSellDay(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT NEW com.airlines.business.payload.response.TopSellingRoutesResponse(fi.arrivalAirport, fi.departureAirport,SUM(tk.price) as totalTicketPrice) FROM Ticket tk " +
            "Join FlightsInfo as fi on fi.id = tk.flightsInfo.id " +
            "Group By tk.flightsInfo.id " +
            "order by totalTicketPrice desc " +
            "limit 3")
    List<TopSellingRoutesResponse> getTopThreeSellingRoute();
}
