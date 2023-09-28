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
        telDir.add("Ivanov", 1234567);
        telDir.add("Petrov", 1111111);
        telDir.add("Ivanov", 7654321);
        System.out.println("Numbers for Ivanov surname: " + telDir.get("Ivanov"));
        System.out.println("Numbers for Petrov surname: " + telDir.get("Petrov"));
    }
}