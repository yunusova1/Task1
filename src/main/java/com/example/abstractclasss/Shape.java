package com.example.abstractclasss;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
// Абстрактный класс Shape
public abstract class Shape {
    protected Color fillColor;
    protected Color strokeColor;
    protected double x;
    protected double y;
    protected double size;
    // Конструктор
    public Shape(Color fillColor, Color strokeColor, double x, double y, double size) {
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.x = x;
        this.y = y;
        this.size = size;
    }
    abstract double area();
    abstract void draw(GraphicsContext var1);
}
