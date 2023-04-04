package com.pedro.spring_app.numeric;

public class NumericHelper {

    public static boolean isNumber(String numberOne) {
        if (numberOne == null) return false;
        String number = numberOne.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public static double convertToDouble(String number) {
        if(number == null){
            return 0d;
        }

        if(isNumber(number)) return Double.parseDouble(number);
        return 0.0D;
    }
}
