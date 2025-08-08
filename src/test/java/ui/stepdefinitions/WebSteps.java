package ui.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import ui.pages.*;
import ui.utilities.DriverFactory;

import static org.junit.Assert.*;

public class WebSteps {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);
    CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);
    CheckoutCompletePage completePage = new CheckoutCompletePage(driver);

    // -------------------- Existing Steps --------------------

    @Given("I open the SauceDemo login page")
    public void openLoginPage() {
        loginPage.open();
    }

    @When("I login with username {string} and password {string}")
    public void login(String username, String password) {
        loginPage.login(username, password);
    }

    @When("I add the first item to the cart")
    public void addFirstItem() {
        inventoryPage.addFirstItemToCart();
    }

    @When("I go to the cart page")
    public void goToCart() {
        inventoryPage.goToCart();
    }

    @When("I proceed to checkout")
    public void proceedToCheckout() {
        cartPage.clickCheckout();
    }

    @When("I enter checkout information with first name {string}, last name {string}, and postal code {string}")
    public void enterCheckoutInfo(String firstName, String lastName, String postalCode) {
        checkoutInfoPage.fillInfo(firstName, lastName, postalCode);
    }

    @When("I finish the checkout")
    public void finishCheckout() {
        overviewPage.clickFinish();
    }

    @Then("I should see the confirmation message {string}")
    public void confirmMessage(String expectedMessage) {
        String actualMessage = completePage.getConfirmationMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    // -------------------- New Steps for Invalid Login Scenario --------------------

    @Then("I should see an error message displayed")
    public void errorMessageShouldBeVisible() {
        assertTrue("Expected error message to be displayed", loginPage.isErrorMessageDisplayed());
    }

    @Then("I should see the error message {string}")
    public void verifyErrorMessageText(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessageText();
        assertEquals(expectedMessage, actualMessage);
    }

    // -------------------- New Steps for Empty Credential Scenario --------------------

    @When("the user logs in with empty username and password")
    public void loginWithEmptyCredentials() {
        loginPage.login("", "");
    }

    // -------------------- New Steps for Cart Badge Update --------------------

    @Then("the cart badge should show {string}")
    public void verifyCartBadge(String expectedCount) {
        String actualCount = inventoryPage.getCartBadgeCount();
        assertEquals(expectedCount, actualCount);
    }

    // -------------------- New Steps for Cart Badge Update --------------------

    @When("I log out from the side menu")
    public void logoutFromMenu() {
        inventoryPage.logout();
    }

    @Then("I should be redirected to the login page")
    public void redirectedToLogin() {
        assertTrue("Expected to be back on login page", loginPage.isLoginPageVisible());
    }

    // -------------------- Cleanup --------------------

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
