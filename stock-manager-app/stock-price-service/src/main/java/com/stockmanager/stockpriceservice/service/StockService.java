package com.stockmanager.stockpriceservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmanager.stockpriceservice.repo.StockRepository;
import rx.Observable;
import rx.schedulers.Schedulers;

import com.stockmanager.stockpriceservice.model.Stock;

@Service
@SuppressWarnings("deprecation")
public class StockService {

	@Autowired
	private StockRepository repo;

	public Observable<List<Stock>> getAll(){
		return Observable.<List<Stock>>create(s->{

			List<Stock> list = repo.findAll();
			s.onNext(list);
			s.onCompleted();
		}).subscribeOn(Schedulers.newThread());
	}
	
	public Observable<Stock> getbyName(String name){
		return Observable.<Stock>create(s->{
			Stock stock = repo.findByName(name);
			s.onNext(stock);
			s.onCompleted();
		}).subscribeOn(Schedulers.newThread());
	}

}
