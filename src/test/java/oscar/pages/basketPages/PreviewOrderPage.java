package oscar.pages.basketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import oscar.pages.PageBase;
import oscar.pages.profilePages.OrderConfirmationPage;

public class PreviewOrderPage extends PageBase {
    public PreviewOrderPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "place-order")
    WebElement placeOrderButton;

    public OrderConfirmationPage placeOrder() {
        placeOrderButton.click();
        return new OrderConfirmationPage(driver);
    }

}
