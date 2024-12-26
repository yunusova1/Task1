package com.example.decorations;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public Pane paneTree;

    @FXML
    private RadioButton girlandsRadioButton;
    @FXML
    private RadioButton presentsRadioButton;
    @FXML
    private RadioButton starRadioButton;
    @FXML
    private Label statusLabel;

    private ChristmasTree tree;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tree = new ChristmasTreeImpl();
        tree.draw(paneTree);
        updateStatus();
    }

    public void addLights(ActionEvent actionEvent) {
        if (girlandsRadioButton.isSelected()) {
            tree = new Girlands(tree); // Обновляем ссылку на tree
            tree.draw(paneTree);
            updateStatus();
        }
    }

    public void addPresents(ActionEvent actionEvent) {
        if (presentsRadioButton.isSelected()) {
            tree = new Presents(tree); // Обновляем ссылку на tree
            tree.draw(paneTree);
            updateStatus();
        }
    }

    public void addStar(ActionEvent actionEvent) {
        if (starRadioButton.isSelected()) {
            tree = new Star(tree); // Обновляем ссылку на tree
            tree.draw(paneTree);
            updateStatus();
        }
    }

    public void addAllDecorations(ActionEvent actionEvent) {
        girlandsRadioButton.setSelected(true);
        presentsRadioButton.setSelected(true);
        starRadioButton.setSelected(true);
        addLights(actionEvent);
        addPresents(actionEvent);
        addStar(actionEvent);
    }

    public void removeAllDecorations(ActionEvent actionEvent) {
        girlandsRadioButton.setSelected(false);
        presentsRadioButton.setSelected(false);
        starRadioButton.setSelected(false);
        paneTree.getChildren().clear(); // Очищаем только содержимое
        tree = new ChristmasTreeImpl(); // Сбрасываем ссылку на базовую елку
        tree.draw(paneTree); // Рисуем только елку
        updateStatus();
    }

    private void updateStatus() {
        StringBuilder status = new StringBuilder("Декор: Елка");
        float totalCost = tree.cost();

        if (girlandsRadioButton.isSelected()) {
            status.append(", Гирлянда");
            totalCost += 210; // стоимость гирлянды
        }
        if (presentsRadioButton.isSelected()) {
            status.append(", Подарки");
            totalCost += 2500; // стоимость подарков
        }
        if (starRadioButton.isSelected()) {
            status.append(", Звезда");
            totalCost += 150; // стоимость звезды
        }

        statusLabel.setText(status.toString() + " | Общая стоимость: " + totalCost);
    }
}