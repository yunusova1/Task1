package com.example.abstractclasss;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label; // отображение текста
import javafx.scene.control.Slider; // ползунок
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
public class HelloController {
    @FXML private Canvas canvas;
    @FXML private ColorPicker fillColorPicker;
    @FXML private ColorPicker strokeColorPicker;
    @FXML private Slider sizeSlider;
    @FXML private TextField xTextField;
    @FXML private TextField yTextField;
    @FXML private TextField shapeCount;
    @FXML private Button rectangleButton; // Связывание кнопки для рисования прямоугольника
    @FXML private Button ellipseButton; //эллипса
    @FXML private Button roundedRectangleButton; // закругленный прямоугольник
    @FXML private Button squareButton; //квадрат
    @FXML private Label lastShapeLabel; // отображения последней нарисованной фигуры
    private GraphicsContext graphicsContext;
    public HelloController() { } // Конструктор
    @FXML
    public void initialize() {
        this.graphicsContext = this.canvas.getGraphicsContext2D(); // Получение контекста графики из Canvas
    }
    // рисования фигур
    private void drawShapes(Shape shape, int count) {
        this.graphicsContext.clearRect(0.0, 0.0, this.canvas.getWidth(), this.canvas.getHeight()); // Очистка холста перед рисованием
        for(int i = 0; i < count; ++i) { // рисование указанного количества фигур
            shape.draw(this.graphicsContext); // Рисование фигуры на холсте
            shape.x +=200.0;
        }
        this.lastShapeLabel.setText("Последняя фигура: " + shape.toString());
    }
    @FXML
    public void Rectangle(ActionEvent actionEvent) { // Метод обработки события нажатия кнопки "Прямоугольник"
        int count = Integer.parseInt(this.shapeCount.getText()); // Получение количества фигур из текстового поля
        this.drawShapes(new Rectangle((Color)this.fillColorPicker.getValue(), (Color)this.strokeColorPicker.getValue(),
                Double.parseDouble(this.xTextField.getText()), Double.parseDouble(this.yTextField.getText()),
                this.sizeSlider.getValue()), count); // Создание и рисование прямоугольника
    }
    @FXML
    public void Ellipse(ActionEvent actionEvent) { //"Эллипс"
        int count = Integer.parseInt(this.shapeCount.getText());
        this.drawShapes(new Ellipse((Color)this.fillColorPicker.getValue(), (Color)this.strokeColorPicker.getValue(),
                Double.parseDouble(this.xTextField.getText()), Double.parseDouble(this.yTextField.getText()),
                this.sizeSlider.getValue()), count);
    }
    @FXML
    public void RoundedRectangle(ActionEvent actionEvent) { // "Закругленный прямоугольник"
        int count = Integer.parseInt(this.shapeCount.getText());
        this.drawShapes(new RoundedRectangle((Color)this.fillColorPicker.getValue(), (Color)this.strokeColorPicker.getValue(),
                Double.parseDouble(this.xTextField.getText()), Double.parseDouble(this.yTextField.getText()),
                this.sizeSlider.getValue()), count);
    }
    @FXML
    public void Square(ActionEvent actionEvent) { // "Квадрат"
        int count = Integer.parseInt(this.shapeCount.getText());
        this.drawShapes(new Square((Color)this.fillColorPicker.getValue(), (Color)this.strokeColorPicker.getValue(),
                Double.parseDouble(this.xTextField.getText()), Double.parseDouble(this.yTextField.getText()),
                this.sizeSlider.getValue()), count);
    }
}

