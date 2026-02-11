package com.Rubens_Santos_Costa.controllers;


import java.math.RoundingMode;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Rubens_Santos_Costa.exception.UnsupportedMathOperationException;

@RestController
@RequestMapping("/squareroot")
public class SquareRoot {
    //verificador se é numero ou nao
    private MathNumeric numeric = new MathNumeric();




    //http://localhost:8080/squareroot/square/82
    @RequestMapping("/square/{numberOne}")
    public Double square(@PathVariable("numberOne") String numberOne)throws Exception {
        //verificando se é um numero
        if(!numeric.isNumeric(numberOne)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        //verificando se é um numero negativo
        if (numeric.convertToDouble(numberOne) < 0) throw new UnsupportedMathOperationException("Please enter a number that is not negative.");
        //verificando se é 1 ou 0
        if (numeric.convertToDouble(numberOne) == 0 || numeric.convertToDouble(numberOne) == 1) {
            return numeric.convertToDouble(numberOne);
        }
        
        
        double precisao = 0.000001; // Precisão desejada
        double estimativa = numeric.convertToDouble(numberOne); // Estimativa inicial
        
        while (Math.abs(estimativa - numeric.convertToDouble(numberOne)/estimativa) > precisao * estimativa) {
            estimativa = (numeric.convertToDouble(numberOne)/estimativa + estimativa) / 2.0;
        }

        //formatar numero decimal

        BigDecimal bd = new BigDecimal(Double.toString(estimativa));
        bd = bd.setScale(3, RoundingMode.HALF_UP);
        double valorFinal = bd.doubleValue();

        return valorFinal;
    
    }

}
