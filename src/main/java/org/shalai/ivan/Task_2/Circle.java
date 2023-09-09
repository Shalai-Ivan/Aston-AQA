package org.shalai.ivan.Task_2;

public class Circle extends Figure implements Perimeter, Square {
    private double radius;
    public double getRadius() {
        return radius;
    }
    @Override
    public double getSquare() {
        return 3.14 * Math.pow(radius, 2);
    }

    public Circle(double radius, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.radius = radius;
    }

    public void getInfo() {
        System.out.println("Периметр круга - " + getPerimeter(Circle.this));
        System.out.println("Площадь круга - " + getSquare());
        System.out.println("Цвет заливки круга- " + getFillColor());
        System.out.println("Цвет границ круга - " + getBorderColor());
    }
}
