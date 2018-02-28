package com.stockmanager.stockpriceservice.controller;

import com.stockmanager.stockpriceservice.model.Stock;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import com.stockmanager.stockpriceservice.service.StockService;

@RestController
@RequestMapping("/stock/")
public class StockController {

	@Autowired
	private StockService service;

	@RequestMapping(value = "/" , method=RequestMethod.GET)
	public DeferredResult<ResponseEntity<List<Stock>>> getAll() {

		DeferredResult<ResponseEntity<List<Stock>>> result = new DeferredResult<>(); ;

		service.getAll().
		subscribe(list -> {
			result.setResult(new ResponseEntity<>(list,HttpStatus.OK));
		}, e-> result.setErrorResult(e)	
				);
		return result;
	}

	@RequestMapping(value = "/{name}" , method=RequestMethod.GET)
	public DeferredResult<ResponseEntity<Stock>> getByName(@PathVariable("name") String name) {

		DeferredResult<ResponseEntity<Stock>> result = new DeferredResult<>(); ;

		service.getbyName(name).
		subscribe(stock -> {
			result.setResult(new ResponseEntity<>(stock,HttpStatus.OK));
		}, e-> result.setErrorResult(e)	
				);
		return result;
	}

}
