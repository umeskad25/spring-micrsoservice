package com.example.currencyexchangeservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.currencyexchangeservice.entity.CurrencyExchange;
import com.example.currencyexchangeservice.entity.CurrencyExchangeDB;

public interface CurrencyExchageRepository2 extends JpaRepository<CurrencyExchangeDB, String> {

	CurrencyExchange findByFromAndTo(String from,String to);
}
