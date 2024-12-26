package com.example.keeper;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
public class Momento {
    private Shape shape;
    private double width;
    private Color color;
//сделать снимок
    public Momento(Shape state) {
        this.shape = state;
        width = shape.getStrokeWidth();
        color = (Color) shape.getStroke();
    }
}