package com.airlines.business.service.impl;

import com.airlines.business.enums.ResponseMessage;
import com.airlines.business.exception.RequestProcessingFailed;
import com.airlines.business.payload.request.PaginationRequest;
import com.airlines.business.payload.response.MaxSellDayOfAllTicketsResponse;
import com.airlines.business.payload.response.MaxSoldDayOfTickets;
import com.airlines.business.payload.response.TopSellingRoutesResponse;
import com.airlines.business.payload.response.TotalSellAmountFromTicketAndFoodResponse;
import com.airlines.business.repository.FlightsInfoRepository;
import com.airlines.business.repository.FoodSalesRepository;
import com.airlines.business.repository.TicketRepository;
import com.airlines.business.service.ITicketService;
import com.airlines.business.utils.DateTimeUtils;
import com.airlines.business.utils.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements ITicketService {
    private final FlightsInfoRepository flightsInfoRepository;
    private final TicketRepository ticketRepository;
    private final FoodSalesRepository foodSalesRepository;

    @Override
    public TotalSellAmountFromTicketAndFoodResponse
    getTotalSellAmountFromTicketAndFoodOfPresentDay() {
        try {

            BigDecimal totalTicketSales = ticketRepository.getTotalTicketPrice
                    (DateTimeUtils.getCurrentDate());
            BigDecimal totalFoodSold = foodSalesRepository.getTotalFoodPrice
                    (DateTimeUtils.getCurrentDate());

            return TotalSellAmountFromTicketAndFoodResponse
                    .builder()
                    .totalSoldAmountsFromTicket(totalTicketSales)
                    .totalSoldAmountsFromFoods(totalFoodSold)
                    .build();
        } catch (Exception e) {
            throw new RequestProcessingFailed(e.getMessage());
        }
    }

    @Override
    public MaxSoldDayOfTickets getMaxSellDayOfAllTickets(Date toDate, Date fromDate) {
        try {
            validateDateRange(toDate, fromDate);

            MaxSellDayOfAllTicketsResponse response = ticketRepository
                    .getMaxTicketSellDay(fromDate, toDate);

            if (Objects.isNull(response)) {
                return null;
            }

            return MaxSoldDayOfTickets
                    .builder()
                    .maxSellDate(DateTimeUtils.formatDate(response.getMaxSellDate(),
                            "yyyy-MM-dd"))
                    .maxSellTicket(response.getMaxSellTicket())
                    .build();
        } catch (Exception e) {
            throw new RequestProcessingFailed(e.getMessage());
        }
    }

    private void validateDateRange(Date toDate, Date fromDate) {
        if ((Objects.isNull(toDate) && Objects.nonNull(fromDate)) ||
                (Objects.isNull(fromDate) && Objects.nonNull(toDate))) {
            throw new RequestProcessingFailed(ResponseMessage.INVALID_DATE_RANGE);
        }
    }

    @Override
    public List<TopSellingRoutesResponse> getTopThreeSellingRoutes() {
        try {
            return ticketRepository.getTopThreeSellingRoute();
        } catch (Exception e) {
            throw new RequestProcessingFailed(e.getMessage());
        }
    }
}
