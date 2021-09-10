package oscar.pages.profilePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import oscar.pages.homePages.HomePage;
import oscar.pages.PageBase;

public class OrderConfirmationPage extends PageBase {
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(text(), 'your order number is')]")
    WebElement orderNumber;

    @FindBy(xpath = "//*[contains(text(), 'Continue shopping')]")
    WebElement continueShoppingButton;


    public String getOrderNumber() {
        String number = orderNumber.getText();
        return number;
    }

    public HomePage continueShopping() {
        continueShoppingButton.click();
        return new HomePage(driver);
    }


}
