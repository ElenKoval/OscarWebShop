package oscar.pages.profilePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import oscar.pages.PageBase;

public class AccountPage extends PageBase {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Order History")
    WebElement orderHistory;

    public AccountPage viewOrderHistory() {
        orderHistory.click();
        return new AccountPage(driver);
    }

    @FindBy(xpath = "//*[@class='table table-striped table-bordered']/tbody/tr[2]/td[1]/a")
    WebElement orderNumberInHistory;

    public String getOrderNumberHistory() {
        String actual = orderNumberInHistory.getText();
        return actual;
    }

}
