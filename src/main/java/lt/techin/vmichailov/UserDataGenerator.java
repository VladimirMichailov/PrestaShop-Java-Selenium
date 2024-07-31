package lt.techin.vmichailov;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class UserDataGenerator {
    private static String randomEmail;
    private static String randomPassword;
    private static String randomFirstName;
    private static String randomSecondName;

    private static String[] firstNames = {"Al", "Apu", "Bruce", "Bryce", "Bronny", "Cessar", "Kyle", "Demar", "Kylie", "Kyrie",
            "Magic", "Mose", "John", "Jane", "Alice", "Bob", "Mike", "James", "Alex", "Pete",
            "Xavier", "Paul", "Anthony", "Larry",
            "Sarah", "Emily", "Jessica", "Matthew", "David", "Daniel", "Michael", "Christopher",
            "Joshua", "Andrew", "Joseph", "Ethan", "Ryan", "Nicholas", "Benjamin", "Samuel",
            "Tyler", "Alexander", "Jacob", "William", "Emma", "Olivia", "Sophia", "Isabella",
            "Mia", "Charlotte", "Amelia", "Harper", "Evelyn", "Abigail", "Ella", "Avery"};

    private static String[] lastNames = {
            "Doe", "Smith", "Johnson", "Williams", "Harden", "Davis", "Castle", "Evans", "Rivers", "Sumner",
            "Wallace",
            "Brown", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson",
            "Garcia", "Martinez", "Robinson", "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall",
            "Allen", "Young", "King", "Wright", "Scott", "Green", "Baker", "Adams", "Nelson", "Carter",
            "Mitchell", "Perez", "Roberts", "Turner", "Phillips", "Campbell", "Parker", "Edwards", "Collins"};

    public static String getRandomFirstName() {
        Random random = new Random();
        return firstNames[random.nextInt(firstNames.length)];
    }

    public static String getRandomSecondName() {
        Random random = new Random();
        return lastNames[random.nextInt(lastNames.length)];
    }

    public static String generateRandomEmail(String firstName, String lastName){
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@mail.com";
    }

    public static String generateRandomPassword(){
        return RandomStringUtils.randomAlphanumeric(8) + "Aa1";
    }
    public static void generateUserData() {
        randomFirstName = getRandomFirstName();
        randomSecondName = getRandomSecondName();
        randomEmail = generateRandomEmail(randomFirstName, randomSecondName);
        randomPassword = generateRandomPassword();
    }

    public static String getEmail() {
        return randomEmail;
    }

    public static String getPassword() {
        return randomPassword;
    }

    public static String getFirstName() {
        return randomFirstName;
    }

    public static String getLastName() {
        return randomSecondName;
    }

}
