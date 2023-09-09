package org.shalai.ivan;

import org.shalai.ivan.Task_1.*;
import org.shalai.ivan.Task_2.*;

public class Lesson_5 {
    public static void main(String[] args) {
        // TASK 1.1, 1.2, 1.3
        Cat catBob = new Cat("Боб", 33);
        catBob.swim(10);
        Dog dogJessi = new Dog("Джесcи");
        dogJessi.run(350);
        System.out.println();

        // TASK 1.4
        System.out.println("Количество котов - " + Cat.catsCount);
        System.out.println("Количество собак - " + Dog.dogsCount);
        new Cat("Фиби", 28);
        new Dog("Бафи");
        System.out.println("Количество котов - " + Cat.catsCount);
        System.out.println("Количество собак - " + Dog.dogsCount);
        System.out.println();

        // TASK 1.5
        Cat[] cats = { new Cat("Муся", 30),
                       new Cat("Персик", 35),
                       new Cat("Мишель", 27)};
        Plate plate = new Plate(70);
        for (Cat cat : cats) {
            cat.eat(plate);
        }
        plate.addFood(30);
        cats[2].eat(plate);
        System.out.println();

        // TASK 2.0
        Circle circle = new Circle(5.5, "Green", "Red");
        Rectangle rectangle = new Rectangle(5, 2.5, "Yellow", "Orange");
        Triangle triangle = new Triangle(6.2, 3, 4.5, 3.6, "Grey", "Black");
        circle.getInfo();
        rectangle.getInfo();
        triangle.getInfo();
    }
}