package com.pedro.spring_app;

import com.pedro.spring_app.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import static com.pedro.spring_app.numeric.NumericHelper.convertToDouble;
import static com.pedro.spring_app.numeric.NumericHelper.isNumber;


@RestController
public class MathController {
    @RequestMapping(value="/sum")
    public double sum(@RequestParam(value = "x") String numberOne, @RequestParam(value="y") String numberTwo){

        if(!isNumber(numberOne) || !isNumber(numberTwo)){
           throw new UnsupportedMathOperationException("Invalid Parameter!");
        }

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping(value="/sub")
    public double subtraction(@RequestParam(value = "x") String numberOne, @RequestParam(value="y") String numberTwo){

        if(!isNumber(numberOne) || !isNumber(numberTwo)){
            throw new UnsupportedMathOperationException("Invalid Parameter!");
        }

        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/div")
    public double division(@RequestParam("x") String numberOne, @RequestParam("y") String numberTwo){

        if(!isNumber(numberOne) || !isNumber(numberTwo)){
            throw new UnsupportedMathOperationException("Invalid Parameter!");
        }

        double denominator = convertToDouble(numberTwo);

        if(denominator == 0){
            throw new UnsupportedMathOperationException("Can't divide by zero");
        }

        return convertToDouble(numberOne)/denominator;
    }

    @RequestMapping(value="/sqrt")
    public double squareRoot(@RequestParam("x") String number){
        if(!isNumber(number)){
            throw new UnsupportedMathOperationException("Invalid Parameter!");
        }

        double numberDouble = convertToDouble(number);

        if(numberDouble<0){
            throw new UnsupportedMathOperationException("Complex numbers not supported");
        }

        return Math.sqrt(numberDouble);

    }

    @RequestMapping(value="/mult")
    public double multiplication(@RequestParam(value = "x") String numberOne, @RequestParam(value="y") String numberTwo){

        if(!isNumber(numberOne) || !isNumber(numberTwo)){
            throw new UnsupportedMathOperationException("Invalid Parameter!");
        }

        return convertToDouble(numberOne)*convertToDouble(numberTwo);
    }
}
