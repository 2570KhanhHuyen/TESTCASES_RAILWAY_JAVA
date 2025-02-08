package Common.Common;

import java.util.UUID;

public class RandomEmail {
    public static String generateRandomEmail() {
        String randomString = UUID.randomUUID().toString().substring(0, 8);
        return randomString + "@gmail.com";
    }
    public static void main(String[] args) {
        String randomEmail = generateRandomEmail();
        System.out.println("Random Email: " + randomEmail);
    }
}
