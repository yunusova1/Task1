package com.task6.module;

import javafx.scene.canvas.GraphicsContext;

public class PrUg extends Figuri {
    private static final double WIDTH = 150;
    private static final double HEIGHT = 100;

    @Override
    public void draw(GraphicsContext gc, double x, double y) {
        gc.setFill(color);
        gc.fillRect(x - WIDTH / 2, y - HEIGHT / 2, WIDTH, HEIGHT);
    }

    @Override
    public String toString() {
        return "Прямоугольник";
    }
}