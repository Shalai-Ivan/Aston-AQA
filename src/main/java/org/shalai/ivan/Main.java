package org.shalai.ivan;

import org.apache.commons.math3.util.Precision;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println(convertNumber("530,89999921".replace(",", ".")));
    }

//    private static Double convertNumber(String str) {
//        Pattern pattern = Pattern.compile("[+-]?[0-9]+(.[0-9]+)?");
//        Matcher matcher = pattern.matcher(str);
//        StringBuilder result = new StringBuilder();
//        while (matcher.find()) {
//            result.append(matcher.group());
//        }
//        return Double.parseDouble(result.toString());
//    }

    private static Double convertNumber(String str) {
        Pattern pattern = Pattern.compile("[+-]?[0-9]+(.[0-9]+)?");
        Matcher matcher = pattern.matcher(str);
        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            result.append(matcher.group());
        }
        return Precision.round(Double.parseDouble(result.toString()), 2);
    }
}