package lt.techin.vmichailov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortAndFilterPageTest extends  BaseTest{



    @Test
    void sortByClothes() throws InterruptedException {
        SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
        sortAndFilterPage.clickClothesCategory();
        sortAndFilterPage.waitForClothesPage();


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
        //Assertion needed

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

    @Test
    void sortByAccessories() throws InterruptedException {
        SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
        sortAndFilterPage.clickAccessoriesCategory();
        sortAndFilterPage.waitForAccessoriesPage();


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
        //Assertion needed

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
