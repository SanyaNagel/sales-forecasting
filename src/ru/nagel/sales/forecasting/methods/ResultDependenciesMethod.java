package ru.nagel.sales.forecasting.methods;

import ru.nagel.sales.forecasting.Controller;
import ru.nagel.sales.forecasting.models.History;
import ru.nagel.sales.forecasting.models.Sales;

public class ResultDependenciesMethod implements Result{
    private Controller controller;
    private History product1;
    private History product2;

    public ResultDependenciesMethod(Controller controller, History p1, History p2) {
        this.controller = controller;
        product1 = p1;
        product2 = p2;
    }

    @Override
    public void viewResult() {

    }

}
