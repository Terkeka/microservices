package com.microservice.dbservice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.model.Quote;
import com.microservice.model.Quotes;
import com.microservice.repository.QuoteRepository;

@RestController
@RequestMapping("/rest/db")
public class DbServiceController {
	
	@Autowired
	private QuoteRepository quoteRepository;
	

	/*
	 * public DbServiceController(QuoteRepository quoteRepository) {
	 * 
	 * this.quoteRepository = quoteRepository; }
	 */

	@GetMapping("{username}")
	public List<String> getQuotes(@PathVariable("username") final String username){
		
		return  quoteRepository.findByUserName(username)
		  .stream()
		  .map(Quote::getQuote)
		  .collect(Collectors.toList());
	}
	
	
	
	@PostMapping("/delete/{username}")
	public List<String> delete(@PathVariable("username") final String username){
	    List<Quote> quotes = quoteRepository.findByUserName(username);
	    
	    quoteRepository.deleteAll(quotes);
	    
	    return getByUserName(username);
	}
	
	@PostMapping("/add")
	public List<String> add(@RequestBody final Quotes quotes){
				
		quotes.getQuotes()
		  .stream()
		  .map(quote -> new Quote(quotes.getUserName(), quote))
		  .forEach(quote -> quoteRepository.save(quote));
		
		return getByUserName(quotes.getUserName());
	}
	
	private List<String> getByUserName(String username){
		
		return  quoteRepository.findByUserName(username)
		  .stream()
		  .map(Quote::getQuote)
		  .collect(Collectors.toList());
	}
}
