package com.pedro.spring_app;

import com.pedro.spring_app.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {
    @RequestMapping(value="/sum/{n1}/{n2}")
    public double sum(@PathVariable(value = "n1") String numberOne, @PathVariable(value="n2") String numberTwo){

        if(!isNumber(numberOne) || !isNumber(numberTwo)){
           throw new UnsupportedMathOperationException("Invalid Parameter!");
        }

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private double convertToDouble(String number) {
        if(number == null){
            return 0d;
        }

        if(isNumber(number)) return Double.parseDouble(number);
        return 0.0D;
    }

    private boolean isNumber(String numberOne) {
        if (numberOne == null) return false;
        String number = numberOne.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    @RequestMapping(value = "/soma", method=RequestMethod.GET)
    public int soma(@RequestParam(value="n1", defaultValue="0") String v1, @RequestParam(value="n2", defaultValue="0") String v2){
        return Integer.valueOf(v1)+Integer.valueOf(v2);

    }
}
