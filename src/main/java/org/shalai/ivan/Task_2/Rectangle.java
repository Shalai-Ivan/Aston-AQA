package org.shalai.ivan.Task_2;

public class Rectangle extends Figure implements Perimeter, Square {
    private double aSide;
    public double getASide() {
        return aSide;
    }
    private double bSide;
    public double getBSide() {
        return bSide;
    }

    @Override
    public double getSquare() {
        return aSide * bSide;
    }

    public Rectangle(double aSide, double bSide, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.aSide = aSide;
        this.bSide = bSide;
    }

    public void getInfo() {
        System.out.println("Периметр прямоугольника - " + getPerimeter(Rectangle.this));
        System.out.println("Площадь прямоугольника - " + getSquare());
        System.out.println("Цвет заливки прямоугольника- " + getFillColor());
        System.out.println("Цвет границ прямоугольника - " + getBorderColor());
    }
}
