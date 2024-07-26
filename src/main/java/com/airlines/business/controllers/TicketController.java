package com.airlines.business.controllers;

import com.airlines.business.common.ApiResponse;
import com.airlines.business.enums.ResponseMessage;
import com.airlines.business.payload.response.MaxSoldDayOfTickets;
import com.airlines.business.payload.response.TopSellingRoutesResponse;
import com.airlines.business.payload.response.TotalSellAmountFromTicketAndFoodResponse;
import com.airlines.business.service.ITicketService;
import com.airlines.business.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class TicketController {
    private final ITicketService iTicketService;

    @GetMapping("/ticket-and-food-sold")
    public ApiResponse<TotalSellAmountFromTicketAndFoodResponse>
    getTotalSellAmountFromTicketAndFoodResponse() {
        try {
            log.info("+++++++++ Get Total Sell Amount From Ticket And Food Response API");
            return ResponseUtils.createResponseObject(ResponseMessage.OPERATION_SUCCESSFUL,
                    iTicketService.getTotalSellAmountFromTicketAndFoodOfPresentDay());
        } catch (Exception e) {
            log.error
                    ("+++++++++ Error in Get Total Sell Amount From Ticket And Food Response API " + " " + e.getMessage());
            return ResponseUtils.createResponseObject(e.getMessage());
        }
    }

    @GetMapping("/ticket/max-sell-day")
    public ApiResponse<MaxSoldDayOfTickets> getMaxSellDayOfAllTickets(
            @RequestParam(required = false, value = "fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
            @RequestParam(required = false, value = "toDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) {
        try {
            log.info("+++++++++ Get Max Sell Day Of All Tickets Response API");
            return ResponseUtils.createResponseObject(ResponseMessage.OPERATION_SUCCESSFUL,
                    iTicketService.getMaxSellDayOfAllTickets(toDate, fromDate));
        } catch (Exception e) {
            log.error
                    ("+++++++++ Error in Get Max Sell Day Of All Tickets Response API " + " " + e.getMessage());
            return ResponseUtils.createResponseObject(e.getMessage());
        }
    }

    @GetMapping("/routes/top-3")
    public ApiResponse<List<TopSellingRoutesResponse>> getTopThreeSellingRoutes() {
        try {
            log.info("+++++++++ Get Top Three Selling Routes Response API");
            return ResponseUtils.createResponseObject(ResponseMessage.OPERATION_SUCCESSFUL,
                    iTicketService.getTopThreeSellingRoutes());
        } catch (Exception e) {
            log.error
                    ("+++++++++ Error in Get Top Three Selling Routes Response API " + " " + e.getMessage());
            return ResponseUtils.createResponseObject(e.getMessage());
        }
    }
}
