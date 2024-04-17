package ru.whitebeef.calculator.managers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.whitebeef.calculator.HelloApplication;
import ru.whitebeef.calculator.controllers.BasicCalculatorController;

import java.io.IOException;

public class SceneManager {
    private static SceneManager instance;

    public static SceneManager getInstance() {
        return instance;
    }

    private Scene currentScene;

    public SceneManager(Stage stage) throws IOException {
        instance = this;

        Scene scene = new Scene(new BasicCalculatorController().getGridPane(), 320, 240);
        stage.setScene(scene);
        stage.show();
    }

    public Scene getCurrentScene() {
        return currentScene;
    }
}
