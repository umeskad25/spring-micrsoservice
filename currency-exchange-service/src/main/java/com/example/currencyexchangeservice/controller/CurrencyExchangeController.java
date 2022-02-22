package com.example.currencyexchangeservice.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.currencyexchangeservice.dao.CurrencyExchageRepository;
import com.example.currencyexchangeservice.dao.CurrencyExchageRepository2;
import com.example.currencyexchangeservice.entity.CurrencyExchange;
import com.example.currencyexchangeservice.entity.CurrencyExchangeDB;

@RestController
public class CurrencyExchangeController {

	private static Integer id=0;
	
	@Autowired
	private Environment environment;
	@Autowired
	CurrencyExchageRepository repository;
	@Autowired
	CurrencyExchageRepository2 repository2;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retriveExchangeValue(@PathVariable 	String from,@PathVariable String to ) {
	
		//CurrencyExchange c=	new CurrencyExchange(1001L,from,to,BigDecimal.valueOf(50));
		CurrencyExchange c= repository.findByFromAndTo(from, to);
		String port = environment.getProperty("local.server.port");
		c.setEnvironment(port);
		if(c==null) {
			throw new RuntimeException("unable to find");
		}
		id++;
		String uniqueId = "A"+id;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		CurrencyExchangeDB  dbEntity = new CurrencyExchangeDB(uniqueId,c.getFrom(),c.getTo(),c.getConversionMultiple(),
				c.getEnvironment(),timestamp);
		repository2.save(dbEntity);
		return c;
	}
	
}
