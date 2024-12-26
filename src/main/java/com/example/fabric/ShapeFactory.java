package com.example.fabric;
import javafx.scene.paint.Color;
public class ShapeFactory {
    // Метод createPolygon, который создает фигуру в зависимости от количества сторон
    public Shape createPolygon(int numberOfSides, Color color) {
        // Проверка на количество сторон и создание соответствующей фигуры
        if (numberOfSides == 5) {
            return new Pentagon(color); // Создание и возврат объекта Pentagon с заданным цветом
        } else if (numberOfSides == 4) {
            return new Square(color); //Square
        } else if (numberOfSides == 3) {
            return new Triangle(color); // Triangle
        } else if (numberOfSides == 2) {
            return new Angle(color);
        } else if (numberOfSides == 1) {
            return new Straight(color);
        } else if (numberOfSides == 0) {
            return new Circle(color);
        } else {
            return null; // Возврат null, если количество сторон не соответствует ни одной фигуре
        }
    }
}
