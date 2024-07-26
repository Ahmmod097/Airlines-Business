package com.airlines.business.payload.response;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaginationResponse<T> implements Serializable {
    private Integer currentPage;
    private Integer pageSize;
    private Long totalItems;
    private Integer totalPages;
    private List<T> data;
}
