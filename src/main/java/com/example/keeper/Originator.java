package com.example.keeper;
import javafx.scene.shape.Shape;
public class Originator {
    private Shape shape;
    // Установка фигуры
    public void setShape(Shape shape) {
        this.shape = shape;
    }
    // Создание снимка (Memento)
    public Momento createMomento() {
        return new Momento(shape);
    }
    // Восстановление состояния из Memento

}