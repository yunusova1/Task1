package com.example.decorations;


import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Girlands extends TreeDecorator {

    public Circle[] circle = new Circle[9];

    public Girlands(ChristmasTree tree){
        super(tree);
    }

    @Override
    public void draw(Pane pane) {
        super.draw(pane);
        drawWithGirlands(pane);
    }

    private void drawWithGirlands(Pane pane){
        FadeTransition[] ft = new FadeTransition[9];

        circle[0] = new Circle(210, 220, 8, Color.RED);
        circle[1] = new Circle(270, 220, 8, Color.BLUE);
        circle[2] = new Circle(240, 150, 8, Color.YELLOW);
        circle[3] = new Circle(180, 280, 8, Color.PINK);
        circle[4] = new Circle(240, 280, 8, Color.ORANGE);
        circle[5] = new Circle(300, 280, 8, Color.WHITE);
        circle[6] = new Circle(145, 340, 8, Color.GOLD);
        circle[7] = new Circle(240, 340, 8, Color.PURPLE);
        circle[8] = new Circle(335, 340, 8, Color.SALMON);
        for (int i = 0; i < ft.length; i++){
            ft[i] = new FadeTransition(Duration.millis(1000), circle[i]);
            ft[i].setFromValue(1.0);
            ft[i].setToValue(0.0);
            ft[i].setCycleCount(Timeline.INDEFINITE);
            ft[i].setAutoReverse(true);
            ft[i].play();
        }
        pane.getChildren().addAll(circle);
    }
}
