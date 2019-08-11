package com.microservice.stock;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



import yahoofinance.quotes.stock.StockQuote;

@RestController
@RequestMapping("rest/stock")
public class StockServiceController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("{username}")
	public List<StockQuote> getStock(@PathVariable("username") final String username){
		
		restTemplate.getForObject("http://localhost:8300/rest/db/" + username, List.class);
		
		return null;
	}

}
