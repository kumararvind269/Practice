package com.stockmanager.userstockservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="STCK_TRAN_TBL")
public class UserStock {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column
	private String userName;
	
	@Column
	private String stockName;
	
	@Column
	private int stockPrice;
	
	@Column
	private int stockQuantity;

	public UserStock(int id, String userName, String stockName, int stockPrice, int stockQuantity) {
		super();
		this.id = id;
		this.userName = userName;
		this.stockName = stockName;
		this.stockPrice = stockPrice;
		this.stockQuantity = stockQuantity;
	}

	public UserStock() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(int stockPrice) {
		this.stockPrice = stockPrice;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	@Override
	public String toString() {
		return "UserStock [id=" + id + ", userName=" + userName + ", stockName=" + stockName + ", stockPrice="
				+ stockPrice + ", stockQuantity=" + stockQuantity + "]";
	}
	
}
