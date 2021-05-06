package com.training.boot.ms.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.boot.ms.dao.FlightFareRepository;
import com.training.boot.ms.model.FlightFare;

@RestController
@RequestMapping(value="/api/v1/flight/{flightcode}/fare/{currency}")
public class FlightFareController {

	@Autowired
	private FlightFareRepository repository;
	
	@Value("${base.currency}")
	private String baseCurrency;
	
	
	@GetMapping
	public FlightFare getSingleFareTicket(@PathVariable String flightCode, @PathVariable String currency)
	{
		FlightFare fare  = this.getFlightFare(flightCode);
		fare.setCurrency(currency);
		
		if(!baseCurrency.equals(currency)) {
			// conversion rate
		}
		return fare;
	}
	
	
	private FlightFare getFlightFare(String flightCode) {
		
		FlightFare flight = new FlightFare(null, flightCode, null);
		Example<FlightFare> flightFare = Example.of(flight);
		FlightFare fare = repository.findOne(flightFare).get();
		return fare;
	}
	
	// Call the currency conversion service here
	private BigDecimal getConversionBigDecimal(String toCurrency) {
		return null;
	}
	
	
}
