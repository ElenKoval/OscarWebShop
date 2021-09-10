package oscar.pages.profilePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import oscar.pages.PageBase;

public class WishListPage extends PageBase {
    public WishListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(@href,'wish')]")
    WebElement goToWishList;

    @FindBy(xpath = "//a[contains(@href,'create')]")
    WebElement createWishList;

    @FindBy(name = "name")
    WebElement nameForWishList;

    @FindBy(xpath = "//button[contains(.,'Save')]")
    WebElement saveWishList;


    public WishListPage goToWishList() {
        goToWishList.click();
        return new WishListPage(driver);
    }

    public void wishListCreate(String name) {
        createWishList.click();
        nameForWishList.clear();
        nameForWishList.sendKeys(name);
        saveWishList.click();

    }

    @FindBy(xpath = "//div[contains(@class,'alertinner wicon')]")
    WebElement wishListIsCreated;

    public String wishListCreated() {
        return wishListIsCreated.getText();
    }
}
