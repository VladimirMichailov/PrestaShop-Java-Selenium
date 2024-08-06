package lt.techin.vmichailov;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;

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

    @FindBy(css = ".alert-danger")
    WebElement emailWarningMessage;

    @FindBy(css = "input[name='s']")
    WebElement searchInputWindow;



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

    // Get error warning message after bad email input
    public String getWarningMessageText() {
        return wait.until(ExpectedConditions.visibilityOf(emailWarningMessage)).getText();
    }

    // Search for items
    public void searchItem(String itemName) {
        searchInputWindow.clear();
        searchInputWindow.sendKeys(itemName);
        searchInputWindow.sendKeys(Keys.ENTER);
    }

//    public void writeDataToCSV(File file, List<String[]> loginData) {
//        try (FileWriter out = new FileWriter(file);
//             CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader("email", "password", "username"))) {
//            for (String[] record : loginData) {
//                printer.printRecord(record);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void writeDataToCSV(File file, List<String[]> loginData) {
        boolean fileExists = file.exists();

        try (FileWriter out = new FileWriter(file, true); // Open in append mode
             CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT.withRecordSeparator("\n"))) {

            // Add header only if the file does not exist or is empty
            if (!fileExists || Files.size(file.toPath()) == 0) {
                printer.printRecord("email", "password", "username");
            }

            for (String[] record : loginData) {
                printer.printRecord((Object[]) record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

