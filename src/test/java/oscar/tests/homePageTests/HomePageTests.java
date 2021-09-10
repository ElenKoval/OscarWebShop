package oscar.tests.homePageTests;

import oscar.pages.homePages.HomePage;
import oscar.pages.productPage.ProductPage;
import org.testng.annotations.Test;
import org.testng.Assert;
import oscar.tests.TestBase;


public class HomePageTests extends TestBase {

//    HomePage homePage;
//    ProductPage productPage;
//
//    @BeforeMethod
//    public void pageInit() {
//        homePage = PageFactory.initElements(driver, HomePage.class);
//        productPage = PageFactory.initElements(driver, ProductPage.class);
//    }

    @Test
    public void userCanSelectProductMenuTest() {
        new HomePage(driver).selectCategory();
        Assert.assertTrue(new ProductPage(driver).isItProductPage());
    }
}
