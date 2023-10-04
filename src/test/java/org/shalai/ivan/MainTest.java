package org.shalai.ivan;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    @DisplayName("Найти факториал")
    void factorial() {
        Main main = new Main();
        int actual = main.factorial(5);
        int expected = 120;
        assertEquals(actual, expected);
    }
}