package oscar.pages.profilePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import oscar.pages.PageBase;

public class AddressBookPage extends PageBase {
    public AddressBookPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[contains(.,'Address Book')]")
    WebElement addressBook;

    public AddressBookPage goToAddressBookPage() {
        addressBook.click();
        return new AddressBookPage(driver);
    }

    @FindBy(xpath = "//*[contains(text(), 'Edit')]")
    WebElement editAddressButton;

    @FindBy(name = "first_name")
    WebElement firstName;

    @FindBy(xpath = "//*[contains(text(), 'Save')]")
    WebElement saveButton;

    public AddressBookPage editAddress(String str) {
        editAddressButton.click();
        firstName.clear();
        firstName.sendKeys(str);
        saveButton.click();
        return new AddressBookPage(driver);
    }

    @FindBy(xpath = "//*[@class='table table-striped table-bordered']/tbody/tr[2]/td[1]")
    WebElement nameInAddressBook;

    public String nameInBook() {
        String name = nameInAddressBook.getText();
        return name;
    }

    @FindBy(xpath = "//*[contains(text(), 'Address book')]")
    WebElement editAddress;

    public boolean isEditAddressFieldsAreDisplayed() {
        return editAddress.isDisplayed();
    }
}
