package com.example.fabric;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Straight extends Shape {
    // Конструктор класса Straight, принимающий цвет линии
    public Straight(Color color) {
        super(color);
    }
    //метода draw() для рисования отрезка на графическом контексте
    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(color); // цвета обводки
        gc.setLineWidth(2); // Установка ширины линии
        gc.strokeLine(50, 100, 250, 100); // Рисование отрезка
    }

    // метод descriptor() для возвращения описания объекта
    @Override
    public String descriptor() {
        return "Отрезок";
    }
}
