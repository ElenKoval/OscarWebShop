package oscar.pages.homePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import oscar.pages.PageBase;
import oscar.pages.productPage.ProductPage;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".dropdown-submenu")
    WebElement submenuBook;

    public ProductPage selectCategory() {
        submenuBook.click();
        return new ProductPage(driver);
    }

    @FindBy(id = "login_link")
    WebElement loginLink;


    public HomePage clickOnLoginBtn() {
        loginLink.click();
        return this;
    }

    @FindBy(xpath = "//ol//li[1]//*[contains(text(), 'Add to basket')]")
    WebElement addToBasket;

    public HomePage clickOnAddToBasket() {
        addToBasket.click();
        return this;
    }

    @FindBy(className = "icon-user")
    WebElement accountButton;

    public HomePage accountInfo() {
        accountButton.click();
        return this;
    }

    public Boolean accountInfoNotPresent() {
        return !isElementExisting(accountButton);
    }

    @FindBy(xpath = "//*[contains(text(), 'Thanks for registering!')]")
    WebElement registerConfirm;

    public String registerInfo() {
        String confirm = registerConfirm.getText();
        return confirm;
    }


}

