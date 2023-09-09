package org.shalai.ivan.Task_1;

public class Animal {
    public static int animalsCount = 0;
    String name;

    public Animal () {
        animalsCount += 1;
    }

    public Animal (String name) {
        this.name = name;
        animalsCount += 1;
    }
    public void run (int distance) {
        System.out.printf("%s пробежал %s метров\n", name, distance);
    }

    public void swim (int distance) {
        System.out.printf("%s проплыл %s метров\n", name, distance);
    }
}
