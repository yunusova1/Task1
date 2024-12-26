package com.example.abstractclasss;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Rectangle extends Shape {
    double length;
    double width;
    // Конструктор  прямоугольника
    public Rectangle(Color fillColor, Color strokeColor, double x, double y, double size) {
        super(fillColor, strokeColor, x, y, size);
        this.length = size;
        this.width = size;
    }
    //  вычисление площади прямоугольника
    double area() {
        return this.length * this.width;
    }
    public String toString() {
        return "Прямоугольник, площадь : " + this.area();
    }
    void draw(GraphicsContext gr) {
        gr.setFill(this.fillColor);
        gr.setStroke(this.strokeColor);
        gr.fillRect(this.x, this.y, this.length, this.width);
        gr.strokeRect(this.x, this.y, this.length, this.width);
    }
}