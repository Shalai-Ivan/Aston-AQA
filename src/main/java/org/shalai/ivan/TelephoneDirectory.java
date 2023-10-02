package org.shalai.ivan;

import java.util.*;

public class TelephoneDirectory {
    private Map<Integer, String> phonebook = new HashMap<>();

    public void add(int number, String surname) {
        phonebook.put(number, surname);
    }

    public void get(String surname){
        ArrayList<Integer> list = new ArrayList<>();
        if(phonebook.containsValue(surname)) {
            for (Map.Entry<Integer, String> element : phonebook.entrySet()) {
                if(element.getValue().equals(surname)) {
                    list.add(element.getKey());
                }
            }
            System.out.print("\n" + surname + " : ");
            list.forEach((n) -> System.out.print(n + " "));
        } else {
            System.out.println("\nThere is no such surname as " + surname + " in the phonebook.");
        }
    }
}
