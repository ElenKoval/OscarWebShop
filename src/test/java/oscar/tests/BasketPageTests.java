package oscar.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import oscar.pages.*;
import oscar.pages.basketPages.BasketPage;
import oscar.pages.basketPages.ShippingAddressPage;
import oscar.pages.homePages.HomePage;

public class BasketPageTests extends TestBase {


    @BeforeMethod
    public void precondition() {
        new HomePage(driver).clickOnLoginBtn();
        new RegisterPage(driver).fillLoginForm("cyprus@gmail.com", "Draft123456!");
        new HomePage(driver).selectCategory();
        new HomePage(driver).clickOnAddToBasket();
        new BasketPage(driver).clickOnViewButton();

    }

    @Test
    public void verifyMandatoryFieldsNegative() {
        new BasketPage(driver).clickOnCheckout();
        new ShippingAddressPage(driver).leaveEmptyMandatoryFieldInShippingAddress();
        Assert.assertFalse(driver.getPageSource().contains("Enter payment details"));

    }

    @Test
    public void verifyMandatoryFieldsPositive() {
        new BasketPage(driver).clickOnCheckout();
        new ShippingAddressPage(driver).typeShippingAddress().clickContinue();
        Assert.assertTrue(driver.getPageSource().contains("Enter payment details"));
    }


}
