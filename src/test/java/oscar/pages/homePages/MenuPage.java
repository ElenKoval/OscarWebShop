package oscar.pages.homePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import oscar.pages.PageBase;
import oscar.pages.productPage.ProductPage;

import java.util.List;

public class MenuPage extends PageBase {
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "dropdown-menu")
    WebElement sideMenu;

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li[contains(.,'All products')]")
    WebElement allProducts;

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li[contains(.,'Clothing')]")
    WebElement clothing;

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li[contains(.,'Books')]")
    WebElement books;

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li[contains(.,'Offers')]")
    WebElement offers;

    @FindBy(xpath = "//*[@class='form-control' and contains(@type, 'search')]")
    WebElement searchField;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement searchSubmit;


    public boolean isSearchFieldPresent() {
        return isElementExisting(searchField);
    }

    public boolean isSearchFSubmitButtonPresent() {
        return isElementExisting(searchSubmit);
    }

    public boolean isSideMenuPresent() {
        return isElementExisting(sideMenu);
    }

    public boolean isAllProductsInSideMenuPresent() {
        return isElementExisting(allProducts);
    }

    public boolean isClothingInSideMenuPresent() {
        return isElementExisting(clothing);
    }

    public boolean isBooksInSideMenuPresent() {
        return isElementExisting(books);
    }

    public boolean isOffersInSideMenuPresent() {
        return isElementExisting(offers);
    }

//clickable

    public boolean isSideMenuClickable() {
        return waitUntilElementClickable(sideMenu, 5);
    }

    public boolean isAllProductsInSideMenuClickable() {
        return waitUntilElementClickable(allProducts, 5);
    }

    public boolean isClothingInSideMenuClickable() {
        return waitUntilElementClickable(clothing, 5);
    }

    public boolean isBooksInSideMenuClickable() {
        return waitUntilElementClickable(books, 5);
    }

    public boolean isOffersInSideMenuClickable() {
        return waitUntilElementClickable(offers, 5);
    }

    public boolean isSearchFieldClickable() {
        return waitUntilElementClickable(searchField, 5);
    }

    public boolean isSearchButtonClickable() {
        return waitUntilElementClickable(searchSubmit, 5);
    }

    //redirect

    @FindBy(xpath = "//div[@class='page-header action']")
    WebElement allProductPage;

    @FindBy(className = "breadcrumb")
    WebElement needsPage;



    public String isAllProductsInSideMenuRedirectToAllProductPage() {
        allProducts.click();
        return allProductPage.getText();
    }

    public String isClothingInSideMenuRedirectToClothingPage() {
        clothing.click();
        return needsPage.getText();
    }

    public String isBooksInSideMenuRedirectToBooksPage() {
        books.click();
        return needsPage.getText();
    }

    public String isOffersInSideMenuRedirectToBooksPage() {
        offers.click();
        return needsPage.getText();
    }

    public void fillSearchField(String text) {
        searchField.click();
        searchField.sendKeys(text);
        searchSubmit.click();
    }

    @FindBy(className = "form-horizontal")
    WebElement foundItems;

    public String numberOfFoundItems() {
        String text = foundItems.getText();
        String[] splitText = text.split(" ");
        return splitText[1];
    }


    @FindBy(xpath = "//article[@class='product_page' and contains(., 'Java')]")
    WebElement textContains;

    @FindAll({@FindBy(xpath = "//div[@class='image_container' and contains(@href, *)]")})
    List<WebElement> findedBooks;


    public String findText(String text) {
        String textOnPage="";
        for (int i = 0; i < findedBooks.size(); i++) {
            List<WebElement> findedBooks = driver.findElements(By.xpath("//div[@class='image_container' and contains(@href, *)]"));
            if(findedBooks.get(i).isDisplayed()) {
                findedBooks.get(i).click();
                if (new ProductPage(driver).productDescriptionContainsText(text)) {
                    driver.navigate().back();
                    textOnPage = "Java";
                } else {
                    textOnPage = "not found";
                }
            }
        }
        return textOnPage;
    }

    public MenuPage goToAllCatalog(){
        allProducts.click();
        return new MenuPage(driver);
    }
}