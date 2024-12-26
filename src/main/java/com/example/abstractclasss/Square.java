package com.example.abstractclasss;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Square extends Shape {
    double side;
    // Конструктор квадрата
    public Square(Color fillColor, Color strokeColor, double x, double y, double size) {
        super(fillColor, strokeColor, x, y, size);
        this.side = size;
    }
    double area() {
        return this.side * this.side;
    }
    public String toString() {
        return "Квадрат, площадь: " + this.area();
    }
    void draw(GraphicsContext gr) {
        gr.setFill(this.fillColor);
        gr.setStroke(this.strokeColor);
        gr.fillRect(this.x, this.y, this.side, this.side);
        gr.strokeRect(this.x, this.y, this.side, this.side);
    }
}
