package org.shalai.ivan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WildberriesCartPage {
    private WebDriver driver;
    private By cartListBy = By.className("basket-list");
    private By cartTotalSumBy = By.xpath("//span[@data-tag='totalSum']");
    private By productsNameBy = By.xpath("//span[@data-tag='itemName']");
    private By productsQuantityBy = By.className("quantity__input");
    private By productsPriceBy = By.className("b-item-price__lower");

    public WildberriesCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCartListCount() {
        return driver.findElement(cartListBy).getAttribute("childElementCount");
    }

    public String getTotalSum() {
        return driver.findElement(cartTotalSumBy).getText();
    }

    public String getProductName(int index) {
        return driver.findElements(productsNameBy).get(index).getText();
    }

    public String getProductQuantity(int index) {
        return driver.findElements(productsQuantityBy).get(index).getAttribute("value");
    }

    public String getProductPrice(int index) {
        return driver.findElements(productsPriceBy).get(index).getText();
    }

    public List<Product> getAllProducts() {
        int productsCount = Integer.parseInt(getCartListCount());
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < productsCount; i++) {
            String name = getProductName(i);
            String quantity = getProductQuantity(i);
            String price = getProductPrice(i);
            products.add(new Product(name, price, quantity));
        }
        return products;
    }
}
