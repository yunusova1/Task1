package com.example.fabric;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Pentagon extends Shape {
    // Конструктор класса Pentagon, принимающий цвет
    public Pentagon(Color color) {
        super(color);
    }
    // draw для рисования пятиугольника
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color); //цветзаливки
        // Массивы координат x и y для вершин пятиугольника
        double[] x = {150, 180, 210, 180, 120};
        double[] y = {50, 100, 150, 200, 200};
        // Рисование пятиугольника на графическом контексте
        gc.fillPolygon(x, y, 5); // Метод fillPolygon принимает массивы координат и количество вершин
    }
    @Override
    public String descriptor() {
        return "Пятиугольник";
    }
}
