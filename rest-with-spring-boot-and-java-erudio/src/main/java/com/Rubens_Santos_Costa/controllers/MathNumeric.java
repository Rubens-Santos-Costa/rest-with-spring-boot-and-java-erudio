package com.Rubens_Santos_Costa.controllers;

import com.Rubens_Santos_Costa.exception.UnsupportedMathOperationException;

public class MathNumeric {
    protected Double convertToDouble(String strNumber)throws IllegalArgumentException{
        //se estiver nulo ou vazio retorne falso
        if(strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value!");
        //trocando a virgula por ponto R$5,90(incorreto) => R$5.90(desejado)
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    protected boolean isNumeric(String strNumber){
        //se estiver nulo ou vazio retorne falso
        if(strNumber == null || strNumber.isEmpty()) return false;
        //trocando a virgula por ponto R$5,90(incorreto) => R$5.90(desejado)
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+"); 

    }
}
