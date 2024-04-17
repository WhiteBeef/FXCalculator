package ru.whitebeef.calculator;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.whitebeef.calculator.managers.SceneManager;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        new SceneManager(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}