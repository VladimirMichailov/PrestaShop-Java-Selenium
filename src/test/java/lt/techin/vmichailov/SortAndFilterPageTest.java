package lt.techin.vmichailov;

import org.junit.jupiter.api.Test;

public class SortAndFilterPageTest extends BaseTest {

    // Sort and filter clothes

    // Clothes sort by

    @Test
    void sortByClothes() throws InterruptedException {
        SortAndFilterPage sortAndFilterPage = new SortAndFilterPage(driver);
        sortAndFilterPage.clickClothesCategory();
        sortAndFilterPage.waitForClothesPage();


        // Sort by sales
        //sortAndFilterPage.waitForSortBy();
        sortAndFilterPage.scrollToSortBy();
        sortAndFilterPage.scrollDown();
        sortAndFilterPage.clickSortBy();
        sortAndFilterPage.sortBySales();
        //Assertion needed


        // Sort by relevance
        //sortAndFilterPage.waitForSortBy();
        sortAndFilterPage.waitForAnyPageExceptClothes();
        sortAndFilterPage.scrollToSortBy();
        sortAndFilterPage.scrollDown();
        sortAndFilterPage.clickSortBy();
        sortAndFilterPage.sortByRelevance();
        //Assertion needed

        // Sort by name A to Z
        //sortAndFilterPage.waitForSortBy();
        sortAndFilterPage.waitForAnyPageExceptClothes();
        sortAndFilterPage.scrollToSortBy();
        sortAndFilterPage.scrollDown();
        sortAndFilterPage.clickSortBy();
        sortAndFilterPage.sortByNameAtoZ();
        //Assertion needed

        // Sort by name Z to A
        //sortAndFilterPage.waitForSortBy();
        sortAndFilterPage.waitForAnyPageExceptClothes();
        sortAndFilterPage.scrollToSortBy();
        sortAndFilterPage.scrollDown();
        sortAndFilterPage.clickSortBy();
        sortAndFilterPage.sortByNameZtoA();
        //Assertion needed

        // Sort by price low to high
        //sortAndFilterPage.waitForSortBy();
        sortAndFilterPage.waitForAnyPageExceptClothes();
        sortAndFilterPage.scrollToSortBy();
        sortAndFilterPage.scrollDown();
        sortAndFilterPage.clickSortBy();
        sortAndFilterPage.sortByPriceLowToHigh();
        //Assertion needed

        // Sort by price high to low
        //sortAndFilterPage.waitForSortBy();
        sortAndFilterPage.waitForAnyPageExceptClothes();
        sortAndFilterPage.scrollToSortBy();
        sortAndFilterPage.scrollDown();
        sortAndFilterPage.clickSortBy();
        sortAndFilterPage.sortByPriceHighToLow();
        //Assertion needed

        // Sort by reference A to Z
        //sortAndFilterPage.waitForSortBy();
        sortAndFilterPage.waitForAnyPageExceptClothes();
        sortAndFilterPage.scrollToSortBy();
        sortAndFilterPage.scrollDown();
        sortAndFilterPage.clickSortBy();
        sortAndFilterPage.sortByReferenceAtoZ();
        //Assertion needed

        // Sort by reference Z to A
        //sortAndFilterPage.waitForSortBy();
        sortAndFilterPage.waitForAnyPageExceptClothes();
        sortAndFilterPage.scrollToSortBy();
        sortAndFilterPage.scrollDown();
        sortAndFilterPage.clickSortBy();
        sortAndFilterPage.sortByReferenceZtoA();
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
    }@Test
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
