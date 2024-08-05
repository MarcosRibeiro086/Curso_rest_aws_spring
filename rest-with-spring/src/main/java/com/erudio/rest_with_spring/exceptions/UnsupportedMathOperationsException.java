package com.erudio.rest_with_spring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationsException extends RuntimeException{
    
    public UnsupportedMathOperationsException(String ex) {
        super(ex);
    }

    private static final long seriealVersionUID=1L;
    
}
