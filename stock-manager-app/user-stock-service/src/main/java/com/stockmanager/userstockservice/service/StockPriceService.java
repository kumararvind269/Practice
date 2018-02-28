package com.stockmanager.userstockservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.stockmanager.userstockservice.model.Stock;
import com.stockmanager.userstockservice.repo.StockDetailRepository;

import rx.Observable;
import rx.schedulers.Schedulers;

@Service
@SuppressWarnings("deprecation")
public class StockPriceService {

	@Autowired
	StockDetailRepository stockRepo;

	@Autowired
	RestTemplate rest;

	public static final String STOCK_URI = "http://localhost:8000/stock/";

	public static final String STOCK_BCKUP_URI = "http://localhost:8001/stock/";

	public static final Stock[] stArray= {new Stock(10001,"A1",111), new Stock(10002,"A2",222)
			,new Stock(10003,"A3",333) ,new Stock(10004,"A4",444)};

	@HystrixCommand(fallbackMethod="getStockPriceAlt", groupKey="StockDetailService" 
			, commandKey="getStockPrice",threadPoolKey="helloThread",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "4"),
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "60000"),
					@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")
	}, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "30")})
	public Observable<Stock> getStockPrice(String stock) {
		return Observable.<Stock>create(s->{
			ResponseEntity<Stock> entity = null;
			try {
				entity = rest.exchange(STOCK_URI+stock,HttpMethod.GET,null,Stock.class);
			}catch(Exception e) {
				s.onError(e);
			}
			if(entity.getBody()!=null)
				s.onNext(entity.getBody());
			else
				s.onNext(null);
			s.onCompleted();
		}).subscribeOn(Schedulers.newThread());
	}

	public Observable<Stock> getStockPriceAlt(String stock) {
		/*return Observable.<Stock>create(s->{
			ResponseEntity<Stock> entity = null;
			try {
				entity = rest.exchange(STOCK_BCKUP_URI+stock,HttpMethod.GET,null,Stock.class);
			}catch(Exception e) {
				s.onError(e);
			}
			if(entity.getBody()!=null)
				s.onNext(entity.getBody());
			else
				s.onNext(null);
			s.onCompleted();
		}).subscribeOn(Schedulers.newThread());*/
		return Observable.from(stArray).filter(x-> x.getName().equals(stock));
	}

}
