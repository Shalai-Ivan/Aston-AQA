package org.shalai.ivan;

import java.util.*;

public class Main {
    public static void main(String[] args) {
    // TASK 1
        System.out.println("TASK 1:");

        String[] array = {"one", "two", "two", "three", "four", "five", "one"};
        Set<String> set = new LinkedHashSet<String>(Arrays.asList(array));
        System.out.print("List of unique names: ");
        for (String str : set) {
            System.out.print(str + " ");
        }

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (String element : array) {
            if (!map.containsKey(element)) {
                map.put(element, 1);
            } else {
                map.put(element, map.get(element) + 1);
            }
        }

        System.out.print("\nCount of every word: ");
        for (Map.Entry element : map.entrySet()) {
            System.out.print(element + " ");
        }

    // TASK 2
        System.out.println("\n\nTASK 2:");

        TelephoneDirectory telDir = new TelephoneDirectory();
        telDir.add(1234567, "Ivanov");
        telDir.add(1111111, "Petrov");
        telDir.add(7654321, "Ivanov");
        telDir.get("Ivanov");
        telDir.get("Petrov");
        telDir.get("Sobolev");
    }
}