module ru.whitebeef.calculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens ru.whitebeef.calculator to javafx.fxml;
    exports ru.whitebeef.calculator;
    exports ru.whitebeef.calculator.controllers;
    opens ru.whitebeef.calculator.controllers to javafx.fxml;
    exports ru.whitebeef.calculator.controllers.abstractions;
    opens ru.whitebeef.calculator.controllers.abstractions to javafx.fxml;
}