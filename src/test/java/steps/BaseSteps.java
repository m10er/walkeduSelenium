package steps;

import org.openqa.selenium.WebDriver;
import pages.PageManager;

public class BaseSteps {

    protected final WebDriver driver;
    protected final PageManager pageManager;

    public BaseSteps() {
        this.driver = Hooks.driverManager.getDriver();
        this.pageManager = new PageManager(driver);
    }
}
