package oscar.tests.profilePageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import oscar.pages.profilePages.AddressBookPage;
import oscar.pages.homePages.HomePage;
import oscar.pages.RegisterPage;
import oscar.pages.profilePages.ProfilePage;
import oscar.tests.TestBase;

public class AddressBookPageTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).clickOnLoginBtn();
        new RegisterPage(driver).fillLoginForm("cyprus@gmail.com","Draft123456!");
        new HomePage(driver).accountInfo();
        new AddressBookPage(driver).goToAddressBookPage();
    }

    @Test
    public void addressEditTestPositive(){

        new AddressBookPage(driver).editAddress("Zozo");
        String name=new AddressBookPage(driver).nameInBook();
        Assert.assertTrue(name.startsWith("Zozo"));
    }

    @Test
    public void addressEditWithEmptyNameTestNegative() throws InterruptedException {
        new AddressBookPage(driver).editAddress("");
        Assert.assertTrue(new AddressBookPage(driver).isEditAddressFieldsAreDisplayed());
    }
    @AfterMethod
    public void deleteProfile() {
        new HomePage(driver).accountInfo();
        new AddressBookPage(driver).editAddress("Toro");
    }


}
