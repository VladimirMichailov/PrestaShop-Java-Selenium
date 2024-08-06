package lt.techin.vmichailov;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LoginPageTest extends BaseTest {

    @Test
    void registerAndLoginStaticData() {
        LoginPage loginPage = new LoginPage(driver);

        // Register with static data
        loginPage.clickToSignIn();
        loginPage.clickToCreateNewAccount();
        loginPage.chooseGender();
        loginPage.setFirstName("Dartas");
        loginPage.setSecondName("Vaideris");
        loginPage.setEmail("darto.vaiderio@kosminis.lt");
        loginPage.setPassword("*DartasBlogas+");
        loginPage.agreeToTerms();
        loginPage.agreeToDataPrivacy();
        loginPage.clickLoginSaveButton();

        // Verify user is logged in
        Assertions.assertEquals("Dartas Vaideris", loginPage.getMyUserName(), "Name does not match");

        // Logout and login again
        loginPage.logOut();
        loginPage.clickToSignIn();
        loginPage.setEmail("darto.vaiderio@kosminis.lt");
        loginPage.setPassword("*DartasBlogas+");
        loginPage.submitLogin();

        // Verify user is logged in
        Assertions.assertEquals("Dartas Vaideris", loginPage.getMyUserName(), "Name does not match");
    }

    @Test
    void registerAndLoginRandomData() {
        LoginPage loginPage = new LoginPage(driver);

        // Generate random user data
        UserDataGenerator.generateUserData();

        // Register with random data
        loginPage.clickToSignIn();
        loginPage.clickToCreateNewAccount();
        loginPage.chooseGender();
        loginPage.setFirstName(UserDataGenerator.getFirstName());
        loginPage.setSecondName(UserDataGenerator.getLastName());
        loginPage.setEmail(UserDataGenerator.getEmail());
        loginPage.setPassword(UserDataGenerator.getPassword());

        loginPage.agreeToTerms();
        loginPage.agreeToDataPrivacy();
        loginPage.clickLoginSaveButton();

        // Verify user is logged in
        Assertions.assertEquals(UserDataGenerator.getFirstName() + " " + UserDataGenerator.getLastName(), loginPage.getMyUserName(), "Name does not match");

        // Logout and login again
        loginPage.logOut();
        loginPage.clickToSignIn();
        loginPage.setEmail(UserDataGenerator.getEmail());
        loginPage.setPassword(UserDataGenerator.getPassword());
        loginPage.submitLogin();

        // Verify user is logged in
        Assertions.assertEquals(UserDataGenerator.getFirstName() + " " + UserDataGenerator.getLastName(), loginPage.getMyUserName(), "Name does not match");
        System.out.println(UserDataGenerator.getEmail());
        System.out.println(UserDataGenerator.getPassword());
    }

    @Test
    void registerAndLoginRandomDataGenerateCsv() {
        LoginPage loginPage = new LoginPage(driver);

        // Generate random user data
        UserDataGenerator.generateUserData();

        // Register with random data
        loginPage.clickToSignIn();
        loginPage.clickToCreateNewAccount();
        loginPage.chooseGender();

        String randomName = UserDataGenerator.getFirstName();
        String randomLastName = UserDataGenerator.getLastName();
        String randomEmail = UserDataGenerator.getEmail();
        String randomPassword = UserDataGenerator.getPassword();
        String userName = randomName + " " + randomLastName;

        loginPage.setFirstName(randomName);
        loginPage.setSecondName(randomLastName);
        loginPage.setEmail(randomEmail);
        loginPage.setPassword(randomPassword);

        List<String[]> loginData = new ArrayList<>();
        loginData.add(new String[]{randomEmail, randomPassword, userName});
        String filePath = Paths.get("C:", "Users", "orevi", "Desktop", "prestashop-egzaminams", "src", "test", "resources", "loginData.csv").toString();
        File csvFile = new File(filePath);

        loginPage.writeDataToCSV(csvFile, loginData);



        loginPage.agreeToTerms();
        loginPage.agreeToDataPrivacy();
        loginPage.clickLoginSaveButton();

        // Verify user is logged in

        Assertions.assertEquals(userName, loginPage.getMyUserName(), "Name does not match");

        // Logout and login again
        loginPage.logOut();
        loginPage.clickToSignIn();
        loginPage.setEmail(randomEmail);
        loginPage.setPassword(randomPassword);
        loginPage.submitLogin();

        // Verify user is logged in
        Assertions.assertEquals(userName , loginPage.getMyUserName(), "Name does not match");
        System.out.println(randomEmail);
        System.out.println(randomPassword);
    }

    @Test
    void registerAndLoginRandomDataSameEmail() {
        LoginPage loginPage = new LoginPage(driver);

        // Generate random user data
        UserDataGenerator.generateUserData();

        // Register with random data
        loginPage.clickToSignIn();
        loginPage.clickToCreateNewAccount();
        loginPage.chooseGender();
        loginPage.setFirstName(UserDataGenerator.getFirstName());
        loginPage.setSecondName(UserDataGenerator.getLastName());
        loginPage.setEmail(UserDataGenerator.getEmail());
        loginPage.setPassword(UserDataGenerator.getPassword());
        loginPage.agreeToTerms();
        loginPage.agreeToDataPrivacy();
        loginPage.clickLoginSaveButton();

        // Verify user is logged in
        Assertions.assertEquals(UserDataGenerator.getFirstName() + " " + UserDataGenerator.getLastName(), loginPage.getMyUserName(), "Name does not match");

        // Logout and register with same data
        loginPage.logOut();
        loginPage.clickToSignIn();
        loginPage.clickToCreateNewAccount();
        loginPage.chooseGender();
        loginPage.setFirstName(UserDataGenerator.getFirstName());
        loginPage.setSecondName(UserDataGenerator.getLastName());
        loginPage.setEmail(UserDataGenerator.getEmail());
        loginPage.setPassword(UserDataGenerator.getPassword());
        loginPage.agreeToTerms();
        loginPage.agreeToDataPrivacy();
        loginPage.clickLoginSaveButton();

        // Verify user is logged in
        Assertions.assertNotEquals(UserDataGenerator.getFirstName() + " " + UserDataGenerator.getLastName(), loginPage.getMyUserName(), "Text should not match");
        // Verify warning message text
        Assertions.assertEquals("The email is already used, please choose another one or sign in", loginPage.getWarningMessageText(), "Messages does not match");
        System.out.println(UserDataGenerator.getEmail());
        System.out.println(UserDataGenerator.getPassword());
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/invalid_first_name_values.csv", numLinesToSkip = 1)
    void registerUsingInvalidFirstName(String firstName) {
        LoginPage loginPage = new LoginPage(driver);

        // Generate random user data
        UserDataGenerator.generateUserData();

        // Register with random data
        loginPage.clickToSignIn();
        loginPage.clickToCreateNewAccount();
        loginPage.chooseGender();
        loginPage.setFirstName(firstName);
        loginPage.setSecondName(UserDataGenerator.getLastName());
        loginPage.setEmail(UserDataGenerator.getEmail());
        loginPage.setPassword(UserDataGenerator.getPassword());
        loginPage.agreeToTerms();
        loginPage.agreeToDataPrivacy();
        loginPage.clickLoginSaveButton();

        // Verify user is not logged in
        Assertions.assertNotEquals(firstName + " " + UserDataGenerator.getLastName(), loginPage.getMyUserName(), "Name does not match");
        Assertions.assertEquals("http://192.168.89.47/registration", driver.getCurrentUrl(), "web addresses not match");
// form accepts spaces before name " John", space after name "John ", special symbol "John-Doe", space inside name "J ohn"
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/invalid_second_name_values.csv", numLinesToSkip = 1)
    void registerUsingInvalidLastName(String lastName) {
        LoginPage loginPage = new LoginPage(driver);

        // Generate random user data
        UserDataGenerator.generateUserData();

        // Register with random data
        loginPage.clickToSignIn();
        loginPage.clickToCreateNewAccount();
        loginPage.chooseGender();
        loginPage.setFirstName(UserDataGenerator.getFirstName());
        loginPage.setSecondName(lastName);
        loginPage.setEmail(UserDataGenerator.getEmail());
        loginPage.setPassword(UserDataGenerator.getPassword());
        loginPage.agreeToTerms();
        loginPage.agreeToDataPrivacy();
        loginPage.clickLoginSaveButton();

        // Verify user is not logged in
        Assertions.assertNotEquals(UserDataGenerator.getFirstName() + " " + lastName, loginPage.getMyUserName(), "Name does not appeare");
        Assertions.assertEquals("http://192.168.89.47/registration", driver.getCurrentUrl(), "web addresses not match");
// form accepts spaces before lastname " Doe", space after secondname "Doe ", special symbol "Doe-John", space inside name "D oe"
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/invalid_email_values.csv", numLinesToSkip = 1)
    void registerUsingInvalidEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);

        // Generate random user data
        UserDataGenerator.generateUserData();

        // Register with random data
        loginPage.clickToSignIn();
        loginPage.clickToCreateNewAccount();
        loginPage.chooseGender();
        loginPage.setFirstName(UserDataGenerator.getFirstName());
        loginPage.setSecondName(UserDataGenerator.getRandomSecondName());
        loginPage.setEmail(email);
        loginPage.setPassword(UserDataGenerator.getPassword());
        loginPage.agreeToTerms();
        loginPage.agreeToDataPrivacy();
        loginPage.clickLoginSaveButton();

        // Verify user is not logged in
        Assertions.assertNotEquals(UserDataGenerator.getFirstName() + " " + UserDataGenerator.getLastName(), loginPage.getMyUserName(), "Name does not match");
        Assertions.assertEquals("http://192.168.89.47/registration", driver.getCurrentUrl(), "web addresses not match");
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/invalid password.csv", numLinesToSkip = 1)
    void registerUsingBadPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);

        // Generate random user data
        UserDataGenerator.generateUserData();

        // Register with random data
        loginPage.clickToSignIn();
        loginPage.clickToCreateNewAccount();
        loginPage.chooseGender();
        loginPage.setFirstName(UserDataGenerator.getFirstName());
        loginPage.setSecondName(UserDataGenerator.getRandomSecondName());
        loginPage.setEmail(UserDataGenerator.getEmail());
        loginPage.setPassword(password);
        loginPage.agreeToTerms();
        loginPage.agreeToDataPrivacy();
        loginPage.clickLoginSaveButton();

        // Verify user is not logged in
        Assertions.assertNotEquals(UserDataGenerator.getFirstName() + " " + UserDataGenerator.getLastName(), loginPage.getMyUserName(), "Name does not match");
        Assertions.assertEquals("http://192.168.89.47/registration", driver.getCurrentUrl(), "web addresses not match");
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/bad-email-password.csv", numLinesToSkip = 1)
    void loginUsingInvalidCredentials(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickToSignIn();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.submitLogin();
        Assertions.assertNotEquals(UserDataGenerator.getFirstName() + " " + UserDataGenerator.getLastName(), loginPage.getMyUserName(), "Name does not match");
        Assertions.assertEquals("http://192.168.89.47/login?back=http%3A%2F%2F192.168.89.47%2F", driver.getCurrentUrl(), "web addresses not match");

    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/loginData.csv", numLinesToSkip = 1)
    void loginUsingSavedCredentials(String email, String password, String userName) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickToSignIn();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.submitLogin();
        Assertions.assertEquals(userName, loginPage.getMyUserName(), "Name does not match");
        Assertions.assertEquals("http://192.168.89.47/", driver.getCurrentUrl(), "web addresses not match");

    }
}
