package org.shalai.ivan;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Task_1 {
    private static WebDriver driver;

    private WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection button"));
    private WebElement dropArrow = driver.findElement(By.cssSelector("span.select__arrow"));
    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mts.by");
    }

//    @AfterClass
//    public static void testShutDown() {
//        driver.quit();
//    }
// TASK 1
    private boolean checkField(WebElement element) {
        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection button"));
        return true;
    }

    @Test
    public void check() {
        WebElement cookie = driver.findElement(By.xpath("//button[@class='cookie__close']"));
        if (cookie.isDisplayed()) cookie.click();
        continueButton.click();
        dropArrow.click();
        List<WebElement> list = driver.findElements(By.cssSelector("ul.select__list > li"));
        System.out.println(list.size());
    }
}