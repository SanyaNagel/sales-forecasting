package ru.nagel.sales.forecasting.methods;

import ru.nagel.sales.forecasting.Controller;

public class ResultDependenciesMethod implements Result{
    Controller controller;

    public ResultDependenciesMethod(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void viewResult() {

    }
}
