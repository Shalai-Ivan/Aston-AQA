package org.shalai.ivan.Task_1;

import org.shalai.ivan.Task_1.Plate;

public class Cat extends Animal {
    public static int catsCount = 0;
    boolean satiety = false;
    private int appetite;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        catsCount += 1;
    }

    public void run (int distance) {
        if (distance > 200 || distance < 0) {
            System.out.printf("Извините, %s не может пробежать такую дистанцию\n", name);
        } else {
            System.out.printf("%s пробежал %s метров\n", name, distance);
        }
    }

    public void swim (int distance) {
        System.out.printf("Извините, %s не умеет плавать\n", name);
    }

    public void eat (Plate plate) {
        if (appetite <= plate.getFood()) {
            satiety = true;
            plate.removeFood(appetite);
            System.out.printf("%s теперь сыт.\n", name);
        } else {
            System.out.printf("В тарелке для %s недостаточно еды.\n", name);
        }
    }
}