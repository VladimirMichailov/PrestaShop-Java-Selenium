package lt.techin.vmichailov;

import java.util.Random;

public class ItemData {
    private static String randomValidItem;
    private static String randomInValidItem;
    private static String[] validSearches = {"Bear", "Brown", "Notebook", "Vector", "Hummingbird", "Mug", "Cushion", "Fox", "Sweater", "Graphics"};
    private static String[] inValidSearches = {"Kava", "Duona", "Svietas", "Grikiai", "Mesa", "Akiniai", "Gaga", "Baba", "Nana", "Abvgd", "Klmnj", "Oprst", "Numeris"};

    public static String getRandomValidItem() {
        Random random = new Random();
        randomValidItem = validSearches[random.nextInt(validSearches.length)];
        return randomValidItem;
    }
    public static String getRandomInValidItem() {
        Random random = new Random();
        randomInValidItem = inValidSearches[random.nextInt(inValidSearches.length)];
        return randomInValidItem;
    }

    public static void searchData() {
        randomValidItem = getRandomValidItem();
        randomInValidItem = getRandomInValidItem();
    }
    public static String getValidItem() {
        return randomValidItem;
    }
    public static String getInValidItem() {
        return randomInValidItem;
    }



}
