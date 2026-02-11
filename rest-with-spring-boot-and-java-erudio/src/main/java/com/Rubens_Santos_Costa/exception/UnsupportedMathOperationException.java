package com.Rubens_Santos_Costa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


//vai gerar o Status code para tratativa de erro
@ResponseStatus(HttpStatus.BAD_REQUEST)

public class UnsupportedMathOperationException extends RuntimeException{
    public UnsupportedMathOperationException(String message) {
        super(message);
    }

}
