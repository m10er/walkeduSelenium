package pages;

import org.openqa.selenium.WebDriver;

public class PageManager {
    public LoginPage loginPage;
    public NavbarPage navbarPage;
    public EgitmenlerPage egitmenlerPage;

    public PageManager(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
        this.navbarPage= new NavbarPage(driver);
        this.egitmenlerPage = new EgitmenlerPage(driver);
    }
}
