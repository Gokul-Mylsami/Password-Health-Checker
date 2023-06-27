package com.example.passwordstrength;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.paint.Color;

public class HelloController {

    PasswordHeathCheck passwordHeathCheck = new PasswordHeathCheck();

    @FXML
    protected Label passwordHealth;

    @FXML
    protected Label uniquePassword;
    @FXML
    protected Label passwordLengthCheck;
    @FXML
    protected Label startWithCharacter;
    @FXML
    protected Label containSpecialCharacter;
    @FXML
    protected Label containCapitalCharacter;
    @FXML
    protected Label containNumber;

    @FXML
    protected PasswordField passwordField;

    @FXML
    protected void onPasswordType() {
        String password = passwordField.getText();
        helper(password);
    }

    @FXML
    protected void submitPassword() {
        String password = passwordField.getText();
        if (passwordHeathCheck.isUnique(password) && password.length()>0) {
            setColorGreen(uniquePassword, "Unique Password");
        } else {
            setColorRed(uniquePassword, "Not Unique Password");
        }
    }

    protected void helper(String password) {
        String name = "Above 12 Characters";
        if (passwordHeathCheck.checkPasswordLength(password)) {
            setColorGreen(passwordLengthCheck, name);
        } else {
            setColorRed(passwordLengthCheck, name);
        }

        name = "Start with Char";
        if (passwordHeathCheck.startWithChar(password)) {
            setColorGreen(startWithCharacter, name);
        } else {
            setColorRed(startWithCharacter, name);
        }

        name = "Contain Special Character";
        if (passwordHeathCheck.containSpecialCharacter(password)) {
            setColorGreen(containSpecialCharacter, name);
        } else {
            setColorRed(containSpecialCharacter, name);
        }

        name = "Contain Capital Character";
        if (passwordHeathCheck.containsCapitalLetter(password)) {
            setColorGreen(containCapitalCharacter, name);
        } else {
            setColorRed(containCapitalCharacter, name);
        }

        name = "Contain Number";
        if (passwordHeathCheck.containsNumber(password)) {
            setColorGreen(containNumber, name);
        } else {
            setColorRed(containNumber, name);
        }

        int health = passwordHeathCheck.passwordHealth(password);
        if (health == 100) {
            setColorGreen(passwordHealth, "Password Strength: " + health + "%");
        } else if (health >= 50) {
            setColorYellow(passwordHealth, "Password Strength: " + health + "%");
        } else {
            setColorRed(passwordHealth, "Password Strength: " + health + "%");
        }
    }

    protected void setColorGreen(Label label, String text) {
        label.setText("✅ " + text);
        label.setTextFill(Color.web("#37b24d"));
    }

    protected void setColorRed(Label label, String text) {
        label.setText("❌ " + text);
        label.setTextFill(Color.web("#fa5252"));
    }

    protected void setColorYellow(Label label, String text) {
        label.setText("⚠️ " + text);
        label.setTextFill(Color.web("#f08c00"));
    }
}