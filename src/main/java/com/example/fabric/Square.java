package com.example.fabric;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Square extends Shape {
    // Конструктор класса Square, принимающий цвет фигуры
    public Square(Color color) {
        super(color);
    }
    // рисование квадрата
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color); //цвет заливки для квадрата
        gc.fillRect(100, 100, 100, 100); // Рисование квадрата с координатами
    }
    @Override
    public String descriptor() {
        return "Квадрат";
    }
}
