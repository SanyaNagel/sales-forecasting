package ru.nagel.sales.forecasting.methods;

import ru.nagel.sales.forecasting.Controller;

/**
 * Прогнозирование продаж, МЕТОД ЗАВИСИМОСТЕЙ
 */
public class DependenciesMethod implements MethodForecasting{
    private String name;

    public DependenciesMethod(String name) {
        this.name = name;
    }

    @Override
    public String getMethodName() {
        return name;
    }

    @Override
    public Result execution(Controller controller) {
        //TODO Здесь подгружаем из базы данные
        //TODO заряжаем их в Result
        //TODO а Result уже выведет на сцену
        return null;
    }
}
