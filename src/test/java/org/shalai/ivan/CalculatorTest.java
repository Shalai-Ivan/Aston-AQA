package org.shalai.ivan;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    public static AndroidDriver driver;
    private CalculatorElements calculator = new CalculatorElements(driver);
    @BeforeAll
    public static void initialize() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "HONOR");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.calculator");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        try {
            driver = new AndroidDriver(new URL(" http://127.0.0.1:4723/"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    @AfterEach
    public void clear() {
        calculator.clear();
    }

    @Test
    @DisplayName("PLUS")
    @Description("The operation of adding two numbers")
    public void plus() {
        calculator.one().plus().nine().equal();
        double result = Double.parseDouble(calculator.getResultFinal());

        assertEquals(10, result, 0);
    }

    @Test
    @DisplayName("MINUS")
    @Description("The operation of subtracting two numbers")
    public void minus() {
        calculator.five().six().minus().one().six();
        String formula = calculator.getResultFormula();
        double result = Double.parseDouble(calculator.getResultPreview());

        assertEquals("56−16", formula);
        assertEquals(40, result, 0);
    }

    @Test
    @DisplayName("MULTIPLY")
    @Description("The operation of multiplying two numbers")
    public void multiply() {
        calculator.two().three().multiply().one().zero();
        String formula = calculator.getResultFormula();
        double result = Double.parseDouble(calculator.getResultPreview());

        assertEquals("23×10", formula);
        assertEquals(230, result, 0);
    }

    @Test
    @DisplayName("DIVIDE")
    @Description("The operation of dividing two numbers")
    public void divide() {
        calculator.eight().seven().divide().four();
        String formula = calculator.getResultFormula();
        double result = Double.parseDouble(calculator.getResultPreview());

        assertEquals("87÷4", formula);
        assertEquals(21.75, result, 2);
    }
}