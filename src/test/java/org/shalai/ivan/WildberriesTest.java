package org.shalai.ivan;

import static org.junit.Assert.*;

import org.apache.commons.math3.util.Precision;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WildberriesTest {
    private static WebDriver driver;
    private static List<Product> productsAddedToCart = new ArrayList<>();
    private static List<Product> productsFromCart = new ArrayList<>();

    private Double toCalculateTotalSum() {
        double result = 0.0;
        for (Product element : productsAddedToCart) {
            result += element.getPrice() * element.getQuantity();
        }
        return Precision.round(result, 2);
    }

    private void sortProducts() {
        productsAddedToCart.sort(Comparator.comparing(Product::getName));
        productsFromCart.sort(Comparator.comparing(Product::getName));
    }

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.wildberries.by/");
    }

    @DisplayName("Поиск товара через строку поиска")
    @Test
    public void aTest() {
        WildberriesMainPage mainPage = new WildberriesMainPage(driver);
        mainPage.declineCookies();
        mainPage.searchInField("Шампунь");
    }

    @DisplayName("Добавить товар в корзину, перейти в корзину")
    @Test
    public void bTest() {
        WildberriesSearchPage searchPage = new WildberriesSearchPage(driver);
        productsAddedToCart.add(searchPage.addProductToCardWithInfoBack(5, 7));
        productsAddedToCart.add(searchPage.addProductToCardWithInfoBack(7, 4));
        productsAddedToCart.add(searchPage.addProductToCardWithInfoBack(10, 2));
        searchPage.moveToCart();
    }

    @DisplayName("Получить товары из корзины и сравнить общую сумму")
    @Test
    public void cTest() {
        WildberriesCartPage cartPage = new WildberriesCartPage(driver);
        productsFromCart = cartPage.getAllProducts();
        Double totalSum = Product.convertNumber(cartPage.getTotalSum().replace(",", "."));
        assertEquals(toCalculateTotalSum(), totalSum);
    }

    @DisplayName("Сравнить названия товаров")
    @Test
    public void dTest() {
        sortProducts();
        for (int i = 0; i < productsAddedToCart.size(); i++) {
            Product added = productsAddedToCart.get(i);
            Product from = productsFromCart.get(i);
            assertEquals(added.getName(), from.getName());
        }
    }

    @DisplayName("Сравнить цены товаров")
    @Test
    public void eTest() {
        for (int i = 0; i < productsAddedToCart.size(); i++) {
            Product added = productsAddedToCart.get(i);
            Product from = productsFromCart.get(i);
            assertEquals((added.getPrice() * added.getQuantity()), from.getPrice(), 2);
        }
    }

    @DisplayName("Сравнить количества товаров")
    @Test
    public void dfest() {
        for (int i = 0; i < productsAddedToCart.size(); i++) {
            Product added = productsAddedToCart.get(i);
            Product from = productsFromCart.get(i);
            assertEquals(added.getQuantity(), from.getQuantity());
        }
    }
}