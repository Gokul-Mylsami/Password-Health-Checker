package com.example.passwordstrength;

import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_-+=~<>?";

    public static String generatePassword(int length) {
        String validChars = UPPER + LOWER + NUMBERS + SPECIAL_CHARACTERS;
        SecureRandom random = new SecureRandom();
        char[] password = new char[length];

        // Generate the first character as a letter
        int index = random.nextInt(UPPER.length());
        password[0] = UPPER.charAt(index);

        // Generate the remaining characters
        for (int i = 1; i < length; i++) {
            index = random.nextInt(validChars.length());
            password[i] = validChars.charAt(index);
        }

        return new String(password);
    }

    public static void main(String[] args) {
        int numPasswords = 50000;
        int passwordLength = 12;

        try (FileWriter writer = new FileWriter("passwords.txt")) {
            for (int i = 0; i < numPasswords; i++) {
                String generatedPassword = generatePassword(passwordLength);
                writer.write(generatedPassword);
                writer.write(System.lineSeparator());
            }
            System.out.println("Passwords written to passwords.txt successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while writing passwords to the file.");
            e.printStackTrace();
        }
    }
}