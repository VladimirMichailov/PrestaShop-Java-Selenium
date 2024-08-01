package lt.techin.vmichailov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

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
        Assertions.assertNotEquals(UserDataGenerator.getFirstName() + " " + UserDataGenerator.getLastName(), loginPage.getMyUserName(), "Name does not match");
        Assertions.assertEquals("http://192.168.32.234/registration", driver.getCurrentUrl(), "web addresses not match");
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
        Assertions.assertNotEquals(UserDataGenerator.getFirstName() + " " + UserDataGenerator.getLastName(), loginPage.getMyUserName(), "Name does not match");
        Assertions.assertEquals("http://192.168.32.234/registration", driver.getCurrentUrl(), "web addresses not match");
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
        Assertions.assertEquals("http://192.168.32.234/registration", driver.getCurrentUrl(), "web addresses not match");
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
        Assertions.assertEquals("http://192.168.32.234/registration", driver.getCurrentUrl(), "web addresses not match");
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
        Assertions.assertEquals("http://192.168.32.234/login?back=http%3A%2F%2F192.168.32.234%2F", driver.getCurrentUrl(), "web addresses not match");

    }
}
