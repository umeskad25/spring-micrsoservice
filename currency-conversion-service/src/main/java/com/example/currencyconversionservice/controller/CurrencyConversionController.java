package com.example.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.currencyconversionservice.model.CurrencyConversion;

@RestController
public class CurrencyConversionController {


	@Autowired(required=true)
	CurrencyEchangeProxy p;
	
	@GetMapping("/currency-exchange-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from,@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		
		CurrencyConversion  c = p.retriveExchangeValue(from, to);

		return new CurrencyConversion(c.getId(),from,to,quantity,c.getConversionMultiple(),
				quantity.multiply(c.getConversionMultiple()),c.getEnvironment() );
	}
	
	
	
	
	
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		
		HashMap<String,String> uriVariable = new HashMap<String, String>() ;
		uriVariable.put("from", from);
		uriVariable.put("to", to);
		
		ResponseEntity<CurrencyConversion> currencyConversion = 
				new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
						CurrencyConversion.class,uriVariable);
		
		CurrencyConversion  c = currencyConversion.getBody();

		return new CurrencyConversion(c.getId(),from,to,quantity,c.getConversionMultiple(),
				quantity.multiply(c.getConversionMultiple()),c.getEnvironment() );
	}
	
	
}
