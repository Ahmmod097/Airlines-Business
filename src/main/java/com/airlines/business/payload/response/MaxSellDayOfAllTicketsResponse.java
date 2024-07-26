package com.airlines.business.payload.response;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MaxSellDayOfAllTicketsResponse {
    private Date maxSellDate;
    private Long maxSellTicket;
}
