package steps;

import driver.DriverFactory;
import driver.DriverManager;
import driver.DriverType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Hooks {
    public static DriverManager driverManager;
    public static WebDriver driver;

    @Before
    public void setup() {
        driverManager = DriverFactory.getManager(DriverType.FIREFOX);
        driver = driverManager.getDriver();
    }

    @After
    public void tearDown() {
        if (driverManager != null) {
            takeScreenshot();
            driverManager.quitDriver();
        }
    }
    private void takeScreenshot() {
        try {
            // Cast WebDriver instance to TakesScreenshot
            TakesScreenshot ts = (TakesScreenshot) driver;

            // Get the screenshot file
            File source = ts.getScreenshotAs(OutputType.FILE);

            // Define the destination file path
            Path destination = Path.of("path/to/save/screenshots/screenshot_" + System.currentTimeMillis() + ".png");

            // Use Files.copy() to copy the screenshot
            Files.copy(source.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Screenshot saved to: " + destination);

        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
} 