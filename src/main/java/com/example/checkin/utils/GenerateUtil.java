package com.example.checkin.utils;

import java.security.SecureRandom;

public class GenerateUtil {
    public static String generateNumber(int size) {
        // ASCII range – alphanumeric (0-9, a-z, A-Z)
        final String chars = "0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        // each iteration of the loop randomly chooses a character from the given
        // ASCII range and appends it to the `StringBuilder` instance

        for (int i = 0; i < size; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }
}
