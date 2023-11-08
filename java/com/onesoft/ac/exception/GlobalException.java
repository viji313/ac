package com.onesoft.ac.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(NameNotFound.class)
	public ResponseEntity<Object>NameNotFoundhandling(NameNotFound a){
	return new ResponseEntity<>(a.getMessage(),HttpStatus.NOT_FOUND);
}
	@ExceptionHandler(PriceNotFound.class)
	public ResponseEntity<Object>PriceNotFoundhandling(PriceNotFound b){
	return new ResponseEntity<>(b.getMessage(),HttpStatus.NOT_FOUND);
}
}