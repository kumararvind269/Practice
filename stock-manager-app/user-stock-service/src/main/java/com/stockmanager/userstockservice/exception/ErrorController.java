package com.stockmanager.userstockservice.exception;

import java.time.LocalDateTime;
import java.util.Calendar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorController{

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorDetail> Errorhandler(CustomException cex, WebRequest wq) {

		ErrorDetail ed = new ErrorDetail(LocalDateTime.now().toString(),cex.getMessage(),wq.getDescription(false));

		return new ResponseEntity<ErrorDetail>(ed,cex.status);
	}

}
