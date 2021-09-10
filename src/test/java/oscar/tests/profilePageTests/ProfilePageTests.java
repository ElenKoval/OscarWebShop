package oscar.tests.profilePageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import oscar.pages.homePages.HomePage;
import oscar.pages.profilePages.ProfilePage;
import oscar.pages.RegisterPage;
import oscar.tests.TestBase;

public class ProfilePageTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).clickOnLoginBtn();
        new RegisterPage(driver).fillRegisterForm("cyprus33@gmail.com",  "Book12345!","Book12345!");
        new HomePage(driver).accountInfo();

    }

    @Test
    public void editProfilePositiveTest() {
        new ProfilePage(driver).clickOnEditBtn().editFirstNameField("Emy").clickOnSubmit();
        Assert.assertTrue(new ProfilePage(driver).isFirstNameContainsText("Emy"));
        new HomePage(driver).accountInfo();
        new ProfilePage(driver).clickOnDeleteAccount().deleteAccount("Book12345!");
    }

    @Test
    public void editProfileNegativeTest() {
        new ProfilePage(driver).clickOnEditBtn().clearEmailField().clickOnSubmit();
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Edit Profile"));
        new HomePage(driver).accountInfo();
        new ProfilePage(driver).clickOnDeleteAccount().deleteAccount("Book12345!");
    }

    @Test
    public void deleteProfile() {
        new HomePage(driver).accountInfo();
        new ProfilePage(driver).clickOnDeleteAccount().deleteAccount("Book12345!");
        new HomePage(driver).clickOnLoginBtn();
        new RegisterPage(driver).fillLoginForm("cyprus123@gmail.com", "Book12345!");
        Assert.assertTrue(new ProfilePage(driver).isAlertPresent());
    }

}
