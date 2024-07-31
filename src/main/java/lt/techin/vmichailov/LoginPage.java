package lt.techin.vmichailov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    // Locators
    @FindBy(css = "#_desktop_user_info > div > a > i")
    private WebElement signInArea;

    @FindBy(css = "[data-link-action='display-register-form']")
    private WebElement createNewAccount;

    @FindBy(css = "label:nth-of-type(1) input[name='id_gender']")
    private WebElement genderIdMale;

    @FindBy(css = "input#field-firstname")
    private WebElement inputFirstName;

    @FindBy(css = "input#field-lastname")
    private WebElement inputSecondName;

    @FindBy(css = "input#field-email")
    private WebElement inputEmail;

    @FindBy(css = "input#field-password")
    private WebElement inputPassword;

    @FindBy(css = "input[name='psgdpr']")
    private WebElement agreeToTermsMarker;

    @FindBy(css = "input[name='customer_privacy']")
    private WebElement dataPrivacyMarker;

    @FindBy(css = "[title] .hidden-sm-down")
    private WebElement myUserName;

    @FindBy(css = "#_desktop_user_info > div > a.logout.hidden-sm-down > i")
    private WebElement logOut;

    @FindBy(css = "#customer-form > footer > button")
    private WebElement loginSaveButton;

    @FindBy(css = "button#submit-login")
    private WebElement loginSubmitButton;

    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Click on the Sign In area
    public void clickToSignIn() {
        signInArea.click();
    }

    // Click to create a new account
    public void clickToCreateNewAccount() {
        createNewAccount.click();
    }

    // Choose gender
    public void chooseGender() {
        genderIdMale.click();
    }

    // Set first name
    public void setFirstName(String firstName) {
        inputFirstName.clear();
        inputFirstName.sendKeys(firstName);
    }

    // Set second name
    public void setSecondName(String secondName) {
        inputSecondName.clear();
        inputSecondName.sendKeys(secondName);
    }

    // Set email
    public void setEmail(String email) {
        inputEmail.clear();
        inputEmail.sendKeys(email);
    }

    // Set password
    public void setPassword(String password) {
        inputPassword.clear();
        inputPassword.sendKeys(password);
    }

    // Click agree to terms marker
    public void agreeToTerms() {
        agreeToTermsMarker.click();
    }

    // Click data privacy marker
    public void agreeToDataPrivacy() {
        dataPrivacyMarker.click();
    }

    // Click login save button
    public void clickLoginSaveButton() {
        loginSaveButton.click();
    }

    // Get the logged-in user's name
    public String getMyUserName() {
        return wait.until(ExpectedConditions.visibilityOf(myUserName)).getText();
    }

    // Click logout
    public void logOut() {
        logOut.click();
    }

    // Click login submit button
    public void submitLogin() {
        loginSubmitButton.click();
    }
}
