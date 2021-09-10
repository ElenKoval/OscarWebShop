package oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBase {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_registration-email")
    WebElement emailField;

    @FindBy(id = "id_registration-password1")
    WebElement passwordField;

    @FindBy(id = "id_registration-password2")
    WebElement confirmPswField;

    @FindBy(name = "registration_submit")
    WebElement registerBtn;

    public RegisterPage fillRegisterForm(String email, String pwd, String pwd1) {
        type(emailField, email);
        type(passwordField, pwd);
        type(confirmPswField, pwd1);
        registerBtn.click();
        return this;
    }

    @FindBy(id = "register_form")
    WebElement registerForm;

    public boolean isRegisterFormDisplayed() {
        return registerForm.isDisplayed();
    }

    @FindBy(id = "id_login-username")
    WebElement emailFieldLogin;

    @FindBy(name = "login-password")
    WebElement passwordFieldLogin;

    @FindBy(name = "login_submit")
    WebElement loginBtn;

    public RegisterPage fillLoginForm(String email, String pwd) {
        type(emailFieldLogin, email);
        type(passwordFieldLogin, pwd);
        loginBtn.click();
        return this;
    }
}
