package oscar.pages.profilePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import oscar.pages.PageBase;

public class EmailHistoryPage extends PageBase {
    public EmailHistoryPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//li[contains(.,'Email')]")
    WebElement goToEmailHistoryPage;

    public void goToEmailHistoryPage() {
        goToEmailHistoryPage.click();
    }

    @FindBy(xpath = "//*[contains(text(), 'Confirmation of order')]")
    WebElement orderNumberFromEmail;

    public String getOrderNumberFromEmail() {
        String orderNumber = orderNumberFromEmail.getText();
        String[] words = orderNumber.split(" ");
        return words[words.length - 1];
    }
}
