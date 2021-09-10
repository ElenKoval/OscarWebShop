package oscar.tests.profilePageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import oscar.pages.*;
import oscar.pages.homePages.HomePage;
import oscar.pages.profilePages.ProfilePage;
import oscar.pages.profilePages.WishListPage;
import oscar.tests.TestBase;

public class WishListPageTest extends TestBase {

    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).clickOnLoginBtn();
        new RegisterPage(driver).fillRegisterForm("cyprus12@gmail.com", "Draft123456!", "Draft123456!");
        new HomePage(driver).accountInfo();
        new WishListPage(driver).goToWishList();
    }

    @Test
    public void createNewWishList() {
        new WishListPage(driver).wishListCreate("Need to buy");
        String wishListIsCreated = new WishListPage(driver).wishListCreated();
        Assert.assertTrue(wishListIsCreated.equalsIgnoreCase("Your wishlist has been created"));
    }

    @AfterMethod
    public void deleteProfile() {
        new HomePage(driver).accountInfo();
        new ProfilePage(driver).clickOnDeleteAccount().deleteAccount("Draft123456!");
    }
}
