package oscar.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import oscar.pages.homePages.HomePage;
import oscar.pages.LoginPage;

public class LoginPageTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).clickOnLoginBtn();
    }

    @Test
    public void loginNegativeTestWithoutData() {
        new LoginPage(driver).clickOnSubmit();
    }

    @Test
    public void loginPositiveTest() {
        new LoginPage(driver).fillLoginForm("cyprus@gmail.com", "Draft123456!");
        Assert.assertTrue(driver.getPageSource().contains("Welcome back"));
    }


}
