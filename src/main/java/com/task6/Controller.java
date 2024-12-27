package com.task6;

import com.task6.module.Figuri;
import com.task6.module.TrUg;
import com.task6.module.krug;
import com.task6.module.PrUg;
import com.task6.module.kvadr;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ListView<Figuri> listView;
    @FXML
    private Canvas canvas;
    @FXML
    private ColorPicker colorPicker;
    private ObservableList<Figuri> content;
    private GraphicsContext gc;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        krug circle = new krug();
        PrUg rectangle = new PrUg();
        TrUg triangle = new TrUg();
        kvadr square = new kvadr(50);
        content = FXCollections.observableArrayList(circle, rectangle, triangle, square);
        listView.setItems(content);
        gc = canvas.getGraphicsContext2D();
        drawCanvasBorder();
    }

    private void drawCanvasBorder() {
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    @FXML
    public void drawShape(MouseEvent mouseEvent) {
        int index = listView.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            Figuri shape = (Figuri) content.get(index).clone();
            shape.setColor(colorPicker.getValue());
            shape.draw(gc, mouseEvent.getX(), mouseEvent.getY());
        }
    }
}
