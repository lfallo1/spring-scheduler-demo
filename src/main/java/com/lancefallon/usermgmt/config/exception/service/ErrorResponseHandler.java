package com.lancefallon.usermgmt.config.exception.service;

import java.io.IOException;

import javax.security.sasl.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lancefallon.usermgmt.config.exception.domain.CustomErrorMessage;
import com.lancefallon.usermgmt.config.exception.domain.InvalidCredentialsException;
import com.lancefallon.usermgmt.config.exception.domain.PageNotFoundException;

/**
 * global error handler / response generator
 * @author lancefallon
 *
 */
@ControllerAdvice
public class ErrorResponseHandler {
	@ExceptionHandler({AuthenticationException.class})
    ResponseEntity<String> handleAuthenticationException(AuthenticationException ex) throws IOException {
        return new ResponseEntity<String>("Authentication exception: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(InvalidCredentialsException.class)
    ResponseEntity<CustomErrorMessage> handleInvalidCredentialsException(InvalidCredentialsException ex) throws IOException {
        return new ResponseEntity<CustomErrorMessage>(ex.getError(), HttpStatus.FORBIDDEN);
    }
	
	@ExceptionHandler(PageNotFoundException.class)
    ResponseEntity<String> handlePageNotFound(PageNotFoundException ex) throws IOException {
        return new ResponseEntity<String>("Page not found", HttpStatus.NOT_FOUND);
    }
}