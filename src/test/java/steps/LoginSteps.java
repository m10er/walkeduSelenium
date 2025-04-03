package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.LoginBody;
import org.junit.Assert;
import utilities.ValidTestData;
import utilities.faker.TestDataGenerator;
import utilities.faker.TestDataGeneratorFactory;

import java.util.Map;

public class LoginSteps extends BaseSteps{
    private LoginBody loginBody;
    @Given("kullanici login formu gecerli verilerle doldurur")
    public void kullaniciLoginFormuGecerliVerilerleDoldurur(DataTable dataTable) {
        Map<String, String> personalInfo = dataTable.asMap(String.class, String.class);
        LoginBody body = new LoginBody();
        body.setEmail(personalInfo.get("Email"));
        body.setPassword(personalInfo.get("Password"));
        pageManager.loginPage.fillPersonalInformation(body);
    }

    @When("Kullanici Login Sayfasinda Giris Yap butonuna tiklar.")
    public void kullaniciLoginSayfasindaGirisYapButonunaTiklar() {
        pageManager.loginPage.clickSubmitButton();
    }


    @Given("Kullanici Login Sayfasina gider.")
    public void kullaniciLoginSayfasinaGider() {
        pageManager.loginPage.navigateToPage();
    }

    @And("kullanici Login Formu icin gecerli email ve {string} girer")
    public void kullaniciLoginFormuIcinGecerliEmailVeGirer(String password) {
        loginBody = new LoginBody();
        loginBody.setEmail(ValidTestData.validMuammerEmail);
        loginBody.setPassword(password);
        pageManager.loginPage.fillPersonalInformation(loginBody);

    }

    @Then("Kullanici Gecersiz email veya password hatasini goruntuler.")
    public void kullaniciGecersizEmailVeyaPasswordHatasiniGoruntuler() {
        Assert.assertTrue(pageManager.loginPage.isDisplayed(pageManager.loginPage.birseylerTersGittiText));
    }

    @And("kullanici login formu gecerli email ve sifre ile doldurur")
    public void kullaniciLoginFormuGecerliEmailVeSifreIleDoldurur() {
        loginBody = new LoginBody();
        loginBody.setEmail(ValidTestData.validMuammerEmail);
        loginBody.setPassword(ValidTestData.validMuammerPassword);
        pageManager.loginPage.fillPersonalInformation(loginBody);

    }
}
