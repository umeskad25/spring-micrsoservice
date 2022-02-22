package com.example.currencyconversionservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.currencyconversionservice.model.CurrencyConversion;
@Component
//@FeignClient(name = "currency-exchange",url = "localhost:8000")
@FeignClient(name = "currency-exchange")
public interface CurrencyEchangeProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retriveExchangeValue(@PathVariable 	String from,@PathVariable String to ) ;
	
}
