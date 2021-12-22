package ru.nagel.sales.forecasting;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.nagel.sales.forecasting.methods.MethodForecasting;

public class System {
    private static final Logger logger = LogManager.getLogger();
    private ForecastGenerator generator;

    public System() {
        generator= new ForecastGenerator();
    }

    public ForecastGenerator getGenerator() {
        return generator;
    }
}
