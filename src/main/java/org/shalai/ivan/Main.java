package org.shalai.ivan;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
    }

// Task 1
    public boolean isInSumRange (int a, int b) {
        for (int i = 10; i <= 20; i++) {
            if ((a + b) == i) {
                return true;
            }
        }
        return false;
    }

// Task 2
    public void positiveNegative (int a) {
        if (a >=0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

// Task 3
    public boolean isNegative (int a) {
        return a < 0;
    }

// Task 4
    public void repeat (String line, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(line);
        }
    }

// Task 5
    public boolean isLeapYear (int year) {
        if (year < 0) return false;

        if ((year % 400) == 0) {
            return true;
        } else if ((year % 4) == 0) {
            return (year % 100) != 0;
        } else {
            return false;
        }
    }

// Task 6
    int[] array = {1, 1, 0, 1, 0, 0, 1, 0, 0, 1};
    for (int i = 0; i < array.length; i++) {
        if (array[i] == 0) {
            array[i] = 1;
        } else {
            array[i] = 0;
        }
    }

// Task 7
    int[] array2 = new int[100];
    for (int i = 0; i < array2.length; i++) {
        array2[i] = i + 1;
    }

// Task 8
    int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    for (int i = 0 ; i < array3.length; i++) {
        if (array3[i] < 6) {
            array3[i] *= 2;
        }
    }

// Task 9
    int[][] array4 = new int[11][11];
    for (int i = 0; i < array4.length; i++) {
        array4[i][i] = 1;
        array4[i][array4.length - i - 1] = 1;
    }

// Task 10
    public int[] createArray (int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}