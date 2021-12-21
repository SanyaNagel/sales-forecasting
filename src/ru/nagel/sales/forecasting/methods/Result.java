package ru.nagel.sales.forecasting.methods;

/**
 * Выделил отдельный интерфейс результата,
 * каждый метод будет отображать результат по разному делегирую этим класса вывод результата
 */
public interface Result {
    public void viewResult();
}
