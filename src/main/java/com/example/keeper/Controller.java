package com.example.keeper;import javafx.fxml.FXML;
import javafx.scene.layout.Pane;import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.input.MouseEvent;import java.util.ArrayList;
import java.util.List;
public class Controller {
    @FXML    private Pane drawingPanel;
    private double initialX;
    private double initialY;
    private double mouseX;
    private double mouseY;
    private List<Shape> picture;
    private List<Shape> selectedShapes;
    private Caretaker caretaker;
    private Originator originator = new Originator();
    public void initialize() {
        caretaker = new Caretaker();
        picture = new ArrayList<>();
        selectedShapes = new ArrayList<>();
    }
    @FXML
    public void addCircle() {
        Circle circle2 = new Circle(100, 100, 100, Color.GHOSTWHITE);
        circle2.setStroke(Color.PALEGREEN);
        circle2.setStrokeWidth(3.0);
        addShape(circle2);    }
    @FXML
    public void addSquare() {
        Rectangle square = new Rectangle(200, 200, 200, 200); // Квадрат со стороной 50
        square.setFill(Color.DARKMAGENTA);
        square.setStroke(Color.BLUE);
        square.setStrokeWidth(3.0);
        addShape(square);
    }
    @FXML
    public void addDiamond() {
        Polygon diamond = new Polygon();
        diamond.getPoints().addAll(200.0, 0.0, 200.0, 200.0, 200.0, 200.0, 0.0, 200.0); // Ромб
        diamond.setFill(Color.GREEN);
        diamond.setStroke(Color.BLACK);
        diamond.setStrokeWidth(3.0);
        addShape(diamond);
    }
    @FXML
    public void addPentagon() {
        Polygon pentagon = new Polygon();
        pentagon.getPoints().addAll(70.0, 0.0, 160.0, 58.0, 92.0, 200.0,
                28.0, 180.0, 0.0, 58.0); // Пятиугольник
        pentagon.setFill(Color.VIOLET);
        pentagon.setStroke(Color.AQUA);
        pentagon.setStrokeWidth(3.0);
        addShape(pentagon);
    }@FXML
    public void addRectangle() {
        Rectangle rectangle = new Rectangle(200, 120, 200, 120);
        rectangle.setStroke(Color.ORANGE);
        rectangle.setFill(Color.YELLOWGREEN);
        rectangle.setStrokeWidth(3.0);
        addShape(rectangle);    }
    @FXML
    public void addEllipse() {
        Ellipse ellipse = new Ellipse(150, 60); // Радиус по оси X и Y
        ellipse.setFill(Color.FUCHSIA);
        ellipse.setStroke(Color.YELLOW);
        ellipse.setStrokeWidth(3.0);
        addShape(ellipse);
    }
    @FXML
    public void addTriangle() {
        Polygon triangle = new Polygon(150, 150, 150);
        triangle.getPoints().addAll(250.0, 0.0, 0.0, 150.0, 100.0, 250.0);
        triangle.setFill(Color.MAROON);
        triangle.setStroke(Color.HOTPINK);
        triangle.setStrokeWidth(3.0);
        addShape(triangle);    }
    @FXML
    public void addParallelogram() {
        Polygon parallelogram = new Polygon();
        parallelogram.getPoints().addAll(60.0, 0.0, 180.0, 0.0, 130.0, 80.0, 0.0, 80.0);
        parallelogram.setFill(Color.ROSYBROWN);
        parallelogram.setStroke(Color.PEACHPUFF);
        parallelogram.setStrokeWidth(3.0);
        addShape(parallelogram);
    }    @FXML
    public void addHexagon() {
        Polygon hexagon = new Polygon(
                400.0, 0.0, 480.0, 80.0, 480.0, 160.0, 400.0, 240.0, 320.0, 160.0, 320.0, 80.0);
        hexagon.setFill(Color.DARKGOLDENROD);
        hexagon.setStroke(Color.CHOCOLATE);
        hexagon.setStrokeWidth(3.0);
        addShape(hexagon);    }
    private void addShape(Shape shape) {
        picture.add(shape);
        drawingPanel.getChildren().add(shape);
        shape.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> handleShapePress(shape, event));
        shape.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::onDrag);
        shape.addEventHandler(MouseEvent.MOUSE_RELEASED, this::onEnd);
    }    private void handleShapePress(Shape shape, MouseEvent event) {
        originator.setShape(shape);
        caretaker.push(originator.createMomento());
        if (event.isControlDown()) {
            if (selectedShapes.contains(shape)) {
                selectedShapes.remove(shape);
                shape.setStroke(null);
            }
            else {
                selectedShapes.add(shape);
                shape.setStroke(Color.RED);
            }
        }
        else {
            selectedShapes.clear();
            selectedShapes.add(shape);
            shape.setStroke(Color.RED);
        }
        initialX = shape.getLayoutX();
        initialY = shape.getLayoutY();
        mouseX = event.getSceneX();
        mouseY = event.getSceneY();
    }    public void onDrag(MouseEvent mouseEvent) {
        if (!selectedShapes.isEmpty()) {
            double offsetX = mouseEvent.getSceneX() - mouseX;
            double offsetY = mouseEvent.getSceneY() - mouseY;
            for (Shape shape : selectedShapes) {
                shape.setLayoutX(initialX + offsetX);
                shape.setLayoutY(initialY + offsetY);
            }
        }
    }
    public void onEnd(MouseEvent mouseEvent) {
        if (!selectedShapes.isEmpty()) {
        initialX = selectedShapes.get(0).getLayoutX();
        initialY =selectedShapes.get(0).getLayoutY();
        mouseX = mouseEvent.getSceneX();
        mouseY = mouseEvent.getSceneY();
    }
    }
    @FXML    public void removeLastShape() {
        if (!picture.isEmpty()) {
            Shape lastShape = picture.remove(picture.size() - 1);
            drawingPanel.getChildren().remove(lastShape);
        }
    }
}