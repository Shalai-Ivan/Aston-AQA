package org.shalai.ivan;

public class Main {
    public static void main(String[] args) {
        String[][] arr1 = {{"-1", "+1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
        String[][] arr2 = {{"-1", "+1", "1", "1"}, {"A", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
        String[][] arr3 = {{"-1", "+1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
        try {
            System.out.println("Array with valid data:");
            method(arr1);

//            System.out.println("\nArray with symbols:");
//            method(arr2);

            System.out.println("\nArray with wrong size:");
            method(arr3);
        } catch (MyArraySizeException | MyArrayDataException s) {
            System.out.println(s.getMessage());
        }
    }

    public static void method(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException();
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j].matches("^[-+]?\\d+(\\d+)?$")) {
                    sum += Integer.parseInt(array[i][j]);
                } else {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println("Sum of all numbers - " + sum);
    }
}