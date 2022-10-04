package com.fabrickdemo.rest;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class AppExceptions extends ResponseEntityExceptionHandler 
{
 
  @ExceptionHandler(RestClientResponseException.class)
  public final ResponseEntity<Object> handleRestClientResponseException(RestClientResponseException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getResponseBodyAsString(), HttpStatus.valueOf(ex.getRawStatusCode()));
  }

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleGenericException(Exception ex, WebRequest request) {
    return new ResponseEntity<Object>("Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
  }

}