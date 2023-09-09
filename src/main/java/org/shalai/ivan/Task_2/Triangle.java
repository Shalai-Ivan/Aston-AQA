package org.shalai.ivan.Task_2;

public class Triangle extends Figure implements Perimeter, Square {
    private double aSide;
    public double getASide() {
        return aSide;
    }

    private double bSide;
    public double getBSide() {
        return bSide;
    }

    private double cSide;
    public double getCSide() {
        return cSide;
    }

    private double hSide;

    @Override
    public double getSquare() {
        return (aSide * hSide) / 2;
    }

    public Triangle(double aSide, double bSide, double cSide, double hSide, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.aSide = aSide;
        this.bSide = bSide;
        this.cSide = cSide;
        this.hSide = hSide;
    }
    public void getInfo() {
        System.out.println("Периметр треугольника - " + getPerimeter(Triangle.this));
        System.out.println("Площадь треугольника - " + getSquare());
        System.out.println("Цвет заливки треугольника- " + getFillColor());
        System.out.println("Цвет границ треугольника - " + getBorderColor());
    }
}
