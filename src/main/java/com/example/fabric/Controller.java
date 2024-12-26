package com.example.fabric;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
public class Controller {
    @FXML
    private TextField sidesField;
    @FXML
    private MenuButton colorMenu;
    @FXML
    private Canvas canvas;
    @FXML
    private Label descriptionLabel;

    private ShapeFactory shapeFactory = new ShapeFactory();
    private Color selectedColor;

    public Controller() {
        this.selectedColor = Color.ORANGE; // Цвет по умолчанию
    }
    @FXML
    public void initialize() {
        // Создание элементов меню для выбора цвета
        String[] colorNames = {
                "Красный", "Зеленый", "Синий", "Оранжевый", "Черный", "Розовый",
                "Желтый", "Серый", "Голубой", "Белый", "Фиолетовый", "Коричневый",
                "Лаймовый", "Морская волна", "Темно-синий", "Темно-зеленый",
                "Темно-красный", "Салатовый", "Бежевый", "Персиковый",
                "Слоновая кость", "Лавандовый", "Бирюзовый", "Золотой",
                "Серебряный", "Хаки", "Малиновый", "Небесно-голубой",
                "Теплый серый", "Кремовый"
        };
        Color[] colors = {
                Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.BLACK, Color.PINK,
                Color.YELLOW, Color.GRAY, Color.LIGHTBLUE, Color.WHITE, Color.PURPLE, Color.BROWN,
                Color.LIME, Color.CYAN, Color.DARKBLUE, Color.DARKGREEN,
                Color.DARKRED, Color.LIGHTGREEN, Color.BEIGE, Color.PERU,
                Color.IVORY, Color.LAVENDER, Color.TURQUOISE, Color.GOLD,
                Color.SILVER, Color.DARKKHAKI, Color.MAROON, Color.SKYBLUE,
                Color.GRAY, Color.TEAL
        };

        // Добавление всех элементов в меню выбора цвета
        for (int i = 0; i < colorNames.length; i++) {
            MenuItem colorItem = new MenuItem(colorNames[i]);
            final Color color = colors[i];
            colorItem.setOnAction((e) -> { this.selectedColor = color; });
            this.colorMenu.getItems().add(colorItem);
        }
    }

    @FXML
    public void drawShape() {
        if (this.sidesField.getText().isEmpty()) {
            this.descriptionLabel.setText("Пожалуйста, введите количество сторон.");
        } else {
            int sides;
            try {
                sides = Integer.parseInt(this.sidesField.getText());
                if (sides < 0) {
                    this.descriptionLabel.setText("Количество сторон должно быть 0 или больше.");
                    return;
                }
            } catch (NumberFormatException var5) {
                this.descriptionLabel.setText("Введите корректное число сторон.");
                return;
            }
            Shape shape = this.shapeFactory.createPolygon(sides, this.selectedColor);
            GraphicsContext gc = this.canvas.getGraphicsContext2D();
            gc.clearRect(0.0, 0.0, this.canvas.getWidth(), this.canvas.getHeight());
            if (shape != null) {
                String description = shape.descriptor();
                this.descriptionLabel.setText("Фигура: " + description);
                shape.draw(gc);
            } else {
                this.descriptionLabel.setText("Неправильное количество сторон!");
            }
        }
    }
}
