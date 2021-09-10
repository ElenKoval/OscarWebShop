package oscar.pages.basketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import oscar.pages.PageBase;


public class BasketPage extends PageBase {
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "View basket")
    WebElement viewBasket;

    public BasketPage clickOnViewButton() {
        viewBasket.click();
        return this;
    }

    @FindBy(linkText = "Proceed to checkout")
    WebElement checkout;

    public BasketPage clickOnCheckout() {
        checkout.click();
        return this;
    }


}
