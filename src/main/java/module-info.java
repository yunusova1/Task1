module com.example.abstractclasss {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.abstractclasss to javafx.fxml;
    exports com.example.abstractclasss;
}