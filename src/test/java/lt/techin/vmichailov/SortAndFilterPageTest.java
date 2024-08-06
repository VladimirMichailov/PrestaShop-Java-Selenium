package lt.techin.vmichailov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortAndFilterPageTest extends BaseTest {

    // Sort and filter clothes

    // Clothes sort by

    @Test
    void sortClothesBySale() throws InterruptedException {
        SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
        sortAndFilterPage.clickClothesCategory();
        sortAndFilterPage.waitForClothesPage();
        sortAndFilterPage.scrollToSortBy();
        sortAndFilterPage.scrollDown();
        sortAndFilterPage.clickSortBy();
        sortAndFilterPage.sortBySales();
        //Assertion needed
    }


    // Sort by relevance
    @Test
    void sortClothesByRelevance() {
        SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
        sortAndFilterPage.clickClothesCategory();
        sortAndFilterPage.waitForClothesPage();
        sortAndFilterPage.scrollToSortBy();
        sortAndFilterPage.scrollDown();
        sortAndFilterPage.clickSortBy();
        sortAndFilterPage.sortByRelevance();
        sortAndFilterPage.waitForAnyPageExceptClothes();
        //Assertion needed
    }

    // Sort by name A to Z
    @Test
    void sortClothesByNameAtoZ() {
        SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
        sortAndFilterPage.clickClothesCategory();
        sortAndFilterPage.waitForClothesPage();
        sortAndFilterPage.scrollToSortBy();
        sortAndFilterPage.scrollDown();
        sortAndFilterPage.clickSortBy();
        sortAndFilterPage.sortByNameAtoZ();
        sortAndFilterPage.waitForAnyPageExceptClothes();
        List<WebElement> productSortedNames = sortAndFilterPage.getSortedItemNames();
        List<String> unsortedNames = productSortedNames.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> sortedNames = productSortedNames.stream().map(WebElement::getText).sorted().collect(Collectors.toList());
//        Collections.sort(sortedNames);
        Assertions.assertEquals(sortedNames, unsortedNames, "The lists are not sorted as expected");

    }

    // Sort by name Z to A
    @Test
    void sortClothesByNameZtoA() {
        SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
        sortAndFilterPage.clickClothesCategory();
        sortAndFilterPage.waitForClothesPage();
        sortAndFilterPage.scrollToSortBy();
        sortAndFilterPage.scrollDown();
        sortAndFilterPage.clickSortBy();
        sortAndFilterPage.sortByNameZtoA();
        sortAndFilterPage.waitForAnyPageExceptClothes();
        List<WebElement> productAfterSortNames = sortAndFilterPage.getSortedItemNames();
        List<String> unsortedNames = productAfterSortNames.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> sortedNames = productAfterSortNames.stream().map(WebElement::getText).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        Assertions.assertEquals(sortedNames, unsortedNames, "The lists are not sorted as expected");

    }

    // Sort by price low to high
    @Test
    void sortClothesByPriceLowToHigh() {
        SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
        sortAndFilterPage.clickClothesCategory();
        sortAndFilterPage.waitForClothesPage();
        sortAndFilterPage.scrollToSortBy();
        sortAndFilterPage.scrollDown();
        sortAndFilterPage.clickSortBy();
        sortAndFilterPage.sortByPriceLowToHigh();
        sortAndFilterPage.waitForAnyPageExceptClothes();
        List<WebElement> productAfterSortPrice = sortAndFilterPage.getSortedItemPrices();
        List<String> unsortedPrices = productAfterSortPrice.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> sortedPrices = productAfterSortPrice.stream().map(WebElement::getText).sorted().collect(Collectors.toList());
        Assertions.assertEquals(sortedPrices, unsortedPrices, "The lists are not sorted as expected");

        //Assertion needed
    }

    // Sort by price high to low
    @Test
    void sortClothesByPriceHighToLow() {
        SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
        sortAndFilterPage.clickClothesCategory();
        sortAndFilterPage.waitForClothesPage();
        sortAndFilterPage.scrollToSortBy();
        sortAndFilterPage.scrollDown();
        sortAndFilterPage.clickSortBy();
        sortAndFilterPage.sortByPriceHighToLow();
        sortAndFilterPage.waitForAnyPageExceptClothes();
        List<WebElement> productAfterSortPrice = sortAndFilterPage.getSortedItemPrices();
        List<String> unsortedPrices = productAfterSortPrice.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> sortedPrices = productAfterSortPrice.stream().map(WebElement::getText).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        Assertions.assertEquals(sortedPrices, unsortedPrices, "The lists are not sorted as expected");

        //Assertion needed
    }

    // Sort by reference A to Z
    @Test
    void sortClothesByReferenceAtoZ() {
        SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
        sortAndFilterPage.clickClothesCategory();
        sortAndFilterPage.waitForClothesPage();
        sortAndFilterPage.scrollToSortBy();
        sortAndFilterPage.scrollDown();
        sortAndFilterPage.clickSortBy();
        sortAndFilterPage.sortByReferenceAtoZ();
        sortAndFilterPage.waitForAnyPageExceptClothes();
        //Assertion needed
    }

    // Sort by reference Z to A
    @Test
    void sortClothesByReferenceZtoA() {
        SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
        sortAndFilterPage.clickClothesCategory();
        sortAndFilterPage.waitForClothesPage();
        sortAndFilterPage.scrollToSortBy();
        sortAndFilterPage.scrollDown();
        sortAndFilterPage.clickSortBy();
        sortAndFilterPage.sortByReferenceZtoA();
        sortAndFilterPage.waitForAnyPageExceptClothes();
    //Assertion needed
}

// Filter clothes by...

@Test
void clothesFilterByInStock() {
    SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
    sortAndFilterPage.clickClothesCategory();
    sortAndFilterPage.waitForClothesPage();
    sortAndFilterPage.scrollToSizeS();
    sortAndFilterPage.clickInStock();
    sortAndFilterPage.waitForAnyPageExceptClothes();
    // sortAndFilterPage.scrollToSizeS();
    // sortAndFilterPage.clickInStock();
}

@Test
void clothesFilterByDiscounted() {
    SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
    sortAndFilterPage.clickClothesCategory();
    sortAndFilterPage.waitForClothesPage();
    sortAndFilterPage.scrollToSizeS();
    sortAndFilterPage.clickDiscounted();
    sortAndFilterPage.waitForAnyPageExceptClothes();
    //sortAndFilterPage.scrollToSizeS();
    //sortAndFilterPage.clickDiscounted();
}

@Test
void clothesFilterByNewProduct() {
    SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
    sortAndFilterPage.clickClothesCategory();
    sortAndFilterPage.waitForClothesPage();
    sortAndFilterPage.scrollToSizeS();
    sortAndFilterPage.clickNewProduct();
    sortAndFilterPage.waitForAnyPageExceptClothes();
}

@Test
void clothesFilterByPrice() {
    SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
    sortAndFilterPage.clickClothesCategory();
    sortAndFilterPage.waitForClothesPage();
    sortAndFilterPage.scrollToSizeS();
    int desiredPrice = 15;
    int minPrice = 9; // Replace with the actual minimum price value of the slider
    int maxPrice = 35; // Replace with the actual maximum price value of the slider

    sortAndFilterPage.setSliderPrice(desiredPrice, minPrice, maxPrice);
    // sortAndFilterPage.closeSelection();

}

@Test
void clothesFilterByCategoryMen() {
    SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
    sortAndFilterPage.clickClothesCategory();
    sortAndFilterPage.waitForClothesPage();
    sortAndFilterPage.scrollToSizeS();
    sortAndFilterPage.clickCategoryMen();
    sortAndFilterPage.waitForAnyPageExceptClothes();
}

@Test
void clothesFilterByCategoryWomen() {
    SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
    sortAndFilterPage.clickClothesCategory();
    sortAndFilterPage.waitForClothesPage();
    sortAndFilterPage.scrollToSizeS();
    sortAndFilterPage.clickCategoryWomen();
    sortAndFilterPage.waitForAnyPageExceptClothes();
}

@Test
void clothesFilterBySizeS() {
    SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
    sortAndFilterPage.clickClothesCategory();
    sortAndFilterPage.waitForClothesPage();
    sortAndFilterPage.scrollToSizeS();
    sortAndFilterPage.clickSizeS();
    sortAndFilterPage.waitForAnyPageExceptClothes();
}

@Test
void clothesFilterBySizeM() {
    SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
    sortAndFilterPage.clickClothesCategory();
    sortAndFilterPage.waitForClothesPage();
    sortAndFilterPage.scrollToShortSleeves();
    sortAndFilterPage.clickSizeM();
    sortAndFilterPage.waitForAnyPageExceptClothes();
}

@Test
void clothesFilterBySizeL() {
    SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
    sortAndFilterPage.clickClothesCategory();
    sortAndFilterPage.waitForClothesPage();
    sortAndFilterPage.scrollToShortSleeves();
    sortAndFilterPage.clickSizeL();
    sortAndFilterPage.waitForAnyPageExceptClothes();
}

@Test
void clothesFilterBySizeXl() {
    SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
    sortAndFilterPage.clickClothesCategory();
    sortAndFilterPage.waitForClothesPage();
    sortAndFilterPage.scrollToShortSleeves();
    sortAndFilterPage.clickSizeXl();
    sortAndFilterPage.waitForAnyPageExceptClothes();
}

@Test
void clothesFilterByColorWhite() {
    SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
    sortAndFilterPage.clickClothesCategory();
    sortAndFilterPage.waitForClothesPage();
    sortAndFilterPage.scrollToShortSleeves();
    sortAndFilterPage.clickColorWhite();
    sortAndFilterPage.waitForAnyPageExceptClothes();
}

@Test
void clothesFilterByColoBlack() {
    SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
    sortAndFilterPage.clickClothesCategory();
    sortAndFilterPage.waitForClothesPage();
    sortAndFilterPage.scrollToShortSleeves();
    sortAndFilterPage.clickColorBlack();
    sortAndFilterPage.waitForAnyPageExceptClothes();
}

@Test
void clothesFilterByLongSleeves() {
    SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
    sortAndFilterPage.clickClothesCategory();
    sortAndFilterPage.waitForClothesPage();
    sortAndFilterPage.scrollToShortSleeves();
    sortAndFilterPage.clickPropertyLongSleeves();
    sortAndFilterPage.waitForAnyPageExceptClothes();
}

@Test
void clothesFilterByShortSleeves() {
    SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
    sortAndFilterPage.clickClothesCategory();
    sortAndFilterPage.waitForClothesPage();
    sortAndFilterPage.scrollToShortSleeves();
    sortAndFilterPage.clickPropertyShortSleeves();
    sortAndFilterPage.waitForAnyPageExceptClothes();
}


// Sort and filter accessories

// Sort accessories by

@Test
void sortByAccessories() throws InterruptedException {
    SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
    sortAndFilterPage.clickAccessoriesCategory();
    sortAndFilterPage.waitForAccessoriesPage();


    // Sort by sales
    sortAndFilterPage.scrollToSortBy();
    sortAndFilterPage.scrollDown();
    sortAndFilterPage.clickSortBy();
    sortAndFilterPage.sortBySales();
    //Assertion needed


    // Sort by relevance
    sortAndFilterPage.waitForAnyPageExceptAccessories();
    sortAndFilterPage.scrollToSortBy();
    sortAndFilterPage.scrollDown();
    sortAndFilterPage.clickSortBy();
    sortAndFilterPage.sortByRelevance();
    //Assertion needed

    // Sort by name A to Z
    sortAndFilterPage.waitForAnyPageExceptAccessories();
    sortAndFilterPage.scrollToSortBy();
    sortAndFilterPage.scrollDown();
    sortAndFilterPage.clickSortBy();
    sortAndFilterPage.sortByNameAtoZ();
    //Assertion needed

    // Sort by name Z to A
    sortAndFilterPage.waitForAnyPageExceptAccessories();
    sortAndFilterPage.scrollToSortBy();
    sortAndFilterPage.scrollDown();
    sortAndFilterPage.clickSortBy();
    sortAndFilterPage.sortByNameZtoA();
    //Assertion needed

    // Sort by price low to high
    sortAndFilterPage.waitForAnyPageExceptAccessories();
    sortAndFilterPage.scrollToSortBy();
    sortAndFilterPage.scrollDown();
    sortAndFilterPage.clickSortBy();
    sortAndFilterPage.sortByPriceLowToHigh();
    //Assertion needed

    // Sort by price high to low
    sortAndFilterPage.waitForAnyPageExceptAccessories();
    sortAndFilterPage.scrollToSortBy();
    sortAndFilterPage.scrollDown();
    sortAndFilterPage.clickSortBy();
    sortAndFilterPage.sortByPriceHighToLow();
    //Assertion needed

    // Sort by reference A to Z
    sortAndFilterPage.waitForAnyPageExceptAccessories();
    sortAndFilterPage.scrollToSortBy();
    sortAndFilterPage.scrollDown();
    sortAndFilterPage.clickSortBy();
    sortAndFilterPage.sortByReferenceAtoZ();
    //Assertion needed

    // Sort by reference Z to A
    sortAndFilterPage.waitForAnyPageExceptAccessories();
    sortAndFilterPage.scrollToSortBy();
    sortAndFilterPage.scrollDown();
    sortAndFilterPage.clickSortBy();
    sortAndFilterPage.sortByReferenceZtoA();
    //Assertion needed

}

@Test
void sortByArt() throws InterruptedException {
    SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
    sortAndFilterPage.clickArtCategory();
    sortAndFilterPage.waitForArtPage();


    // Sort by sales
    sortAndFilterPage.waitForSortBy();
    sortAndFilterPage.scrollToSortBy();
    sortAndFilterPage.scrollDown();
    sortAndFilterPage.clickSortBy();
    sortAndFilterPage.sortBySales();
    //Assertion needed

    // Sort by relevance
    sortAndFilterPage.waitForSortBy();
    sortAndFilterPage.scrollToSortBy();
    sortAndFilterPage.waitForSortBy();
    sortAndFilterPage.scrollToSortBy();
    sortAndFilterPage.scrollDown();
    sortAndFilterPage.clickSortBy();
    sortAndFilterPage.sortByRelevance();
    //Assertion needed

    // Sort by name A to Z
    sortAndFilterPage.waitForSortBy();
    sortAndFilterPage.scrollToSortBy();
    sortAndFilterPage.scrollDown();
    sortAndFilterPage.clickSortBy();
    sortAndFilterPage.sortByNameAtoZ();

    // Sort by name Z to A
    sortAndFilterPage.waitForSortBy();
    sortAndFilterPage.scrollToSortBy();
    sortAndFilterPage.scrollDown();
    sortAndFilterPage.clickSortBy();
    sortAndFilterPage.sortByNameZtoA();
    //Assertion needed

    // Sort by price low to high
    sortAndFilterPage.waitForSortBy();
    sortAndFilterPage.scrollToSortBy();
    sortAndFilterPage.scrollDown();
    sortAndFilterPage.clickSortBy();
    sortAndFilterPage.sortByPriceLowToHigh();
    //Assertion needed

    // Sort by price high to low
    sortAndFilterPage.waitForSortBy();
    sortAndFilterPage.scrollToSortBy();
    sortAndFilterPage.scrollDown();
    sortAndFilterPage.clickSortBy();
    sortAndFilterPage.sortByPriceHighToLow();
    //Assertion needed

    // Sort by reference A to Z
    sortAndFilterPage.waitForSortBy();
    sortAndFilterPage.scrollToSortBy();
    sortAndFilterPage.scrollDown();
    sortAndFilterPage.clickSortBy();
    sortAndFilterPage.sortByReferenceAtoZ();
    //Assertion needed

    // Sort by reference Z to A
    sortAndFilterPage.waitForSortBy();
    sortAndFilterPage.scrollToSortBy();
    sortAndFilterPage.scrollDown();
    sortAndFilterPage.clickSortBy();
    sortAndFilterPage.sortByReferenceZtoA();
    //Assertion needed

}
}
