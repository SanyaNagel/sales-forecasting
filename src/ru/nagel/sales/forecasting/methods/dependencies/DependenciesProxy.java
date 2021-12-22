package ru.nagel.sales.forecasting.methods.dependencies;

import ru.nagel.sales.forecasting.Controller;
import ru.nagel.sales.forecasting.methods.MethodForecasting;
import ru.nagel.sales.forecasting.methods.Result;

/**
 * Прокси, отвечающий за проверку настроек метода,
 * если возникает ошибка, то этот класс обязан корректно отобразить ошибку на форме
 */
public class DependenciesProxy extends MethodForecasting {
    DependenciesMethod dependenciesMethod;

    public DependenciesProxy(String name) {
        dependenciesMethod = new DependenciesMethod(name);
    }

    @Override
    public Result execution(Controller controller) {
        if(dependenciesMethod.isPrevSetting()){
            String error = validationSettings();
            if(error != null){
                Result result = new ResultDependenciesMethod();
                result.setErrorMessage("Ошибка настроек метода");
                return result;
            }else {
                return dependenciesMethod.execution(controller);
            }
        }else{
            return dependenciesMethod.execution(controller);
        }

    }

    /**
     * если используются доп настройки, то проверяем их на правильность, в случае чего выводим ошибку
     */
    public String validationSettings(){
        return null;
    }
}
