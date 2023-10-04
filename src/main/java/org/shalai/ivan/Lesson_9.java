package org.shalai.ivan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lesson_9 {
    static List<String> list = Stream.of("Highload", "High", "Load", "Highload").collect(Collectors.toList());

    public static void main(String[] args) {
        System.out.println("TASK 1:");
        System.out.println("Result: " + task1() + " numbers");

        System.out.println("\nTASK 2:");
        System.out.println("2.1: \"High\" occurs in list - " + task2_1() + " times");
        System.out.println("2.2: The first element in list - " + task2_2());
        System.out.println("2.3: The last element in list - " + task2_3());

        System.out.println("\nTASK 3:");
        System.out.println(Arrays.toString(task3()));

        System.out.println("\nTASK 4:");
        System.out.println("4.1: Average students age - " + task4_1());
        System.out.println("4.2: List of students eligible for military service: " + task4_2());

        System.out.println("\nTASK 5:");
        System.out.println("List of logins: " + task5());
    }

    // TASK 1
    static long task1() {
        Random random = new Random();
        int[] numbers = IntStream.generate(() -> random.nextInt(100))
                .limit(random.nextInt(10))
                .toArray();
        System.out.println(Arrays.toString(numbers));
        IntStream intStream = IntStream.of(numbers);
        return intStream.filter(x -> x % 2 == 0).count();
    }

    // TASK 2
    static long task2_1() {
        return list.stream().filter("High"::equals).count();
    }

    static String task2_2() {
        return list.stream().findFirst().orElse("0");
    }

    static String task2_3() {
        return list.stream().reduce(((first, second) -> second)).orElse("0");
    }

// TASK 3
    static String[] task3() {
        List<String> stringList = Arrays.asList("f10", "f15", "f2", "f4", "f4");
        stringList = stringList.stream()
                        .sorted(Comparator
                        .comparing(String::length)
                        .thenComparing(String::compareTo))
                        .collect(Collectors.toList());
        return stringList.toArray(new String[list.size()]);
    }

// TASK 4
    static int task4_1() {
        StudentsGroup group = new StudentsGroup();
        return (int) group.students.stream()
                .filter((x) -> x.getSex() == StudentsGroup.Gender.MAN)
                .mapToDouble(StudentsGroup.Student::getAge)
                .average()
                .getAsDouble();
    }

    static List<String> task4_2() {
        StudentsGroup group = new StudentsGroup();
        return group.students.stream()
                .filter((x) ->
                        x.getAge() >= 18 &&
                        x.getAge() <= 27 &&
                        x.getSex() == StudentsGroup.Gender.MAN)
                .map(StudentsGroup.Student::getName)
                .collect(Collectors.toList());
    }

// TASK 5
    static List<String> task5() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        try {
            while (true) {
                String str = reader.readLine();
                if (str.isEmpty()) break;
                list.add(str);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list.stream().filter((x) -> x.charAt(0) == 'f').collect(Collectors.toList());
    }
}