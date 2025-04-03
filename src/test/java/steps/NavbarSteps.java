package steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;

public class NavbarSteps extends BaseSteps{
    @Then("Kullanici Profilini goruntuleyebilecegi Hesabim butonunu Navbarda goruntuler.")
    public void kullaniciProfiliniGoruntuleyebilecegiHesabimButonunuNavbardaGoruntuler() {
        Assert.assertTrue(pageManager.navbarPage.isDiplayedHesabimButton());
    }
}
