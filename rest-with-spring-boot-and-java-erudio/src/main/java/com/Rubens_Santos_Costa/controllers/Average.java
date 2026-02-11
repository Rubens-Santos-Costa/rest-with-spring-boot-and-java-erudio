package com.Rubens_Santos_Costa.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Rubens_Santos_Costa.exception.UnsupportedMathOperationException;

@RestController
@RequestMapping("/average")
public class Average {
        //verificador se é numero ou nao
    private MathNumeric numeric = new MathNumeric();


    //http://localhost:8080/average/ave/3/5
    @RequestMapping("/ave/{numberOne}/{numberTwo}")
    public Double ave(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)throws Exception {
        if(!numeric.isNumeric(numberOne) || !numeric.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return (numeric.convertToDouble(numberOne) + numeric.convertToDouble(numberTwo)) / 2;
    }

}
