package org.shalai.ivan;

public class Main {
    public static void main(String[] args) {
    }

    public int factorial(int number) {
        if (number < 0) return -1;
        int result = 1;
        for (int i = 0; i < number; i++) {
            result = result * (number - i);
        }
        return result;
    }
}