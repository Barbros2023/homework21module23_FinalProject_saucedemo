package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private final By cartContainer = By.className("cart_list");
    private final By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // increased wait
    }

    public void clickCheckout() {
        // Wait until cart page has loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartContainer));

        // Wait until checkout button is clickable
        WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkout.click();
    }
}
