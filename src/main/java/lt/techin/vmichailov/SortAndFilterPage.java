package lt.techin.vmichailov;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SortAndFilterPage extends BasePage {
    public SortAndFilterPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    Actions actions = new Actions(driver);

    @FindBy(linkText = "CLOTHES")
    WebElement clothesCategory;

    @FindBy(css = "#_desktop_top_menu .category:nth-of-type(2) [data-depth='0']")
    WebElement accessoriesCategory;

    @FindBy(css = "#_desktop_top_menu .category:nth-of-type(3) [data-depth]")
    WebElement artCategory;

    @FindBy(css = ".btn-unstyle.select-title")
    WebElement sortByMenus;

    @FindBy(linkText = "Sales, highest to lowest")
    WebElement sales;

    @FindBy(linkText = "Relevance")
    WebElement relevance;

    @FindBy(linkText = "Name, A to Z")
    WebElement nameAtoZ;

    @FindBy(linkText = "Name, Z to A")
    WebElement nameZtoA;

    @FindBy(linkText = "Price, low to high")
    WebElement priceLowToHigh;

    @FindBy(linkText = "Price, high to low")
    WebElement priceHighToLow;

    @FindBy(linkText = "Reference, A to Z")
    WebElement referenceAtoZ;

    @FindBy(linkText = "Reference, Z to A")
    WebElement referenceZtoA;

    // Select category

    public void clickClothesCategory() {
        clothesCategory.click();
    }

    public void clickAccessoriesCategory() {
        accessoriesCategory.click();
    }

    public void clickArtCategory() {
        artCategory.click();
    }

    // Wait for category page

    public void waitForClothesPage() {
        wait.until(ExpectedConditions.urlToBe("http://192.168.32.234/3-clothes"));
    }

    public void waitForAccessoriesPage() {
        wait.until(ExpectedConditions.urlToBe("http://192.168.32.234/6-accessories"));
    }

    public void waitForArtPage() {
        wait.until(ExpectedConditions.urlToBe("http://192.168.32.234/9-art"));
    }

    // Sort by methods

    public void scrollToSortBy(){
        actions.scrollToElement(sortByMenus);
        actions.perform();
    }

    public void scrollDown(){
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(sortByMenus);
        actions.scrollFromOrigin(scrollOrigin, 0, 400)
                .perform();
    }

    public void waitForSortBy(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByCssSelector(".btn-unstyle.select-title")));
    }

    public void clickSortBy() {
        sortByMenus.click();
    }

    public void sortBySales(){
        sales.click();
    }

    public void sortByRelevance(){
        relevance.click();
    }
    public void sortByNameAtoZ(){
        nameAtoZ.click();
    }

    public void sortByNameZtoA(){
        nameZtoA.click();
    }

    public void sortByPriceLowToHigh(){
        priceLowToHigh.click();
    }

    public void sortByPriceHighToLow(){
        priceHighToLow.click();
    }

    public void sortByReferenceAtoZ(){
        referenceAtoZ.click();
    }

    public void sortByReferenceZtoA(){
        referenceZtoA.click();
    }

    public String getTextFromSortBy(){
        return sortByMenus.getText();
    }

}
