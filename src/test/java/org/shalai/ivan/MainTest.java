package org.shalai.ivan;

import static org.testng.Assert.*;

public class MainTest {

    @org.testng.annotations.Test
    public void testFactorial() {
        Main main = new Main();
        int actual = main.factorial(5);
        int expected = 120;
        assertEquals(actual, expected);
    }
}