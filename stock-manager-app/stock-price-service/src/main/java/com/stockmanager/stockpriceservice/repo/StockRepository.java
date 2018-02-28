package com.stockmanager.stockpriceservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockmanager.stockpriceservice.model.Stock;

public interface StockRepository extends JpaRepository<Stock,Integer> {

	public Stock findByName(String name);

}
