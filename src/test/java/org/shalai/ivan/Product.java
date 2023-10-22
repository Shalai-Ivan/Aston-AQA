package org.shalai.ivan;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }

    public Product(String name, String price, String quantity) {
        this.name = name;
        this.price = convertNumber(price.replace(",", "."));
        this.quantity = Integer.parseInt(quantity);
    }

    public static Double convertNumber(String str) {
        Pattern pattern = Pattern.compile("[+-]?[0-9]+(.[0-9]+)?");
        Matcher matcher = pattern.matcher(str);
        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            result.append(matcher.group());
        }
        return Double.parseDouble(result.toString());
    }
}
