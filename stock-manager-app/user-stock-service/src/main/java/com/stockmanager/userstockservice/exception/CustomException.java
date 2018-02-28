package com.stockmanager.userstockservice.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public HttpStatus status;

	public CustomException(String message,HttpStatus status) {
		super(message);
		this.status = status;

	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	
}
