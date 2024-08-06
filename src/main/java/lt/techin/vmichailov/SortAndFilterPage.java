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
import java.util.List;

public class SortAndFilterPage extends BasePage {
    public SortAndFilterPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    Actions actions = new Actions(driver);

    // Categories

    @FindBy(linkText = "CLOTHES")
    WebElement clothesCategory;

    @FindBy(css = "#_desktop_top_menu .category:nth-of-type(2) [data-depth='0']")
    WebElement accessoriesCategory;

    @FindBy(css = "#_desktop_top_menu .category:nth-of-type(3) [data-depth]")
    WebElement artCategory;

    //Sort By selectors

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

    @FindBy(css = ".js-product-miniature.product-miniature.reviews-loaded h2 > a")
    List<WebElement> sortedItemNames;

    @FindBy(css = ".js-product-miniature.product-miniature.reviews-loaded .price")
    List<WebElement> priceAfterSort;

    //Filters selectors for clothes

    @FindBy(css = "section:nth-of-type(1) > .collapse .custom-checkbox")
    WebElement inStockCheckbox;

    @FindBy(css="section:nth-of-type(2) > .collapse > li:nth-of-type(1) > .facet-label > .custom-checkbox")
    WebElement discountedCheckbox;

    @FindBy(css="section:nth-of-type(2) > .collapse > li:nth-of-type(2) > .facet-label > .custom-checkbox")
    WebElement newProductCheckbox;

    @FindBy(css=".ui-widget-header")
    WebElement priceSliderBar;

    @FindBy(css = ".ui-corner-all.ui-slider.ui-slider-horizontal.ui-widget.ui-widget-content > a:nth-of-type(1)")
    WebElement minPrideSlider;

    @FindBy(css = ".ui-corner-all.ui-slider.ui-slider-horizontal.ui-widget.ui-widget-content > a:nth-of-type(2)")
    WebElement maxPriceSlider;

    @FindBy(css = "section:nth-of-type(4) > .collapse > li:nth-of-type(1) > .facet-label > .custom-checkbox")
    WebElement menCategoryCheckbox;

    @FindBy(css = "section:nth-of-type(4) > .collapse > li:nth-of-type(2) > .facet-label > .custom-checkbox")
    WebElement womenCategoryCheckbox;

    @FindBy(css ="section:nth-of-type(5) > .collapse > li:nth-of-type(1) > .facet-label > .custom-checkbox")
    WebElement sSizeCheckbox;

    @FindBy(css= "section:nth-of-type(5) > .collapse > li:nth-of-type(2) > .facet-label > .custom-checkbox")
    WebElement mSizeCheckbox;

    @FindBy(css = "li:nth-of-type(3) > .facet-label > .custom-checkbox")
    WebElement lSizeCheckbox;

    @FindBy(css = "li:nth-of-type(4) > .facet-label > .custom-checkbox")
    WebElement xlSizeCheckbox;

    @FindBy(css = "section:nth-of-type(6) > .collapse > li:nth-of-type(1) > .facet-label > .custom-checkbox")
    WebElement colorWhiteCheckbox;

    @FindBy(css = "section:nth-of-type(6) > .collapse > li:nth-of-type(2) > .facet-label > .custom-checkbox")
    WebElement colorBlackCheckbox;

    @FindBy(css = "section:nth-of-type(7) > .collapse > li:nth-of-type(1) > .facet-label > .custom-checkbox")
    WebElement longSleeves;

    @FindBy(css ="section:nth-of-type(7) > .collapse > li:nth-of-type(2) > .facet-label > ._gray-darker.js-search-link.search-link")
    WebElement shortSleeves;











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
        wait.until(ExpectedConditions.urlToBe("http://192.168.89.47/3-clothes"));
    }

    public void waitForAccessoriesPage() {
        wait.until(ExpectedConditions.urlToBe("http://192.168.89.47/6-accessories"));
    }

    public void waitForArtPage() {
        wait.until(ExpectedConditions.urlToBe("http://192.168.89.47/9-art"));
    }

    public void waitForAnyPageExceptClothes() {
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe("http://192.168.89.47/3-clothes")));
    }

    public void waitForAnyPageExceptAccessories() {
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe("http://192.168.89.47/6-accessories")));
    }

    public void waitForAnyPageExceptArt() {
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe("http://192.168.89.47/9-art")));
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

    // Sort By methods.

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

    public List<WebElement> getSortedItemNames() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByCssSelector("#products")));
        return sortedItemNames;
    }

    public List<WebElement> getSortedItemPrices() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByCssSelector("#products")));
        return priceAfterSort;
    }

    //Clothes filter by methods
    public void scrollToSizeS(){
        actions.scrollToElement(sSizeCheckbox);
        actions.perform();
    }

    public void scrollToShortSleeves(){
        actions.scrollToElement(shortSleeves);
        actions.perform();
    }

    public void clickInStock(){
        inStockCheckbox.click();
    }



    public void clickDiscounted(){
        discountedCheckbox.click();
    }

    public void clickNewProduct(){
        newProductCheckbox.click();
    }

    public void clickCategoryMen(){
        menCategoryCheckbox.click();
    }

    public void clickCategoryWomen(){
        womenCategoryCheckbox.click();
    }

    public void clickSizeS(){
        sSizeCheckbox.click();
    }

    public void clickSizeM(){
        mSizeCheckbox.click();
    }

    public void clickSizeL(){
        lSizeCheckbox.click();
    }

    public void clickSizeXl(){
        xlSizeCheckbox.click();
    }

    public void clickColorWhite(){
        colorWhiteCheckbox.click();
    }

    public void clickColorBlack(){
        colorBlackCheckbox.click();
    }

    public void clickPropertyLongSleeves(){
        longSleeves.click();
    }

    public void clickPropertyShortSleeves(){
        shortSleeves.click();
    }

    public void setSliderPrice(int desiredPrice, int minPrice, int maxPrice) {
        int sliderWidth = priceSliderBar.getSize().width;

        // Calculate the offset to move the slider
        int xOffset = (desiredPrice - minPrice) * sliderWidth / (maxPrice - minPrice);
        actions.dragAndDropBy(minPrideSlider, xOffset, 0).perform();
    }
}
