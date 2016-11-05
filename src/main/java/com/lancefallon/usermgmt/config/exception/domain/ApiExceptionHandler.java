package com.lancefallon.usermgmt.config.exception.domain;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
	@ExceptionHandler(InvalidCredentialsException.class)
    ResponseEntity<CustomErrorMessage> handleInvalidCredentialsException(InvalidCredentialsException ex) throws IOException {
        return new ResponseEntity<CustomErrorMessage>(ex.getError(), HttpStatus.FORBIDDEN);
    }
}
