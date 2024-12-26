package com.example.abstractclasss;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class HelloApplication extends Application {
    // Конструктор
    public HelloApplication() {
    }
    //запуске приложения
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
        Scene scene = new Scene((Parent)fxmlLoader.load(), 1000.0, 500.0);
        stage.setTitle("Рисование фигур");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(new String[0]);
    }
}
