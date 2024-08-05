package com.erudio.rest_with_spring.Handler;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.erudio.rest_with_spring.exceptions.ExceptionResponse;
import com.erudio.rest_with_spring.exceptions.UnsupportedMathOperationsException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    //implementando para exceções genéricas
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(
        Exception ex,WebRequest request){

        ExceptionResponse  exceptionResponse = new ExceptionResponse(
            new Date(), 
            ex.getMessage(),
            request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    //implementando uma exceção customizada de bad request
    @ExceptionHandler(UnsupportedMathOperationsException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(
        Exception ex, WebRequest request){
            ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
                return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
        }
}
