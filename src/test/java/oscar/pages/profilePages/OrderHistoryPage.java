package oscar.pages.profilePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import oscar.pages.PageBase;

public class OrderHistoryPage extends PageBase {
    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[contains(.,'Order History')]")
    WebElement orderHistory;

    public OrderHistoryPage goToOrderHistoryPage() {
        orderHistory.click();
        return new OrderHistoryPage(driver);
    }

    @FindBy(id = "id_date_from")
    WebElement dateFrom;

    @FindBy(id = "id_date_to")
    WebElement dateTo;

    @FindBy(id = "id_order_number")
    WebElement orderNumber;

    @FindBy(xpath = "//*[contains(text(), 'Filter results')]")
    WebElement filterButton;

    @FindBy(name = "order_number")
    WebElement filterByOrdersNumberField;

    @FindBy(xpath = "(//table//tr//td)[1]")
    WebElement orderNumberInAllOrders;

    public String getOrderNumberInAllOrders() {
        return new OrderHistoryPage(driver).orderNumberInAllOrders.getText();
    }

    public OrderHistoryPage filterByOrdersNumber() {
        filterByOrdersNumberField.sendKeys(getOrderNumberInAllOrders());
        return this;
    }

    public OrderHistoryPage filterResultClick() {
        filterButton.click();
        return new OrderHistoryPage(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'alert alert-danger') and contains(., 'Oops! We found some errors')]")
    WebElement alertEmpty;

    public String alertEmptyField() {
        return alertEmpty.getText();
    }


}
