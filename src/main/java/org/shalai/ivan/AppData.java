package org.shalai.ivan;

public class AppData {
    private String[] header = {"Value1; ", "Value2; ", "Value3"};
    public String[] getHeader() {
        return header;
    }

    private int[][] data = {{100, 200, 123}, {300, 400, 500}};
    public int[][] getData() {
        return data;
    }
}
