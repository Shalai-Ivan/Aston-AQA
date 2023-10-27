package org.shalai.ivan;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
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

    @DisplayName("PLUS")
    @Test
    public void plus() {
        calculator.clear().one().plus().nine().equal();
        double result = Double.parseDouble(calculator.getResultFinal());

        assertEquals(10, result, 0);
    }

    @DisplayName("MINUS")
    @Test
    public void minus() {
        calculator.clear().five().six().minus().one().six();
        String formula = calculator.getResultFormula();
        double result = Double.parseDouble(calculator.getResultPreview());

        assertEquals("56−16", formula);
        assertEquals(40, result, 0);
    }

    @DisplayName("MULTIPLY")
    @Test
    public void multiply() {
        calculator.clear().two().three().multiply().one().zero();
        String formula = calculator.getResultFormula();
        double result = Double.parseDouble(calculator.getResultPreview());

        assertEquals("23×10", formula);
        assertEquals(230, result, 0);
    }

    @DisplayName("DIVIDE")
    @Test
    public void divide() {
        calculator.clear().eight().seven().divide().four();
        String formula = calculator.getResultFormula();
        double result = Double.parseDouble(calculator.getResultPreview());

        assertEquals("87÷4", formula);
        assertEquals(21.75, result, 2);
    }
}