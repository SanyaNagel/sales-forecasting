package ru.nagel.sales.forecasting.methods;

import ru.nagel.sales.forecasting.Controller;

public interface MethodForecasting {
    public String getMethodName();
    public Result execution(Controller controller);
}
