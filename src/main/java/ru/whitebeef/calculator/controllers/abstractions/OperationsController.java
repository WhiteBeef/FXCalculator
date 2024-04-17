package ru.whitebeef.calculator.controllers.abstractions;

import ru.whitebeef.calculator.controllers.entities.Operation;

public interface OperationsController {

    void onPressOperation(Operation operation);

}
