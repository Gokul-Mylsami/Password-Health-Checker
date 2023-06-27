module com.example.passwordstrength {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.passwordstrength to javafx.fxml;
    exports com.example.passwordstrength;
}