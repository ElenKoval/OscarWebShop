package oscar.tests.profilePageTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import oscar.pages.*;
import oscar.pages.basketPages.BasketPage;
import oscar.pages.basketPages.PaymentPage;
import oscar.pages.basketPages.PreviewOrderPage;
import oscar.pages.basketPages.ShippingAddressPage;
import oscar.pages.homePages.HomePage;
import oscar.pages.profilePages.AccountPage;
import oscar.pages.profilePages.OrderConfirmationPage;
import oscar.tests.TestBase;

public class OrderConfirmationPageTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).clickOnLoginBtn();
        new RegisterPage(driver).fillLoginForm("cyprus@gmail.com", "Draft123456!");
        new HomePage(driver).selectCategory();
        new HomePage(driver).clickOnAddToBasket();
        new BasketPage(driver).clickOnViewButton();
    }


    @Test
    public void orderNumberConfirmation() {
        new BasketPage(driver).clickOnCheckout();
        new ShippingAddressPage(driver).typeShippingAddress().clickContinue();
        new PaymentPage(driver).continueCheckout();
        new PreviewOrderPage(driver).placeOrder();
        String expected = new OrderConfirmationPage(driver).getOrderNumber();

        new OrderConfirmationPage(driver).continueShopping();
        new HomePage(driver).accountInfo();
        new AccountPage(driver).viewOrderHistory();
        String actual = new AccountPage(driver).getOrderNumberHistory();
        Assert.assertTrue(expected.contains(actual));

        logger.info(String.valueOf(expected.contains(actual)));
    }

}

