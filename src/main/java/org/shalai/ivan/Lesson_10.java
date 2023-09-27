package org.shalai.ivan;

public class Lesson_10 {
    public static void main(String[] args) {
        Box<Apple> boxApple1 = new Box<>(new Apple());
        boxApple1.addFruit(4);
        System.out.println("Weight of boxApple1 is " + boxApple1.getWeight());

        Box<Orange> boxOrange = new Box<>(new Orange());
        boxOrange.addFruit(4);
        System.out.println("Weight of boxOrange is " + boxOrange.getWeight());

        System.out.println("Compare method is " + boxApple1.compare(boxOrange));

        Box<Apple> boxApple2 = new Box<>(new Apple());
        boxApple2.addFruit(2);
        boxApple1.toSprinkleFruits(boxApple2);
        System.out.println("Weight of boxApple1 after sprinkling is " + boxApple1.getWeight());
        System.out.println("Weight of boxApple2 after sprinkling is " + boxApple2.getWeight());

        System.out.println("Compare method after sprinkling is " + boxApple2.compare(boxOrange));
    }
}