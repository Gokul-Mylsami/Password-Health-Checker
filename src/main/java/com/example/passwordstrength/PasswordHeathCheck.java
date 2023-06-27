package com.example.passwordstrength;

import java.io.FileNotFoundException;

public class PasswordHeathCheck {

    protected boolean validatePassword(String password) {
        return checkPasswordLength(password);
    }

    protected int passwordHealth(String password) {
        int health = 0;
        if (checkPasswordLength(password))
            health += 20;
        if (startWithChar(password))
            health += 20;
        if (containSpecialCharacter(password))
            health += 20;
        if (containsCapitalLetter(password))
            health += 20;
        if (containsNumber(password))
            health += 20;
        return health;
    }

    protected boolean checkPasswordLength(String password) {
        if (password.length() == 0)
            return false;
        return password.length() >= 12;
    }

    protected boolean startWithChar(String password) {
        if (password.length() == 0)
            return false;
        return Character.isAlphabetic(password.charAt(0));
    }

    protected boolean containSpecialCharacter(String password) {
        if (password.length() == 0)
            return false;
        return password.matches(".*[,.!@#$%^&*()_+=|<>?{}\\[\\]~-].*");
    }

    protected boolean containsCapitalLetter(String password) {
        if (password.length() == 0)
            return false;
        return password.matches(".*[A-Z].*");
    }

    protected boolean containsNumber(String password) {
        if (password.length() == 0)
            return false;
        return password.matches(".*[0-9].*");
    }

    protected boolean isUnique(String s) {
        try {
            java.io.File myObj = new java.io.File("passwords.txt");
            java.util.Scanner myReader = new java.util.Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.equals(s)) {
                    myReader.close();
                    return false;
                }
            }
            myReader.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return true;
        }
    }
}
