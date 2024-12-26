package com.example.abstractclasss;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class RoundedRectangle extends Shape {
    double length;
    double width;
    double arcWidth;
    double arcHeight; // скругление углов
    // Конструктор
    public RoundedRectangle(Color fillColor, Color strokeColor, double x, double y, double size) {
        super(fillColor, strokeColor, x, y, size);
        this.length = size;
        this.width = size;
        this.arcWidth = size / 2.0;
        this.arcHeight = size / 2.0;
    }
    double area() {
        return this.length * this.width;
    }
    public String toString() {
        return "Скругленный прямоугольник, площадь : " + this.area();
    }
    void draw(GraphicsContext gr) {
        gr.setFill(this.fillColor);
        gr.setStroke(this.strokeColor);
        gr.fillRoundRect(this.x, this.y, this.length, this.width, this.arcWidth, this.arcHeight);
        gr.strokeRoundRect(this.x, this.y, this.length, this.width, this.arcWidth, this.arcHeight);
    }
}
