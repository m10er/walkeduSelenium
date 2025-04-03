package pages;

import model.LoginBody;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.URLs;

/**
 * Page Object Model for the Contact page.
 * Handles all interactions with the contact form and its elements.
 */
public class LoginPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    // Form field locators
    /** Locator for first name input field */
    private final By email = By.id("email");

    /** Locator for last name input field */
    private final By password = By.id("password");


    // Action button locators
    /** Locator for submit button */
    private final By submitButton = By.cssSelector("button[type='submit']");

    // BirSeyler Ters Gitti Text
    //** locator for birseyler ters gitti text */
    public final By birseylerTersGittiText =By.xpath("//*[contains(text(),'Birşeyler ters gitti')]");

    /**
     * Constructor for LoginPage.
     * @param driver WebDriver instance to be used
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Navigates to the contact page.
     * Waits for the page to load completely.
     */
    @Override
    public void navigateToPage() {
        driver.get(URLs.LOGIN_URL.getUrl());
        waitForPageLoad();
        logger.info("Kullanici login sayfasina ulasir.");
    }

    /**
     * Fills the contact form with provided information.
     * Uses JavaScript to ensure reliable input.
     * @param body ContactBody object containing form data
     */
    public void fillPersonalInformation(LoginBody body) {
        logger.info("Filling contact form with provided information");
        try {
            sendKeys(email, body.getEmail());
            sendKeys(password, body.getPassword());

            logger.debug("Contact form filled successfully");
        } catch (Exception e) {
            logger.error("Failed to fill contact form", e);
            throw e;
        }
    }

    /**
     * Clicks the submit button using JavaScript.
     */
    public void clickSubmitButton() {
        logger.info("Clicking submit button");
        clickWithJS(submitButton);
        waitForPageLoad();
    }

    /**
     * Check the Bir seyler Ters gitti Text is displayed.
     */
    public boolean isDisplayedBirseylerTersGitti(){
        waitForPageLoad();
        return driver.findElement(birseylerTersGittiText).isDisplayed();
    }


}