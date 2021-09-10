package oscar.pages.profilePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import oscar.pages.homePages.HomePage;
import oscar.pages.PageBase;

public class ProfilePage extends PageBase {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class,'page-header action')]/h1")
    WebElement profileInfoIsDisplayed;

    public String profileIsHere() {
        return profileInfoIsDisplayed.getText();
    }

    @FindBy(id = "delete_profile")
    WebElement deleteAccountBtn;

    public ProfilePage clickOnDeleteAccount() {
        deleteAccountBtn.click();
        return this;
    }

    @FindBy(id = "id_password")
    WebElement deletePwdField;

    @FindBy(css = ".btn.btn-lg.btn-danger")
    WebElement deleteBtn;

    public HomePage deleteAccount(String text) {
        type(deletePwdField, text);
        deleteBtn.click();
        return new HomePage(driver);
    }

    @FindBy(xpath = "//*[.='Edit profile']")
    WebElement editBtn;

    public ProfilePage clickOnEditBtn() {
        editBtn.click();
        return this;
    }

    @FindBy(id = "id_first_name")
    WebElement firstNameField;

    public ProfilePage editFirstNameField(String fName) {
        type(firstNameField, fName);
        return this;
    }

    @FindBy(name = "email")
    WebElement emailField;

    public ProfilePage clearEmailField() {
        emailField.clear();
        return this;
    }

    @FindBy(css = ".btn.btn-lg.btn-primary")
    WebElement submitBtn;

    public ProfilePage clickOnSubmit() {
        submitBtn.click();
        return this;
    }


    @FindBy(css = "tr:nth-child(1) > td")
    WebElement firstNameCell;

    public boolean isFirstNameContainsText(String text) {
        return firstNameCell.getText().contains(text);
    }

    @FindBy(xpath = "//i[contains(@class,'icon-exclamation-sign')]")
    WebElement alertUsernameErrors;

    public boolean isAlertPresent() {
        return alertUsernameErrors.isDisplayed();
    }
}
