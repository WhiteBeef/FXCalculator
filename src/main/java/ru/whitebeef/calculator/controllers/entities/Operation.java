package ru.whitebeef.calculator.controllers.entities;

import javafx.scene.control.Button;

import java.util.function.BiFunction;

public enum Operation {

    EQUALS((number1, number2) -> {
        throw new IllegalCallerException("Operation can't be executed");
    }),
    CLEAR((number1, number2) -> {
        throw new IllegalCallerException("Operation can't be executed");
    }),
    REMOVE_LAST_NUMBER((number1, number2) -> {
        throw new IllegalCallerException("Operation can't be executed");
    }),
    PLUS(Double::sum),
    MINUS((number1, number2) -> number1 - number2),
    DIVIDE((number1, number2) -> number1 / number2), // maybe needs validate
    MULTIPLY((number1, number2) -> number1 * number2);

    private final BiFunction<Double, Double, Double> operation;

    Operation(BiFunction<Double, Double, Double> operation) {
        this.operation = operation;
    }

    public Double execute(Double number1, Double number2) {
        return operation.apply(number1, number2);
    }
}
