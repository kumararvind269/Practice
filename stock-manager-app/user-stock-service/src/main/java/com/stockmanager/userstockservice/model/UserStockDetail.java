package com.stockmanager.userstockservice.model;

import java.util.ArrayList;
import java.util.List;

public class UserStockDetail {
	
	private String user;
	
	private List<StockDetail> stock = new ArrayList<>();

	
	public UserStockDetail() {
		super();
	}


	public UserStockDetail(String user, List<StockDetail> stock) {
		super();
		this.user = user;
		this.stock = stock;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public List<StockDetail> getStock() {
		return stock;
	}


	public void setStock(List<StockDetail> stock) {
		this.stock = stock;
	}
	
	
	
	@Override
	public String toString() {
		return "UserStockDetail [user=" + user + ", stock=" + stock + "]";
	}



	public static class StockDetail {
		
		private String name;
		
		private int buyPrice;
		
		private int currPrice;

		
		public StockDetail() {
			super();
		}


		public StockDetail(String name, int buyPrice, int currPrice) {
			super();
			this.name = name;
			this.buyPrice = buyPrice;
			this.currPrice = currPrice;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public int getBuyPrice() {
			return buyPrice;
		}


		public void setBuyPrice(int buyPrice) {
			this.buyPrice = buyPrice;
		}


		public int getCurrPrice() {
			return currPrice;
		}


		public void setCurrPrice(int currPrice) {
			this.currPrice = currPrice;
		}


		@Override
		public String toString() {
			return "StockDetail [name=" + name + ", buyPrice=" + buyPrice + ", currPrice=" + currPrice + "]";
		}
		
		
		
	}

}
