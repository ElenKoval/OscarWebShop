package oscar.tests.productPageTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import oscar.pages.RegisterPage;
import oscar.pages.homePages.HeaderPage;
import oscar.pages.homePages.HomePage;
import oscar.pages.homePages.MenuPage;
import oscar.pages.productPage.ProductPage;
import oscar.tests.TestBase;

public class ProductPageTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).clickOnLoginBtn();
        new RegisterPage(driver).fillLoginForm("cyprus@gmail.com", "Draft123456!");
        new MenuPage(driver).goToAllCatalog();
    }

    @Test
    public void linksRedirectToCorrectPages() {
        Assert.assertTrue(new ProductPage(driver).goToClothingPage().endsWith("Clothing"));
        new HeaderPage(driver).goToHomePage();
        new MenuPage(driver).goToAllCatalog();

        Assert.assertTrue(new ProductPage(driver).goToBooksPage().endsWith("Books"));
        new HeaderPage(driver).goToHomePage();
        new MenuPage(driver).goToAllCatalog();

        Assert.assertTrue(new ProductPage(driver).goToFictionPage().endsWith("Fiction"));
        new HeaderPage(driver).goToHomePage();
        new MenuPage(driver).goToAllCatalog();

        Assert.assertTrue(new ProductPage(driver).goToComputersInLiteraturePage().endsWith("Computers in Literature"));
        new HeaderPage(driver).goToHomePage();
        new MenuPage(driver).goToAllCatalog();

        Assert.assertTrue(new ProductPage(driver).goToNonFictionPage().endsWith("Non-Fiction"));
        new HeaderPage(driver).goToHomePage();
        new MenuPage(driver).goToAllCatalog();

        Assert.assertTrue(new ProductPage(driver).goToEssentialProgrammingPage().endsWith("Essential programming"));
        new HeaderPage(driver).goToHomePage();
        new MenuPage(driver).goToAllCatalog();


        Assert.assertTrue(new ProductPage(driver).goToHackingPage().endsWith("Hacking"));
        new HeaderPage(driver).goToHomePage();
        new MenuPage(driver).goToAllCatalog();
    }

    @Test
    public void addToBasketFromAllProductTest() {
        new ProductPage(driver).addToBasket();
        Assert.assertTrue(new ProductPage(driver).getTextNotificationAddInBasket().contains("has been added to your basket."));
    }

    @Test
    public void addToBasketFromItemPageTest() {
        new ProductPage(driver).addToBasketFromAItemPage();
        Assert.assertTrue(new ProductPage(driver).getTextNotificationAddInBasketFromItemPage().contains("has been added to your basket."));
    }

    @Test
    public void verifyPagination() {
        int currentPageFirst = new ProductPage(driver).currentPage();
        new ProductPage(driver).nextPage();
        int currentPageNext = new ProductPage(driver).currentPage();
        Assert.assertEquals(currentPageFirst + 1, currentPageNext);

        new ProductPage(driver).nextPage();
        int currentPageBeforePreviousClick = new ProductPage(driver).currentPage();
        new ProductPage(driver).previousPage();
        int currentPageAfterPreviousClick = new ProductPage(driver).currentPage();
        Assert.assertEquals(currentPageBeforePreviousClick - 1, currentPageAfterPreviousClick);

    }

    @Test
    public void verifyPaginationNegativeTest() {
        new ProductPage(driver).nextPage();
        driver.get(new ProductPage(driver).goToLastPage());
        Assert.assertFalse(new ProductPage(driver).nextButtonIsDisplayed());
    }

    @Test
    public void redirectToHomePageFromItemPageViaHomeButton() {
        new ProductPage(driver).goToItemPage();
        new ProductPage(driver).goToHomePageViaHomeButton();
        Assert.assertTrue(new HeaderPage(driver).welcomeIsPresent());
    }

    @Test
    public void redirectToHomePageFromItemPageViaLogo() {
        new ProductPage(driver).goToItemPage();
        new ProductPage(driver).goToHomePageViaLogo();
        Assert.assertTrue(new HeaderPage(driver).welcomeIsPresent());
    }

    @Test
    public void verifyCorrectName() {
        new ProductPage(driver).goToBooksPage();
        String bookTitleInCatalogue = new ProductPage(driver).booksTitleInCatalogue();
        new ProductPage(driver).goToItemPage();
        String bookTitleOnItemPageOnBar = new ProductPage(driver).booksTitleOnItemPageOnNavigationBar();
        String bookTitleMain = new ProductPage(driver).booksTitleMain();
        Assert.assertEquals(bookTitleInCatalogue, bookTitleMain);
        Assert.assertTrue(bookTitleOnItemPageOnBar.endsWith(bookTitleInCatalogue));

    }

}
