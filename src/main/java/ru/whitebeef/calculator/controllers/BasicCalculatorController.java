package ru.whitebeef.calculator.controllers;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import ru.whitebeef.calculator.controllers.abstractions.NumbersController;
import ru.whitebeef.calculator.controllers.abstractions.OperationsController;
import ru.whitebeef.calculator.controllers.entities.Operation;

import java.util.HashMap;
import java.util.Map;

public class BasicCalculatorController implements NumbersController, OperationsController {

    public static final String BUTTON_PREFIX = "NumberButton";
    private final Map<Integer, Button> buttons = new HashMap<>();
    private final GridPane gridPane = new GridPane();
    private boolean enterNumber;
    private double lastNumber = 0;
    private double currentNumber;
    private Operation currentOperation;

    public BasicCalculatorController() {
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        Button divideButton = new Button();
        divideButton.setId("divideButton");
        divideButton.setText("/");
        divideButton.setOnAction(event -> onPressOperation(Operation.DIVIDE));
        GridPane.setConstraints(divideButton, 3, 0);


        Button multipleButton = new Button();
        multipleButton.setId("multipleButton");
        multipleButton.setText("*");
        multipleButton.setOnAction(event -> onPressOperation(Operation.MULTIPLY));
        GridPane.setConstraints(multipleButton, 3, 1);

        Button minusButton = new Button();
        minusButton.setId("minusButton");
        minusButton.setText("-");
        minusButton.setOnAction(event -> onPressOperation(Operation.MINUS));
        GridPane.setConstraints(minusButton, 3, 2);

        Button plusButton = new Button();
        plusButton.setId("plusButton");
        plusButton.setText("+");
        plusButton.setOnAction(event -> onPressOperation(Operation.PLUS));
        GridPane.setConstraints(plusButton, 3, 3);

        Button equalsButton = new Button();
        equalsButton.setId("equalsButton");
        equalsButton.setText("=");
        equalsButton.setOnAction(event -> onPressOperation(Operation.EQUALS));
        GridPane.setConstraints(equalsButton, 3, 4);

        int row = -2;
        int column = 0;
        for (int i = 0; i < 10; i++) {
            if (column % 3 == 0) {
                column = 0;
                row++;
            }
            int finalI = i;
            Button button = new Button();
            button.setId(BUTTON_PREFIX + i);
            button.setOnAction(event -> onPressNumberButton(finalI));
            button.setText(String.valueOf(i));
            gridPane.getChildren().add(button);
            if (i != 0) {
                GridPane.setConstraints(button, column, row);
                column++;
            } else {
                GridPane.setConstraints(button, 1, 3);
            }
        }
        gridPane.getChildren().addAll(divideButton, multipleButton, minusButton, plusButton, equalsButton);

    }

    @Override
    public void onPressNumberButton(int button) {
        if (!enterNumber) {
            lastNumber = currentNumber;
            currentNumber = button;
            enterNumber = true;
        } else {
            currentNumber *= 10;
            currentNumber += button;
        }
        System.out.println("pressed: " + button);
        System.out.println("mem: " + lastNumber + " " + currentNumber);
    }

    @Override
    public void onPressOperation(Operation operation) {
        System.out.println("you pressed " + operation.name());

        if (operation == Operation.EQUALS) {
            System.out.println(lastNumber + " " + currentOperation.name() + " " + currentNumber + " equals " + currentOperation.execute(lastNumber, currentNumber));
            currentNumber = currentOperation.execute(lastNumber, currentNumber);
            return;
        }

        if (operation == Operation.CLEAR) {
            currentNumber = 0;
            lastNumber = 0;
            enterNumber = false;
            return;
        }
        enterNumber = false;
        currentOperation = operation;
    }

    public Map<Integer, Button> getButtons() {
        return buttons;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

}