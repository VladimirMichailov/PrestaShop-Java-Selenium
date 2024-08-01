package lt.techin.vmichailov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchTest extends BaseTest{
@Test
void searchForValidItem(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.clickToSignIn();
    loginPage.setEmail("darto.vaiderio@kosminis.lt");
    loginPage.setPassword("*DartasBlogas+");
    loginPage.submitLogin();
    loginPage.searchItem(ItemData.getRandomValidItem());
    
    //Assertions.assertEquals(ItemData.getRandomValidItem().toUpperCase(), loginPage.getItemName().toUpperCase(),
           // "The product name should match.");


}
}
