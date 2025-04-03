package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.actions.IElementActions;
import pages.actions.IPageActions;
import pages.actions.JavaScriptExecutorHelper;
import utilities.TimeoutConstants;

/**
 * Base class for all page objects in the application.
 * Provides common functionality and utilities for page interactions.
 * Implements both IPageActions and IElementActions interfaces.
 */
public abstract class BasePage implements IPageActions, IElementActions {
    /** Logger instance for this class */
    protected static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    
    /** WebDriver instance for browser interactions */
    protected final WebDriver driver;
    
    /** WebDriverWait instance for explicit waits */
    protected final WebDriverWait wait;
    
    /** Helper class for JavaScript operations */
    private final JavaScriptExecutorHelper jsHelper;
    
    /** Locator for cookie acceptance button */
    private final By acceptCookiesButton = By.id("cn-notice-buttons");

    /**
     * Constructor for BasePage.
     * Initializes WebDriver, WebDriverWait, and JavaScriptExecutorHelper.
     * @param driver WebDriver instance to be used
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TimeoutConstants.EXPLICIT_WAIT_MEDIUM);
        this.jsHelper = new JavaScriptExecutorHelper(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Abstract method to be implemented by child classes.
     * Defines the navigation logic for the specific page.
     */
    protected abstract void navigateToPage();

    /**
     * Handles cookie acceptance on the page.
     * Clicks the cookie acceptance button using JavaScript.
     */
    @Override
    public void acceptCookies() {
        try {
            clickWithJS(acceptCookiesButton);
            logger.info("Cookie accept button clicked successfully");
        } catch (Exception e) {
            logger.error("Failed to click cookie accept button", e);
            throw e;
        }
    }

    /**
     * Scrolls to an element containing specific text within a given tag.
     * @param tagName HTML tag name to search within
     * @param text Text content to find
     * @return WebElement containing the specified text
     */
    public WebElement scrollToElementByText(String tagName, String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script =
                "var elements = [...document.querySelectorAll(arguments[0])];" +
                        "var el = elements.find(e => e.innerText.includes(arguments[1]));" +
                        "if (el) { el.scrollIntoView({behavior: 'smooth', block: 'center'}); }" +
                        "return el;";

        return (WebElement) js.executeScript(script, tagName, text);
    }

    /**
     * Finds an element containing specific text within a given tag.
     * @param tagName HTML tag name to search within
     * @param text Text content to find
     * @return WebElement containing the specified text
     */
    public WebElement findElementByText(String tagName, String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return [...document.querySelectorAll(arguments[0])].find(el => el.innerText.includes(arguments[1]));";
        return (WebElement) js.executeScript(script, tagName, text);
    }

    /**
     * Sets the value of a dropdown element using JavaScript.
     * @param dropdown WebElement representing the dropdown
     * @param value Value to be selected
     */
    protected void selectDropdownByValue(WebElement dropdown, String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "arguments[0].value='" + value + "';";
        js.executeScript(script, dropdown);
    }

    /**
     * Waits for the page to load completely.
     * Checks document.readyState until it equals "complete".
     */
    public void waitForPageLoad() {
        try {
            wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete"));
            logger.debug("Page load completed successfully");
        } catch (Exception e) {
            logger.error("Page failed to load within timeout period", e);
            throw e;
        }
    }

    /**
     * Waits for an element to become visible on the page.
     * @param locator By locator for the element
     * @return Visible WebElement
     */
    public WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Sends text to an element after waiting for its presence.
     * @param locator By locator for the element
     * @param text Text to be sent
     */
    @Override
    public void sendKeys(By locator, String text) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            WebElement element = driver.findElement(locator);
            element.clear();
            element.sendKeys(text);
            logger.debug("Successfully sent text '{}' to element: {}", text, locator);
        } catch (Exception e) {
            logger.error("Failed to send text '{}' to element: {}", text, locator, e);
            throw e;
        }
    }

    /**
     * Clicks an element using JavaScript.
     * @param locator By locator for the element
     */
    @Override
    public void clickWithJS(By locator) {
        WebElement element = driver.findElement(locator);
        jsHelper.executeClick(element);
    }

    /**
     * Clicks a WebElement using JavaScript.
     * @param element WebElement to be clicked
     */
    @Override
    public void clickWithJS(WebElement element) {
        jsHelper.executeClick(element);
    }

    /**
     * Scrolls an element into view.
     * @param locator By locator for the element
     */
    public void scrollIntoView(By locator) {
        WebElement element = waitForElementVisible(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Sends text to an element using JavaScript.
     * @param element WebElement to receive the text
     * @param value Text to be sent
     */
    @Override
    public void sendKeysWithJS(WebElement element, String value) {
        jsHelper.sendKeys(element, value);
    }

    public boolean isDisplayed(By by){
        WebElement element= driver.findElement(by);
        boolean result= false;
        try {
            waitForPageLoad();
            if (element.isDisplayed()){
                result=true;
            }
        }catch (Exception e){
            System.out.println(e);
            logger.error("elemnet is not displayed");
        }
        return result;
    }
}