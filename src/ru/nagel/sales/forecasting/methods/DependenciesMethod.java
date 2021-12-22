package ru.nagel.sales.forecasting.methods;

import ru.nagel.sales.forecasting.Controller;
import ru.nagel.sales.forecasting.DbSession;
import ru.nagel.sales.forecasting.models.History;

import static ru.nagel.sales.forecasting.Constants.BITCOIN_PRODUCT_ID;
import static ru.nagel.sales.forecasting.Constants.ETHEREUM_PRODUCT_ID;

/**
 * Прогнозирование продаж, МЕТОД ЗАВИСИМОСТЕЙ
 */
public class DependenciesMethod implements MethodForecasting{
    private String name;
    private DbSession session;
    public DependenciesMethod(String name) {
        session = new DbSession();
        this.name = name;
    }

    @Override
    public String getMethodName() {
        return name;
    }

    @Override
    public Result execution(Controller controller) {
        History product1 = session.getHistoryProduct(BITCOIN_PRODUCT_ID);
        History product2 = session.getHistoryProduct(ETHEREUM_PRODUCT_ID);
        return new ResultDependenciesMethod(controller, product1, product2);
    }
}
