package com.Rubens_Santos_Costa.exception;

import java.util.Date;

//vai gerar um JSON para tratativa de erro
public record ExceptionResponse(Date timestamp,String message, String details) {}
