package com.stockmanager.userstockservice.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.util.UriComponentsBuilder;

import com.stockmanager.userstockservice.exception.CustomException;
import com.stockmanager.userstockservice.model.Stock;
import com.stockmanager.userstockservice.model.UserStock;
import com.stockmanager.userstockservice.model.UserStockDetail;
import com.stockmanager.userstockservice.model.User;
import com.stockmanager.userstockservice.service.StockDetailService;
import com.stockmanager.userstockservice.service.UserService;

@RestController
@RequestMapping(value="/stockservice/")
public class StockDetailController {

	@Autowired
	StockDetailService stockService;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/stockprice/{name}" , method=RequestMethod.GET)
	public DeferredResult<ResponseEntity<Stock>> getStockPrice(@PathVariable("name") String name) {

		DeferredResult<ResponseEntity<Stock>> result = new DeferredResult<>();
		stockService.getStockPrice(name).
		subscribe(stock -> {
			result.setResult(new ResponseEntity<Stock>(stock,HttpStatus.OK));
		}, e-> result.setErrorResult(e)	
				);
		return result;
	}

	@RequestMapping(value = "/buystock/{user}/{stock}/{quantity}" , method=RequestMethod.GET)
	public ResponseEntity<UserStock> buyStock(@PathVariable("user") String userName
			,@PathVariable("stock") String stockName,@PathVariable("quantity") int quantity) {

		if(quantity<=0)
			throw new CustomException("Quantity Should be greater than 0",HttpStatus.CONFLICT);

		User user = userService.getByName(userName).toBlocking().first();
		Stock stock ;
		try {
			stock = stockService.getStockPrice(stockName).toBlocking().first();
		}catch(NoSuchElementException ex){
			throw new CustomException("No Stock Found with Name: "+stockName,HttpStatus.CONFLICT);
		}

		UserStock sd = stockService.findByUserNameAndStockName(user.getName(),stock.getName());
		if(sd==null)
			sd = new UserStock(-1, user.getName(),stock.getName(), stock.getPrice(), quantity);
		else{
			sd.setStockPrice(stock.getPrice());
			sd.setStockQuantity(quantity);
		}
		sd = stockService.save(sd);		
		return new ResponseEntity<UserStock>(sd,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/viewStock/{user}" , method=RequestMethod.GET)
	public DeferredResult<ResponseEntity<UserStockDetail>> viewStock(@PathVariable("user") String userName) {

		User user = userService.getByName(userName).toBlocking().first();
		DeferredResult<ResponseEntity<UserStockDetail>> result = new DeferredResult<>();
		stockService.getUserStockDetail(userName).
		subscribe(userStockDetail -> {
			result.setResult(new ResponseEntity<UserStockDetail>(userStockDetail,HttpStatus.OK));
		}, e-> result.setErrorResult(e)	
				);
		return result;
	}


}
