package org.shalai.ivan;

import java.util.*;

public class TelephoneDirectory {
    private HashMap<String, ArrayList<Integer>> directory = new HashMap<>();

    public void add(String surname, Integer number) {
        if (!directory.containsKey(surname)) {
            directory.put(surname, new ArrayList<>(number));
        }
        directory.get(surname).add(number);
    }

    public ArrayList<Integer> get(String surname) {
        return directory.get(surname);
    }
}
