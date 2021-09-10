package oscar.tests;

import oscar.pages.homePages.HomePage;
import oscar.pages.RegisterPage;
import oscar.pages.profilePages.ProfilePage;
import oscar.util.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPageTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).clickOnLoginBtn();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "registerNegativeEmailUsingFile", priority = 2)
    public void newUserRegistrationNegativeTest(String email) {
        new RegisterPage(driver).fillRegisterForm(email, "Draft1234!", "Draft1234!");
        Assert.assertTrue(new RegisterPage(driver).isRegisterFormDisplayed());
    }


    @Test(priority = 1, groups = {"functional"})
    public void newUserRegistrationPositiveTest() {
        new RegisterPage(driver).fillRegisterForm("cyprus111@gmail.com", "Draft123456!", "Draft123456!");
        String confirmRegistration = new HomePage(driver).registerInfo();
        Assert.assertTrue(confirmRegistration.contains("Thanks for registering!"));
        new HomePage(driver).accountInfo();
        new ProfilePage(driver).clickOnDeleteAccount().deleteAccount("Draft123456!");

    }
}
