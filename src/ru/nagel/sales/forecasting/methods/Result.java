package ru.nagel.sales.forecasting.methods;

/**
 * Выделил отдельный интерфейс результата,
 * каждый метод будет отображать результат по разному делегирую этим класса вывод результата
 */
public abstract class Result {
    protected String errorMessage = null;

    public abstract void viewResult();
    public abstract void viewError();

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
