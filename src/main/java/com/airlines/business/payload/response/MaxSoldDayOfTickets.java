package com.airlines.business.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MaxSoldDayOfTickets {
    private String maxSellDate;
    private Long maxSellTicket;
}
