package oscar.pages.basketPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import oscar.pages.PageBase;


public class ShippingAddressPage extends PageBase {

    public ShippingAddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "first_name")
    WebElement firstNameAddress;

    @FindBy(name = "last_name")
    WebElement lastNameAddress;

    @FindBy(name = "line1")
    WebElement line1Address;

    @FindBy(name = "line4")
    WebElement cityAddress;


    @FindBy(name = "postcode")
    WebElement postCodeAddress;

    @FindBy(id = "id_country")
    WebElement countryAddress;

    @FindBy(xpath = "//*[contains(text(), 'Continue')]")
    WebElement continueButton;


//  public ShippingAddressPage isFieldInputRequired (){
//      if(firstNameAddress.getAttribute("required")==null) {
//          System.out.println("Field is not mandatory");
//      }else{
//          System.out.println("Field is   mandatory");
//      }
//      return this;
//  }


    public ShippingAddressPage typeShippingAddress() {
        type(firstNameAddress, "Elena");
        type(lastNameAddress, "Per");
        type(line1Address, "Street");
        type(cityAddress, "Berlin");
        type(postCodeAddress, "10444");
        countryAddress.click();
        selectDropDownByValue(countryAddress, "DE");
        return new ShippingAddressPage(driver);
    }

    public PaymentPage clickContinue() {
        continueButton.click();
        return new PaymentPage(driver);
    }


    public ShippingAddressPage leaveEmptyMandatoryFieldInShippingAddress() {
        typeShippingAddress();
        firstNameAddress.clear();
        clickContinue();

        typeShippingAddress();
        lastNameAddress.clear();
        clickContinue();

        typeShippingAddress();
        line1Address.clear();
        clickContinue();

        typeShippingAddress();
        cityAddress.clear();
        clickContinue();

        typeShippingAddress();
        postCodeAddress.clear();
        clickContinue();


        return this;
    }


}
