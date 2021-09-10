package oscar.tests.homePageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import oscar.pages.RegisterPage;
import oscar.pages.homePages.HeaderPage;
import oscar.pages.homePages.HomePage;
import oscar.pages.profilePages.AccountPage;
import oscar.pages.profilePages.ProfilePage;
import oscar.tests.TestBase;

public class HeaderPageTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).clickOnLoginBtn();
        new RegisterPage(driver).fillLoginForm("cyprus@gmail.com", "Draft123456!");
    }

    @Test
    public void headerElementsIsPresentForLoginUser() {
        Assert.assertTrue(new HeaderPage(driver).isAccountPresent());
        Assert.assertTrue(new HeaderPage(driver).isHomePageLinkPresent());
        Assert.assertTrue(new HeaderPage(driver).isLogoutPresent());
        Assert.assertTrue(new HeaderPage(driver).isLanguageChangePresent());
        Assert.assertTrue(new HeaderPage(driver).isBasketPresent());
        Assert.assertTrue(new HeaderPage(driver).isGoButtonPresent());
        Assert.assertTrue(new HeaderPage(driver).isBasketTotalPresent());
    }

    @Test
    public void headerElementsIsPresentForUnloginUser() {
        new HeaderPage(driver).logoutButtonClick();
        Assert.assertTrue(new HeaderPage(driver).isHomePageLinkPresent());
        Assert.assertTrue(new HeaderPage(driver).isLanguageChangePresent());
        Assert.assertTrue(new HeaderPage(driver).isBasketPresent());
        Assert.assertTrue(new HeaderPage(driver).isLoginOrRegisterPresent());
    }

    @Test
    public void isButtonsInHeaderClickable(){
        Assert.assertTrue(new HeaderPage(driver).isViewBasketClickable());
        Assert.assertTrue(new HeaderPage(driver).isAccountButtonClickable());
        Assert.assertTrue(new HeaderPage(driver).isGoButtonClickable());
        Assert.assertTrue(new HeaderPage(driver).isHomePageButtonClickable());
        Assert.assertTrue(new HeaderPage(driver).isLanguageChangeClickable());
        Assert.assertTrue(new HeaderPage(driver).isLogoutButtonClickable());
        new HeaderPage(driver).logoutButtonClick();
        Assert.assertTrue(new HeaderPage(driver).isLoginOrRegisterButtonClickable());
    }

    @Test
    public void changeLanguage() {
        new HeaderPage(driver).changeLanguageButton().languageChoosed();
        Assert.assertTrue(new HeaderPage(driver).languageIsChanged());
    }

    @Test
    public void accountRedirectToProfileForLoginUser() {
        new HomePage(driver).accountInfo();
        Assert.assertEquals("Profile", new ProfilePage(driver).profileIsHere());
    }

    @Test
    public void accountIsNotRedirectToProfileForUnloginUser() {
        new HeaderPage(driver).logoutButtonClick();
        Assert.assertFalse(new HeaderPage(driver).isAccountPresent());
    }

    @Test
    public void mainPageLinkRedirectToHomePage() {
        new HomePage(driver).accountInfo();
        new HeaderPage(driver).goToHomePage();
        Assert.assertTrue(new HeaderPage(driver).welcomeIsPresent());
    }

    @Test
    public void viewBasketLinkRedirectToBasket() {
        new HeaderPage(driver).viewBasketIsClickable();
        Assert.assertTrue(new HeaderPage(driver).isThisBasketPage().endsWith("Basket"));
    }


    @Test
    public void logoutButtonLogouted() {
        new HeaderPage(driver).logoutButtonClick();
        Assert.assertTrue(new HeaderPage(driver).loginOrRegisterButtonIsClickable());
    }





}
