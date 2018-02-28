package com.stockmanager.userstockservice.exception;

import java.time.LocalDateTime;
import java.util.Calendar;

public class ErrorDetail {

	private String time;
	
	private String message;
	
	private String Detail;

	public ErrorDetail(String time, String message, String detail) {
		super();
		this.time = time;
		this.message = message;
		Detail = detail;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return Detail;
	}

	public void setDetail(String detail) {
		Detail = detail;
	}
	
	
}
