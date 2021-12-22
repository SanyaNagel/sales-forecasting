package ru.nagel.sales.forecasting.methods;

import ru.nagel.sales.forecasting.Controller;
import ru.nagel.sales.forecasting.DbSession;

public abstract class MethodForecasting {
    /**
     * Флаг метода, указывающий нуждается ли метод в предварительной настройки
     */
    protected boolean prevSetting = false;
    protected String name;
    protected DbSession session;

    public abstract Result execution(Controller controller);

    public boolean isPrevSetting() {
        return prevSetting;
    }

    public void setPrevSetting(boolean prevSetting) {
        this.prevSetting = prevSetting;
    }

    public String getMethodName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DbSession getSession() {
        return session;
    }

    public void setSession(DbSession session) {
        this.session = session;
    }

}
