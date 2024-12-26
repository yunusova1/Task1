module com.example.decorations {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.decorations to javafx.fxml;
    exports com.example.decorations;
}