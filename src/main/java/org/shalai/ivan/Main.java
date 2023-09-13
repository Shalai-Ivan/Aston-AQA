package org.shalai.ivan;

import java.io.*;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        AppData appData = new AppData();
        save(appData);
        read();
    }

    public static void save(AppData appData) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Lesson_6_File.csv"));
            for (String element : appData.getHeader()) {
                writer.write(element);
            }
            writer.write("\n");
            for (int[] arr : appData.getData()) {
                StringBuilder str = new StringBuilder();
                for (int element : arr) {
                    str.append(String.valueOf(element)).append("; ");
                }
                writer.write(String.valueOf(str.deleteCharAt(str.lastIndexOf(";"))));
                writer.write("\n");
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void read() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Lesson_6_File.csv"));
            String str;
            while ((str = reader.readLine()) != null) {
                System.out.println((str));
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}