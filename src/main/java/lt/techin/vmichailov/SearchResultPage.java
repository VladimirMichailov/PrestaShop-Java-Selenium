package lt.techin.vmichailov;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultPage extends BasePage{

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @FindBy(css = " .js-product-miniature.product-miniature.reviews-loaded h2 > a")
    List<WebElement> itemNames;

    public List<WebElement> getItemNames() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByCssSelector("div#js-product-list")));
        return itemNames;
    }

}
