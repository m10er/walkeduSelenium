package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Page Object Model for the Contact page.
 * Handles all interactions with the contact form and its elements.
 */
public class NavbarPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(NavbarPage.class);

    // Form field locators
    /** Locator for Hesabim button */
    public final By hesabimButton = By.xpath("(//button[@data-state=\"closed\"])[1]");


    /**
     * Constructor for NavbarPage.
     * @param driver WebDriver instance to be used
     */
    public NavbarPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Navigates to the contact page.
     * Waits for the page to load completely.
     */
    @Override
    public void navigateToPage() {
        waitForPageLoad();
    }

    /**
     * Check the Hesabim Button is displayed
     */
    public boolean isDiplayedHesabimButton() {
        waitForElementVisible(hesabimButton);
        return driver.findElement(hesabimButton).isDisplayed();
    }



}