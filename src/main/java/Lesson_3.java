// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Lesson_3 {
    public static void main(String[] args) {
        isInSumRange(10, 5);
        positiveNegative(0);
        isNegative(1);
        repeat("Hello", 5);
        isLeapYear(2004);
        reverse();
        oneToHundred();
        lessThanSix();
        diagonal();
        createArray(5, 10);
    }

// Task 1
    public static boolean isInSumRange (int a, int b) {
        for (int i = 10; i <= 20; i++) {
            if ((a + b) == i) {
                return true;
            }
        }
        return false;
    }

// Task 2
    public static void positiveNegative (int a) {
        if (a >=0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

// Task 3
    public static boolean isNegative (int a) {
        return a < 0;
    }

// Task 4
    public static void repeat (String line, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(line);
        }
    }

// Task 5
    public static boolean isLeapYear (int year) {
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
    public static void reverse () {
        int[] array = {1, 1, 0, 1, 0, 0, 1, 0, 0, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
    }

// Task 7
    public static void oneToHundred () {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

// Task 8
    public static void lessThanSix () {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }

// Task 9
    public static void diagonal () {
        int[][] array = new int[11][11];
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            array[i][array.length - i - 1] = 1;
        }
    }

// Task 10
    public static int[] createArray (int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}