package oscar.tests.profilePageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import oscar.pages.*;
import oscar.pages.basketPages.BasketPage;
import oscar.pages.basketPages.PaymentPage;
import oscar.pages.basketPages.PreviewOrderPage;
import oscar.pages.basketPages.ShippingAddressPage;
import oscar.pages.homePages.HomePage;
import oscar.pages.profilePages.EmailHistoryPage;
import oscar.pages.profilePages.OrderConfirmationPage;
import oscar.pages.profilePages.ProfilePage;
import oscar.tests.TestBase;

public class EmailHistoryPageTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).clickOnLoginBtn();
        new RegisterPage(driver).fillRegisterForm("cyprusEmail7@gmail.com", "Draft123456!", "Draft123456!");
        new HomePage(driver).selectCategory();
        new HomePage(driver).clickOnAddToBasket();
        new BasketPage(driver).clickOnViewButton();


    }

    @Test
    public void emailWithConfirmationOfOrder() {
        new BasketPage(driver).clickOnCheckout();
        new ShippingAddressPage(driver).typeShippingAddress();
        new ShippingAddressPage(driver).clickContinue();
        new PaymentPage(driver).continueCheckout();
        new PreviewOrderPage(driver).placeOrder();
        String orderNumber = new OrderConfirmationPage(driver).getOrderNumber();

        new OrderConfirmationPage(driver).continueShopping();

        new HomePage(driver).accountInfo();
        new EmailHistoryPage(driver).goToEmailHistoryPage();
        String orderNumberFromEmail = new EmailHistoryPage(driver).getOrderNumberFromEmail();

        Assert.assertTrue(orderNumber.contains(orderNumberFromEmail));


    }

    @AfterMethod
    public void loginDelete() {
        new HomePage(driver).accountInfo();
        new ProfilePage(driver).clickOnDeleteAccount().deleteAccount("Draft123456!");
    }
}
