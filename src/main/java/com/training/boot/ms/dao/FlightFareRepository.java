package com.training.boot.ms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.boot.ms.model.FlightFare;


public interface FlightFareRepository extends JpaRepository<FlightFare, Long> {

	
	
	
	
	
}
