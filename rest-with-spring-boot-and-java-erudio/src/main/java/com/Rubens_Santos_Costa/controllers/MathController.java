package com.Rubens_Santos_Costa.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.Rubens_Santos_Costa.exception.UnsupportedMathOperationException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.Rubens_Santos_Costa.controllers.MathNumeric;


@RestController
@RequestMapping("/math")

public class MathController {
    //verificador se é numero ou nao
    private MathNumeric numeric = new MathNumeric();

    //http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo
    )throws Exception{
        if(!numeric.isNumeric(numberOne) || !numeric.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return numeric.convertToDouble(numberOne) + numeric.convertToDouble(numberTwo);

    }


}
