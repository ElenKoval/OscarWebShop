package oscar.pages.basketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import oscar.pages.PageBase;

public class PaymentPage extends PageBase {
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "view_preview")
    WebElement continuePaymentButton;

    public PreviewOrderPage continueCheckout() {
        continuePaymentButton.click();
        return new PreviewOrderPage(driver);
    }
}
