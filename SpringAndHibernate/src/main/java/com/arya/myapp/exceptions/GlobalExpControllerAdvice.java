package com.arya.myapp.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExpControllerAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(HttpServletRequest request, Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		error.setApiCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		error.setMessage("Please contact your administrator");
		error.setDeveloperMessage(ex.getCause().toString());
		error.setUrl(request.getRequestURL().toString());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
