package org.shalai.ivan;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MTSTest {
    private static WebDriver driver;
    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mts.by");
    }

//TASK 1
    @Test
    public void aTest() {
        WebElement label = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение')]"));
        assertTrue(label.isDisplayed());
    }

//TASK 2
    @Test
    public void bTest() {
        List<WebElement> logos = driver.findElements(By.xpath("//div[@class='pay__partners']//.//img"));
        assertEquals(6, logos.size());
        logos.forEach((x) -> assertTrue(x.isDisplayed()));
    }

//TASK 3
    @Test
    public void cTest() {
        driver.findElement(By.linkText("Подробнее о сервисе")).click();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
        driver.navigate().back();
    }

//TASK 4
    @Test
    public void dTest() {
        WebElement cookie = driver.findElement(By.xpath("//button[@class='cookie__close']"));
        if (cookie.isDisplayed()) cookie.click();
        driver.findElement(By.xpath("//input[@id='connection-phone']")).sendKeys("297777777");
        driver.findElement(By.xpath("//input[@id='connection-sum']")).sendKeys("10");
        driver.findElement(By.cssSelector("#pay-connection button")).click();
        WebElement frame = driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']"));
        driver.switchTo().frame(frame);
        WebElement container = driver.findElement(By.xpath("//div[@class='app-wrapper__content']"));
        assertTrue(container.isEnabled());
    }
}