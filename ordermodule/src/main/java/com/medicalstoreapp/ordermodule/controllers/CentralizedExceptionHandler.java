package com.medicalstoreapp.ordermodule.controllers;


import java.time.format.DateTimeParseException;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.medicalstoreapp.ordermodule.exceptions.InvalidPeriodException;
import com.medicalstoreapp.ordermodule.exceptions.OrderNotFoundException;

@RestControllerAdvice
public class CentralizedExceptionHandler {
	
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(OrderNotFoundException.class)
    public String handleOrderNotFound(OrderNotFoundException e) {
        return e.getMessage();
    }
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPeriodException.class)
	public String handleInvalidPeriod(InvalidPeriodException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public String handleConstraintViolationException(ConstraintViolationException e){
        return e.getMessage();
    }
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DateTimeParseException.class)
    public String handleDateTimeParseException(DateTimeParseException e){
        return "Please provide a valid date";
    }
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalStateException.class)
    public String handleIllegalException(IllegalStateException e){
        return e.getMessage();
    }
	
	
}
