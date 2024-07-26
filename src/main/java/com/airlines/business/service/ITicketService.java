package com.airlines.business.service;

import com.airlines.business.payload.response.MaxSellDayOfAllTicketsResponse;
import com.airlines.business.payload.response.MaxSoldDayOfTickets;
import com.airlines.business.payload.response.TopSellingRoutesResponse;
import com.airlines.business.payload.response.TotalSellAmountFromTicketAndFoodResponse;

import java.util.Date;
import java.util.List;

public interface ITicketService {
    TotalSellAmountFromTicketAndFoodResponse getTotalSellAmountFromTicketAndFoodOfPresentDay();
    MaxSoldDayOfTickets getMaxSellDayOfAllTickets(Date toDate, Date fromDate);

    List<TopSellingRoutesResponse> getTopThreeSellingRoutes();
}
