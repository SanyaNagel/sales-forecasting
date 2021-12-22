package ru.nagel.sales.forecasting.methods.dependencies;

import ru.nagel.sales.forecasting.Controller;
import ru.nagel.sales.forecasting.DbSession;
import ru.nagel.sales.forecasting.methods.MethodForecasting;
import ru.nagel.sales.forecasting.methods.Result;
import ru.nagel.sales.forecasting.models.History;

import static ru.nagel.sales.forecasting.Constants.BITCOIN_PRODUCT_ID;
import static ru.nagel.sales.forecasting.Constants.ETHEREUM_PRODUCT_ID;

/**
 * Прогнозирование продаж, МЕТОД ЗАВИСИМОСТЕЙ
 */
public class DependenciesMethod extends MethodForecasting {

    public DependenciesMethod(String name) {
        setName(name);
        setSession(new DbSession());
    }

    @Override
    public Result execution(Controller controller) {
        History product1 = session.getHistoryProduct(BITCOIN_PRODUCT_ID);
        History product2 = session.getHistoryProduct(ETHEREUM_PRODUCT_ID);
        return new ResultDependenciesMethod(controller, product1, product2);
    }
}
