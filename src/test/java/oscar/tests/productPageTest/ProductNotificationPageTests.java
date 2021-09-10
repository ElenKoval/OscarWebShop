package oscar.tests.productPageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import oscar.pages.*;
import oscar.pages.homePages.HomePage;
import oscar.pages.productPage.ProductPage;
import oscar.pages.profilePages.ProfilePage;
import oscar.tests.TestBase;

public class ProductNotificationPageTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).clickOnLoginBtn();
        new RegisterPage(driver).fillRegisterForm("cyprusEmailForNot@gmail.com", "Draft123456!", "Draft123456!");
        new HomePage(driver).selectCategory();
    }

    @Test
    public void makeNotification() {
        new ProductPage(driver).findUnavailableItem();
        new ProductPage(driver).viewInfoUnavailableItem();
        new ProductPage(driver).addNotification();
        Assert.assertTrue(new ProductPage(driver).alertIsCreated());
    }

    @AfterMethod
    public void loginDelete() {
        new HomePage(driver).accountInfo();
        new ProfilePage(driver).clickOnDeleteAccount().deleteAccount("Draft123456!");
    }

}
