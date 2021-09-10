package oscar.pages.productPage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import oscar.pages.PageBase;

public class ProductPage extends PageBase {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".page-header.action")
    WebElement pageHeader;

    @FindBy(xpath = "//button[@type='submit' and contains(.,'Notify me')]")
    WebElement notification;


    @FindBy(xpath = "//*[contains(@class, 'product_pod') and contains(.,'Unavailable')]/div[@class='image_container']")
    WebElement unavailableItem;

    @FindBy(xpath = "//a[contains(.,'next')]")
    WebElement nextPage;

    public boolean isItProductPage() {
        return pageHeader.isDisplayed();
    }

    public void findUnavailableItem() {
        while (!isElementExisting(unavailableItem)) {
            nextPage.click();
            if (isElementExisting(unavailableItem))
                break;
        }
    }

    public ProductPage viewInfoUnavailableItem() {
        unavailableItem.click();
        return this;
    }


    public ProductPage addNotification() {
        notification.click();
        return new ProductPage(driver);
    }

    @FindBy(xpath = "//*[contains(@class,'alertinner wicon')]")
    WebElement alertText;

    public boolean alertIsCreated() {
        return alertText.isDisplayed();
    }


    @FindBy(xpath = "//article[@class='product_page' and contains(., 'Java')]")
    WebElement textContains;

    public boolean productDescriptionContainsText(String text) {
        return (textContains.getText().contains(text));
    }

    @FindBy(linkText = "Clothing")
    WebElement buttonToClothingPage;

    @FindBy(className = "breadcrumb")
    WebElement clothingPage;

    public String goToClothingPage() {
        buttonToClothingPage.click();
        return clothingPage.getText();
    }

    @FindBy(linkText = "Books")
    WebElement buttonToBooksPage;

    @FindBy(className = "breadcrumb")
    WebElement booksPage;

    public String goToBooksPage() {
        buttonToBooksPage.click();
        return booksPage.getText();
    }

    @FindBy(linkText = "Fiction")
    WebElement buttonToFictionPage;

    @FindBy(className = "breadcrumb")
    WebElement fictionPage;

    public String goToFictionPage() {
        buttonToFictionPage.click();
        return fictionPage.getText();
    }


    @FindBy(linkText = "Computers in Literature")
    WebElement buttonToComputersInLiteraturePage;

    @FindBy(className = "breadcrumb")
    WebElement computersInLiteraturePage;

    public String goToComputersInLiteraturePage() {
        buttonToComputersInLiteraturePage.click();
        return computersInLiteraturePage.getText();
    }

    @FindBy(linkText = "Non-Fiction")
    WebElement buttonToNonFictionPage;

    @FindBy(className = "breadcrumb")
    WebElement nonFictionPage;

    public String goToNonFictionPage() {
        buttonToNonFictionPage.click();
        return nonFictionPage.getText();
    }

    @FindBy(linkText = "Essential programming")
    WebElement buttonToEssentialProgrammingPage;

    @FindBy(className = "breadcrumb")
    WebElement essentialProgrammingPage;

    public String goToEssentialProgrammingPage() {
        buttonToEssentialProgrammingPage.click();
        return essentialProgrammingPage.getText();
    }

    @FindBy(linkText = "Hacking")
    WebElement buttonToHackingPage;

    @FindBy(className = "breadcrumb")
    WebElement hackingPage;

    public String goToHackingPage() {
        buttonToHackingPage.click();
        return hackingPage.getText();
    }

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    WebElement addToBasketFromAllProductsPage;

    @FindBy(xpath = "(//div[@class='alertinner '])[1] ")
    WebElement addItemNotification;

    public void addToBasket() {
        addToBasketFromAllProductsPage.click();
    }

    public String getTextNotificationAddInBasket() {
        return addItemNotification.getText();
    }

    @FindBy(xpath = "(//div[@class='image_container'])[2]")
    WebElement goToItemPageThroughImage;

    @FindBy(xpath = "(//button[contains(text(), 'Add to basket')])[1]")
    WebElement addToBasketFromAItemPage;

    public ProductPage addToBasketFromAItemPage() {
        goToItemPageThroughImage.click();
        addToBasketFromAItemPage.click();
        return new ProductPage(driver);
    }

    @FindBy(xpath = "(//div[@class='alertinner '])[1] ")
    WebElement addItemNotificationOnItemPage;

    public String getTextNotificationAddInBasketFromItemPage() {
        return addItemNotificationOnItemPage.getText();
    }

    @FindBy(linkText = "next")
    WebElement pageNext;

    @FindBy(linkText = "previous")
    WebElement pagePrevious;

    @FindBy(className = "current")
    WebElement currentPage;

    public ProductPage nextPage() {
        pageNext.click();
        return new ProductPage(driver);
    }

    public int currentPage() {
        String[] currentPageNumber = currentPage.getText().split(" ");
        int currentPageNum = Integer.parseInt(currentPageNumber[1]);
        return currentPageNum;
    }

    public ProductPage previousPage() {
        pagePrevious.click();
        return new ProductPage(driver);
    }


    public boolean nextButtonIsDisplayed() {
        return isElementExisting(pageNext);
    }


    public String goToLastPage() {
        String[] pageNumbers = currentPage.getText().split(" ");
        int lastPageNum = Integer.parseInt(pageNumbers[pageNumbers.length - 1]);
        String oldUrl = driver.getCurrentUrl();
        return oldUrl.substring(0, oldUrl.length() - 1) + lastPageNum;
    }

    public ProductPage goToItemPage() {
        goToItemPageThroughImage.click();
        return new ProductPage(driver);
    }

    @FindBy(linkText = "Home")
    WebElement goToHomePageButton;

    public ProductPage goToHomePageViaHomeButton() {
        goToHomePageButton.click();
        return new ProductPage(driver);
    }

    @FindBy(linkText = "Oscar")
    WebElement goToHomePageButtonLogo;

    public ProductPage goToHomePageViaLogo() {
        goToHomePageButtonLogo.click();
        return new ProductPage(driver);
    }


    @FindBy(xpath = "(//h3/a[@href])[1]")
    WebElement booksTitleInCatalogue;

    @FindBy(className = "breadcrumb")
    WebElement needsPage;

    public String booksTitleInCatalogue() {
        return booksTitleInCatalogue.getAttribute("title");
    }

    public String booksTitleOnItemPageOnNavigationBar() {
        return needsPage.getText();
    }

    @FindBy(xpath = "//h1")
    WebElement mainTitle;

    public String booksTitleMain() {
        return mainTitle.getText();
    }


}

