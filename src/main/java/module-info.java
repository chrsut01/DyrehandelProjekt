module com.example.dyrehandelprojekt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dyrehandelprojekt to javafx.fxml;
    exports com.example.dyrehandelprojekt;
}