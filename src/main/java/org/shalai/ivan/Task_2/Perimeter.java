package org.shalai.ivan.Task_2;

public interface Perimeter {
    default double getPerimeter(Figure figure) {
        if (figure instanceof Circle) {
            return 2 * 3.14 * ((Circle) figure).getRadius();
        } else if (figure instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) figure;
            return rectangle.getASide() * 2 + rectangle.getBSide() * 2;
        } else if (figure instanceof Triangle) {
            Triangle triangle = (Triangle) figure;
            return triangle.getASide() + triangle.getBSide() + triangle.getCSide();
        } else {
            System.out.println("Error");
            return -1;
        }
    }
}
