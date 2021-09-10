package oscar.pages.basketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import oscar.pages.PageBase;

public class OrderPage extends PageBase {
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class,'page-header action')]")
    WebElement orderNumberInOrderHistory;

    public String getOrderNumber() {
        return orderNumberInOrderHistory.getText();
    }
}

