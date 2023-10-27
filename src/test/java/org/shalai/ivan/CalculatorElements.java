package org.shalai.ivan;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CalculatorElements {
    private static AndroidDriver driver;
    private By resultFinalBy = By.id("com.google.android.calculator:id/result_final");
    private By resultFormulaBy = By.id("com.google.android.calculator:id/formula");
    private By resultPreviewBy = By.id("com.google.android.calculator:id/result_preview");
    private By zeroBy = By.id("com.google.android.calculator:id/digit_0");;
    private By oneBy = By.id("com.google.android.calculator:id/digit_1");;
    private By twoBy = By.id("com.google.android.calculator:id/digit_2");;
    private By threeBy = By.id("com.google.android.calculator:id/digit_3");;
    private By fourBy = By.id("com.google.android.calculator:id/digit_4");;
    private By fiveBy = By.id("com.google.android.calculator:id/digit_5");;
    private By sixBy = By.id("com.google.android.calculator:id/digit_6");;
    private By sevenBy = By.id("com.google.android.calculator:id/digit_7");;
    private By eightBy = By.id("com.google.android.calculator:id/digit_8");;
    private By nineBy = By.id("com.google.android.calculator:id/digit_9");;
    private By divideBy = By.id("com.google.android.calculator:id/op_div");;
    private By multiplyBy = By.id("com.google.android.calculator:id/op_mul");;
    private By minusBy = By.id("com.google.android.calculator:id/op_sub");;
    private By plusBy = By.id("com.google.android.calculator:id/op_add");;
    private By equalBy = By.id("com.google.android.calculator:id/eq");;
    private By clearBy = By.id("com.google.android.calculator:id/clr");;

    public CalculatorElements(AndroidDriver driver) {
        CalculatorElements.driver = driver;
    }

    public String getResultFinal() {
        return driver.findElement(resultFinalBy).getAttribute("text").replace(",", ".");
    }
    public String getResultFormula() {
        return driver.findElement(resultFormulaBy).getAttribute("text").replace(",", ".");
    }
    public String getResultPreview() {
        return driver.findElement(resultPreviewBy).getAttribute("text").replace(",", ".");
    }
    public CalculatorElements zero() {
        driver.findElement(zeroBy).click();
        return this;
    }
    public CalculatorElements one() {
        driver.findElement(oneBy).click();
        return this;
    }
    public CalculatorElements two() {
        driver.findElement(twoBy).click();
        return this;
    }
    public CalculatorElements three() {
        driver.findElement(threeBy).click();
        return this;
    }
    public CalculatorElements four() {
        driver.findElement(fourBy).click();
        return this;
    }
    public CalculatorElements five() {
        driver.findElement(fiveBy).click();
        return this;
    }
    public CalculatorElements six() {
        driver.findElement(sixBy).click();
        return this;
    }
    public CalculatorElements seven() {
        driver.findElement(sevenBy).click();
        return this;
    }
    public CalculatorElements eight() {
        driver.findElement(eightBy).click();
        return this;
    }
    public CalculatorElements nine() {
        driver.findElement(nineBy).click();
        return this;
    }
    public CalculatorElements divide() {
        driver.findElement(divideBy).click();
        return this;
    }
    public CalculatorElements multiply() {
        driver.findElement(multiplyBy).click();
        return this;
    }
    public CalculatorElements minus() {
        driver.findElement(minusBy).click();
        return this;
    }
    public CalculatorElements plus() {
        driver.findElement(plusBy).click();
        return this;
    }
    public CalculatorElements equal() {
        driver.findElement(equalBy).click();
        return this;
    }
    public CalculatorElements clear() {
        driver.findElement(clearBy).click();
        return this;
    }
}
