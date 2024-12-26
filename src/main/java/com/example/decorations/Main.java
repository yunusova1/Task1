package com.example.decorations;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color; // Импортируем Color
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("christmasTree.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 600);

        // Устанавливаем цвет фона для сцены
        scene.setFill(Color.BLUE); // Устанавливаем голубой цвет фона

        stage.setTitle("Декоратор");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
