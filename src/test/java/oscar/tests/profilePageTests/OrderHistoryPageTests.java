package oscar.tests.profilePageTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import oscar.pages.homePages.HomePage;
import oscar.pages.profilePages.OrderHistoryPage;
import oscar.pages.basketPages.OrderPage;
import oscar.pages.RegisterPage;
import oscar.tests.TestBase;

public class OrderHistoryPageTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).clickOnLoginBtn();
        new RegisterPage(driver).fillLoginForm("cyprus@gmail.com", "Draft123456!");
        new HomePage(driver).accountInfo();
    }

    @Test
    public void viewOrderHistoryWithEmptyDataNegative() {
        new OrderHistoryPage(driver).goToOrderHistoryPage().filterResultClick();
        Assert.assertTrue(new OrderHistoryPage(driver).alertEmptyField().contains("Oops! We found some errors - please check the error messages below and try again"));
    }

    @Test
    public void viewOrderHistoryByOrdersNumberPositive() {
        new OrderHistoryPage(driver).goToOrderHistoryPage().filterByOrdersNumber();
        String orderNumberInAllOrders = new OrderHistoryPage(driver).getOrderNumberInAllOrders();
        new OrderHistoryPage(driver).filterResultClick();
        String orderNumberText = new OrderPage(driver).getOrderNumber();
        Assert.assertTrue(orderNumberText.contains(orderNumberInAllOrders));
    }
}
