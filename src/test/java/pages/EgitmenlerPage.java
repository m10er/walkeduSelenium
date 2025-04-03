package pages;

import org.openqa.selenium.WebDriver;
import utilities.URLs;

public class EgitmenlerPage extends BasePage{

    /**
     * Constructor for BasePage.
     * Initializes WebDriver, WebDriverWait, and JavaScriptExecutorHelper.
     *
     * @param driver WebDriver instance to be used
     */
    public EgitmenlerPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void navigateToPage() {
        driver.get(URLs.EGITMENLER_URL.getUrl());
    }
}
