package org.shalai.ivan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WildberriesSearchPage {
    private WebDriver driver;
    private By cartBy = By.className("icon-cart-thin");
    private By addToCartButtonListBy = By.xpath("//button[@data-tag='btnBasket']");
    private By minusButtonListBy = By.className("quantity__minus");
    private By plusButtonListBy = By.className("quantity__plus");
    private By cardNameListBy = By.xpath("//span[@class='b-card__name']");
    private By cardPriceListBy = By.xpath("//span[@data-tag='salePrice']");

    public WildberriesSearchPage(WebDriver driver) {
        this.driver = driver;

    }

    public void moveToCart() {
        driver.findElement(cartBy).click();
    }
    public String getProductName(int index) {
        List<WebElement> names = driver.findElements(cardNameListBy);
        return names.get(index).getText();
    }

     public String getProductPrice(int index) {
         List<WebElement> prices = driver.findElements(cardPriceListBy);
         return prices.get(index).getText();
     }

    public void addProductToCard(int index, int count) {
        List<WebElement> cartButtonsList = driver.findElements(addToCartButtonListBy);
        cartButtonsList.get(index).click();

        List<WebElement> plusButtonsList = driver.findElements(plusButtonListBy);
        while (count > 1) {
            plusButtonsList.get(index).click();
            count--;
        }
    }

    public void removeProductFromCard(int index, int count) {
        List<WebElement> minusButtonsList = driver.findElements(minusButtonListBy);
        while (count > 0) {
            minusButtonsList.get(index).click();
            count--;
        }
    }

    public Product addProductToCardWithInfoBack(int index, int count) {
        addProductToCard(index, count);
        String name = getProductName(index);
        String price = getProductPrice(index);
        return new Product(name, price, String.valueOf(count));
    }
}
