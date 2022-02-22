package com.example.limitsservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.limitsservice.configuration.Configuratio;
import com.example.limitsservice.entity.Limits;

@RestController
public class LimitsController {

	@Autowired
	private Configuratio configuration;
	
	@GetMapping("/limits")
	public Limits retrieveLimits() {
		
		return new Limits(configuration.getMinimum(),configuration.getMaximum());
	}
	
	
}
