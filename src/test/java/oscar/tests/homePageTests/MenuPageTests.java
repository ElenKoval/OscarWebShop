package oscar.tests.homePageTests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import oscar.pages.RegisterPage;
import oscar.pages.homePages.HeaderPage;
import oscar.pages.homePages.HomePage;
import oscar.pages.homePages.MenuPage;
import oscar.tests.TestBase;

import java.util.List;

public class MenuPageTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).clickOnLoginBtn();
        new RegisterPage(driver).fillLoginForm("cyprus@gmail.com", "Draft123456!");
    }

    @Test
    public void menuElementsArePresent() {
        Assert.assertTrue(new MenuPage(driver).isSideMenuPresent());
        Assert.assertTrue(new MenuPage(driver).isAllProductsInSideMenuPresent());
        Assert.assertTrue(new MenuPage(driver).isClothingInSideMenuPresent());
        Assert.assertTrue(new MenuPage(driver).isBooksInSideMenuPresent());
        Assert.assertTrue(new MenuPage(driver).isOffersInSideMenuPresent());
        Assert.assertTrue(new MenuPage(driver).isSearchFieldPresent());
        Assert.assertTrue(new MenuPage(driver).isSearchFSubmitButtonPresent());
    }

    @Test
    public void menuElementsAreClickable() {
        Assert.assertFalse(new MenuPage(driver).isSideMenuClickable());
        Assert.assertTrue(new MenuPage(driver).isAllProductsInSideMenuClickable());
        Assert.assertTrue(new MenuPage(driver).isClothingInSideMenuClickable());
        Assert.assertTrue(new MenuPage(driver).isBooksInSideMenuClickable());
        Assert.assertTrue(new MenuPage(driver).isOffersInSideMenuClickable());
        Assert.assertTrue(new MenuPage(driver).isSearchButtonClickable());
        Assert.assertTrue(new MenuPage(driver).isSearchFieldClickable());
    }

    @Test
    public void menuElementsRedirectToCorrectPages() {
        Assert.assertEquals(new MenuPage(driver).isAllProductsInSideMenuRedirectToAllProductPage(), "All products");
        new HeaderPage(driver).goToHomePage();
        Assert.assertTrue(new MenuPage(driver).isClothingInSideMenuRedirectToClothingPage().endsWith("Clothing"));
        new HeaderPage(driver).goToHomePage();
        Assert.assertTrue(new MenuPage(driver).isBooksInSideMenuRedirectToBooksPage().endsWith("Books"));
        new HeaderPage(driver).goToHomePage();
        Assert.assertTrue(new MenuPage(driver).isOffersInSideMenuRedirectToBooksPage().endsWith("Offers"));

    }

    @Test
    public void searchTestNegative() {
        new MenuPage(driver).fillSearchField("");
        Assert.assertEquals(new MenuPage(driver).numberOfFoundItems(), "0");
    }

    @Test
    public void searchTestPositive() {
        new MenuPage(driver).fillSearchField("Java");
        Assert.assertEquals(new MenuPage(driver).findText("Java"),"Java");

    }


}






