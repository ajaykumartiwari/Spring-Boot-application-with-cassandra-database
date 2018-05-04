package com.event.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.event.exception.ExceptionResponse;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> generalException(Exception exception) throws Exception {
        
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        
        exceptionResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        
        exceptionResponse.setDescription(exception.getMessage());
        
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
