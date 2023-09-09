package org.shalai.ivan.Task_1;

public class Dog extends Animal {
    public static int dogsCount = 0;
    public Dog(String name) {
        this.name = name;
        dogsCount += 1;
    }

    public void run(int distance) {
        if (distance > 500 || distance <= 0) {
            System.out.printf("Извините, %s не может пробежать такую дистанцию\n", name);
        } else {
            System.out.printf("%s пробежал %s метров\n", name, distance);
        }
    }

    public void swim(int distance) {
        if (distance > 10 || distance <= 0) {
            System.out.printf("Извините, %s не может проплыть такую дистанцию\n", name);
        } else {
            System.out.printf("%s проплыл %s метров\n", name, distance);
        }
    }
}
