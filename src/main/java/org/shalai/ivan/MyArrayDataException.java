package org.shalai.ivan;

public class MyArrayDataException extends Exception {
    MyArrayDataException(int i, int j) {
        super("MyArrayDataException Exception: Conversion failed in array " + i + " and cell " + j);
    }
}
