package com.airlines.business.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TotalSellAmountFromTicketAndFoodResponse {
    private BigDecimal totalSoldAmountsFromTicket;
    private BigDecimal totalSoldAmountsFromFoods;
}
