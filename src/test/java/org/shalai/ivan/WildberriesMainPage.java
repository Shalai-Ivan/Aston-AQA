package org.shalai.ivan;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;

public class WildberriesMainPage {
    private WebDriver driver;
    private By searchFieldBy = By.className("search-component-input");
    private By cookiesDecline = By.className("modal-body__deny");
    private By cookiesConfirm = By.className("modal-body__confirm");

    public WildberriesMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchInField(String request) {
        driver.findElement(searchFieldBy).sendKeys(request, Keys.chord(Keys.ENTER));
    }

    public void declineCookies() {
        driver.findElement(cookiesDecline).click();
    }

    public void setCookiesAccept() {
        driver.findElement(cookiesConfirm).click();
    }
}
