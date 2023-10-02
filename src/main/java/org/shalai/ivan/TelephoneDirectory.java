package org.shalai.ivan;

import java.util.*;

public class TelephoneDirectory {
    private Map<Integer, String> phonebook = new HashMap<>();

    public void add(int number, String surname) {
        phonebook.put(number, surname);
    }

    public void get(String surname){
        if(phonebook.containsValue(surname)) {
            for (Map.Entry<Integer, String> element : phonebook.entrySet()) {
                if(element.getValue().equals(surname)) {
                    System.out.println(element.getValue() + " : " + element.getKey());
                }
            }
        } else {
            System.out.println("There is no such surname as " + surname + " in the phonebook.");
        }
    }
}
