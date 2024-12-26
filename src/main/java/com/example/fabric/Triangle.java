package com.example.fabric;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Triangle extends Shape {
    // Конструктор класса Triangle, принимающий цвет фигуры
    public Triangle(Color color) {
        super(color);
    }
    // draw() для рисования треугольника на графическом контексте
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color); //  цвет заливки для треугольника
        // Рисование треугольника с использованием метода fillPolygon()
        gc.fillPolygon(new double[]{100, 150, 200}, new double[]{100, 50, 100}, 3);
    }
    //descriptor() для возвращения описания объекта
    @Override
    public String descriptor() {
        return "Треугольник";
    }
}
