package lt.techin.vmichailov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchTest extends BaseTest {

    @Test
    void searchForValidItem() {
        LoginPage loginPage = new LoginPage(driver);
        SearchResultPage searchPage = new SearchResultPage(driver);
        loginPage.clickToSignIn();
        loginPage.setEmail("darto.vaiderio@kosminis.lt");
        loginPage.setPassword("*DartasBlogas+");
        loginPage.submitLogin();
        String validItem = ItemData.getRandomValidItem();
        loginPage.searchItem(validItem);
        List<WebElement> productNames = searchPage.getItemNames();
        for (WebElement productNameElement : productNames) {
            String productName = productNameElement.getText().toLowerCase();
            Assertions.assertTrue(productName.contains(validItem.toLowerCase()), "Product name does not contain " + validItem.toLowerCase());
            System.out.println(productName.toLowerCase());
        }
        System.out.println(validItem.toLowerCase());

    }


    @Test
    void searchForInValidItem() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        SearchResultPage searchPage = new SearchResultPage(driver);
        loginPage.clickToSignIn();
        loginPage.setEmail("darto.vaiderio@kosminis.lt");
        loginPage.setPassword("*DartasBlogas+");
        loginPage.submitLogin();
        ItemData.searchData();
        String invalidItem = ItemData.getRandomInValidItem();
        loginPage.searchItem(invalidItem);
        List<WebElement> productNames = searchPage.getItemNames();
        for (WebElement productNameElement : productNames) {
            String productName = productNameElement.getText().toLowerCase();
            Assertions.assertFalse(productName.contains(invalidItem.toLowerCase()), "Product name contain " + invalidItem.toLowerCase());
            System.out.println(productName.toLowerCase());
        }
        System.out.println(invalidItem.toLowerCase());
    }
}
