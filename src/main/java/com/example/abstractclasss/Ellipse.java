package com.example.abstractclasss;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Ellipse extends Shape {
    double radiusX;
    double radiusY;
    // Конструктор
    public Ellipse(Color fillColor, Color strokeColor, double x, double y, double size) {
        super(fillColor, strokeColor, x, y, size);
        this.radiusX = size;
        this.radiusY = size;
    }
    //вычисления площади эллипса
    double area() {
        return Math.PI * this.radiusX * this.radiusY;
    }
    public String toString() {
        return "Эллипс, площадь : " + this.area();
    }
    void draw(GraphicsContext gr) {
        gr.setFill(this.fillColor);
        gr.setStroke(this.strokeColor);
        gr.fillOval(this.x, this.y, this.radiusX, this.radiusY);
        gr.strokeOval(this.x, this.y, this.radiusX, this.radiusY);
    }
}
