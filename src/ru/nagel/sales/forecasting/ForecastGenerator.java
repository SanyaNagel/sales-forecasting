package ru.nagel.sales.forecasting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.nagel.sales.forecasting.methods.MethodForecasting;
import ru.nagel.sales.forecasting.methods.Result;

public class ForecastGenerator {
    private static final Logger logger = LogManager.getLogger();

    MethodForecasting method;

    public ForecastGenerator() { }

    public void setMethod(MethodForecasting method) {
        logger.info("Установил метод: "+ method.getMethodName());
        this.method = method;
    }


    /**
     * Сюда можно интегрировать прокси
     */

    /**
     * Для возможности предварительной настройки
     * разделил установку и выполнение метода на две функции
     */
    public void executeMethod(Controller controller){
        if(method == null){
            logger.error("Метод не инициализирован");
        }else {
            logger.info("Выполняю метод: " + method.getMethodName());
            Result result = method.execution(controller);
            result.viewResult();
        }
    }
}
