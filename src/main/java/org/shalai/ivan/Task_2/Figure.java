package org.shalai.ivan.Task_2;

public class Figure {
    private String fillColor;
    public String getFillColor() {
        return fillColor;
    }

    private String borderColor;
    public String getBorderColor() {
        return borderColor;
    }

    Figure(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
}
