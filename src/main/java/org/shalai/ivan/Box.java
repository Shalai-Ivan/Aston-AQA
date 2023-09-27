package org.shalai.ivan;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    private T obj;
    public T getObj() {
        return obj;
    }

    private ArrayList<T> list = new ArrayList<T>();
    public ArrayList<T> getList() {
        return list;
    }

    public Box (T obj) {
        this.obj = obj;
    }

    public void addFruit(int count) {
        for (int i = 0; i < count; i++) {
            list.add(getObj());
        }
    }

    public float getWeight() {
        if (getObj() instanceof Apple) {
            return 1.0f * list.size();
        } else {
            return 1.5f * list.size();
        }
    }

    public boolean compare(Box<?> box) {
        return getWeight() == box.getWeight();
    }

    public void toSprinkleFruits(Box<T> box) {
        box.addFruit(getList().size());
        list.clear();
    }
}
