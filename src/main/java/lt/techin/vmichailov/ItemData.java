package lt.techin.vmichailov;

import java.util.Random;

public class ItemData {
    private static String randomValidItem;
    private static String randomInValidItem;
    private static String[] validSearches = {"Bear", "Brown", "Notebook", "Vector", "Hummingbird", "Mug", "Frame", "Cushion", "Fox", "Sweater", "Graphics", "Poster"};
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

    public static String getValidItem() {
        return randomValidItem;
    }
    public static String getInValidItem() {
        return randomInValidItem;
    }



}
