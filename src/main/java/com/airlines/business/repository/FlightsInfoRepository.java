package com.airlines.business.repository;

import com.airlines.business.models.FlightsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightsInfoRepository extends JpaRepository<FlightsInfo, Long> {
}
