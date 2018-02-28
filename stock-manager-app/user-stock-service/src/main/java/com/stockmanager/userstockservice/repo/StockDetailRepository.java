package com.stockmanager.userstockservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockmanager.userstockservice.model.UserStock;

public interface StockDetailRepository extends JpaRepository<UserStock, Integer> {

	UserStock findByUserNameAndStockName(String user, String stock);

	List<UserStock> findByUserName(String userName);

}
