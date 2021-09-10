package oscar.pages.homePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import oscar.pages.PageBase;

public class HeaderPage extends PageBase {
    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "language")
    WebElement changeLanguage;

    @FindBy(css = "[value=\"ru\"]")
    WebElement chooseLanguge;

    @FindBy(xpath = "//button[@type='submit' and contains(.,'Go')]")
    WebElement go;

    @FindBy(xpath = "//button[@type='submit' and contains(.,'Выполнить')]")
    WebElement goOnRussian;

    public HeaderPage changeLanguageButton() {
        changeLanguage.click();
        return this;
    }

    public void languageChoosed() {
        chooseLanguge.click();
        go.click();
        new HeaderPage(driver);
    }


    public boolean languageIsChanged() {
        return goOnRussian.isDisplayed();
    }

    @FindBy(partialLinkText = "Oscar")
    WebElement goToHomePage;

    public HeaderPage goToHomePage() {
        goToHomePage.click();
        return new HeaderPage(driver);
    }

    @FindBy(xpath = "//div[contains(@class,'sub-header') and contains(.,'Welcome!')]")
    WebElement welcome;

    public boolean welcomeIsPresent() {
        return welcome.isDisplayed();
    }

    @FindBy(id = "logout_link")
    WebElement logout;

    @FindBy(className = "icon-signin")
    WebElement loginRegisterButton;

    @FindBy(xpath = "//*[contains(text(), 'View basket')]")
    WebElement viewBasketButton;

    public HeaderPage logoutButtonClick() {
        logout.click();
        return new HeaderPage(driver);
    }


    public HeaderPage viewBasketIsClickable() {
        viewBasketButton.click();
        return new HeaderPage(driver);
    }

    public boolean loginOrRegisterButtonIsClickable() {
        takeScreenshot();
        return loginRegisterButton.isDisplayed();
    }

    @FindBy(className = "icon-user")
    WebElement accountButton;

    @FindBy(linkText = "View basket")
    WebElement basket;

    @FindBy(xpath = "//strong[.='Basket total:']")
    WebElement basketTotal;

    @FindBy(className = "breadcrumb")
    WebElement basketPage;

    public String isThisBasketPage() {
        return basketPage.getText();
    }

    //present
    public boolean isBasketPresent() {
        return isElementExisting(basket);
    }

    public boolean isHomePageLinkPresent() {
        return isElementExisting(goToHomePage);
    }

    public boolean isLogoutPresent() {
        return isElementExisting(logout);
    }

    public boolean isAccountPresent() {
        return isElementExisting(accountButton);
    }

    public boolean isLanguageChangePresent() {
        return isElementExisting(changeLanguage);
    }

    public boolean isLoginOrRegisterPresent() {
        return isElementExisting(loginRegisterButton);
    }

    public boolean isGoButtonPresent() {
        return isElementExisting(go);
    }

    public boolean isBasketTotalPresent() {
        return isElementExisting(basketTotal);
    }

    //clickable
    public boolean isViewBasketClickable() {
        return waitUntilElementClickable(viewBasketButton, 4);
    }

    public boolean isLoginOrRegisterButtonClickable() {
        return waitUntilElementClickable(loginRegisterButton, 4);
    }

    public boolean isLanguageChangeClickable() {
        return waitUntilElementClickable(changeLanguage, 4);
    }

    public boolean isAccountButtonClickable() {
        return waitUntilElementClickable(accountButton, 4);
    }

    public boolean isHomePageButtonClickable() {
        return waitUntilElementClickable(goToHomePage, 4);
    }

    public boolean isLogoutButtonClickable() {
        return waitUntilElementClickable(logout, 4);
    }

    public boolean isGoButtonClickable() {
        return waitUntilElementClickable(go, 4);
    }


}
