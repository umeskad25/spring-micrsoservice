package com.example.currencyexchangeservice.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrencyExchangeDB {

	

	@Id
	private String transctionId;
	@Column(name = "currency_from")
	private String from;
	@Column(name = "currency_to")
	private String to;
	private BigDecimal conversionMultiple;
	private String environment;
	private Timestamp timeStamp;
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	
	
	public CurrencyExchangeDB(String transctionId, String from, String to, BigDecimal conversionMultiple,
			String environment, Timestamp timeStamp) {
		super();
		this.transctionId = transctionId;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.environment = environment;
		this.timeStamp = timeStamp;
	}
	public CurrencyExchangeDB() {
		super();
	}
	public CurrencyExchangeDB(String transctionId, String from, String to, BigDecimal conversionMultiple,
			String environment) {
		super();
		this.transctionId = transctionId;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.environment = environment;
	}
	public String getTransctionId() {
		return transctionId;
	}
	public void setTransctionId(String transctionId) {
		this.transctionId = transctionId;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
}
