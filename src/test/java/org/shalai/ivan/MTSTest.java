package org.shalai.ivan;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.*;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MTSTest {
    private static WebDriver driver;

    private String findNumber(String str) {
        Pattern pattern = Pattern.compile("[+-]?[0-9]+(.[0-9]+)?");
        Matcher matcher = pattern.matcher(str);
        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            result.append(matcher.group());
        }
        return result.toString();
    }
    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mts.by");
    }

// TASK 1
    @Test
    public void aTest() {
        WebElement cookie = driver.findElement(By.xpath("//button[@class='cookie__close']"));
        if (cookie.isDisplayed()) cookie.click();

        WebElement dropArrow = driver.findElement(By.cssSelector("span.select__arrow"));
        List<WebElement> payList = driver.findElements(By.cssSelector("ul.select__list > li"));
        List<WebElement> phList = driver.findElements(By.xpath("//form[@id='pay-connection']//.//input[@placeholder]"));

        for (WebElement element : payList) {
            dropArrow.click();
            element.click();
            for (WebElement field : phList) {
                assertNotSame(null, field.getAttribute("textContent"));
            }
        }
        dropArrow.click();
        payList.get(0).click();
    }

// TASK 2
    @DisplayName("Переход в другой фрейм и проверка суммы в заголовке")
    @Test
    public void bTest() {
        driver.findElement(By.xpath("//input[@id='connection-phone']")).sendKeys("297777777");
        driver.findElement(By.xpath("//input[@id='connection-sum']")).sendKeys("10");

        driver.findElement(By.cssSelector("#pay-connection button")).click();

        WebElement frame = driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']"));
        driver.switchTo().frame(frame);

        WebElement header = driver.findElement(By.xpath("//p[@class='header__payment-amount']"));
        assertEquals("10.00", findNumber(header.getAttribute("textContent")));
    }

    @DisplayName("Проверка суммы на кнопке")
    @Test
    public void cTest() {
        WebElement button = driver.findElement(By.xpath("//button[@class='colored disabled ng-star-inserted']"));
        assertEquals("10.00", findNumber(button.getAttribute("textContent")));
    }

    @DisplayName("Проверка номера телефона")
    @Test
    public void dTest() {
        WebElement infoHeader = driver.findElement(By.xpath("//p[@class='header__payment-info']"));
        assertEquals("375297777777", findNumber(infoHeader.getAttribute("textContent")));
    }

    @DisplayName("Проверка надписей незаполненных полей")
    @Test
    public void eTest() {
        WebElement cardNumber = driver.findElement(By.xpath("//label[@class='ng-tns-c46-1 ng-star-inserted']"));
        assertEquals("Номер карты", cardNumber.getAttribute("textContent"));

        WebElement validity = driver.findElement(By.xpath("//label[@class='ng-tns-c46-4 ng-star-inserted']"));
        assertEquals("Срок действия", validity.getAttribute("textContent"));

        WebElement cvc = driver.findElement(By.xpath("//label[@class='ng-tns-c46-5 ng-star-inserted']"));
        assertEquals("CVC", cvc.getAttribute("textContent"));

        WebElement holderName = driver.findElement(By.xpath("//label[@class='ng-tns-c46-3 ng-star-inserted']"));
        assertEquals("Имя держателя (как на карте)", holderName.getAttribute("textContent"));
    }

    @DisplayName("Проверка иконок платежных систем")
    @Test
    public void fTest() {
        List<WebElement> payIcons = driver.findElements(By.xpath("//div[@class='cards-brands ng-tns-c46-1']//.//img"));
        payIcons.forEach((x) -> assertTrue(x.isEnabled()));
    }
}