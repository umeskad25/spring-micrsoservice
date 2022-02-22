package com.example.currencyexchangeservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.currencyexchangeservice.entity.CurrencyExchange;

public interface CurrencyExchageRepository extends JpaRepository<CurrencyExchange, Long> {

	CurrencyExchange findByFromAndTo(String from,String to);
}
