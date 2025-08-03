package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutInfoPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");

    public CheckoutInfoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // increased wait
    }

    public void fillInfo(String firstName, String lastName, String postalCode) {
        // Wait for form inputs to be visible
        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput));
        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInput));
        WebElement postalField = wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeInput));
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueButton));

        // Fill in the fields
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postalField.sendKeys(postalCode);
        continueBtn.click();
    }
}
