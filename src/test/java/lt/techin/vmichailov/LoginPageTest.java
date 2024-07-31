package lt.techin.vmichailov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
