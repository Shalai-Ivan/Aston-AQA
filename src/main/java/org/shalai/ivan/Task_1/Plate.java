package org.shalai.ivan.Task_1;

public class Plate {
    private int food;
    public int getFood() {
        return food;
    }

    public Plate (int food) {
        this.food = food;
    }

    public void addFood (int foodCount) {
        food += foodCount;
        System.out.println("Добавлено " + foodCount + " еды в тарелку.");
    }

    public void removeFood (int foodCount) {
        if (food >= foodCount) {
            food -= foodCount;
            System.out.println("Убрано " + foodCount + " еды из тарелки.");
        } else {
            System.out.println("В тарелке нет столько еды.");
        }
    }
}
