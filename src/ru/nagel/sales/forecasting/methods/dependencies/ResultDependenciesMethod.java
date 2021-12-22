package ru.nagel.sales.forecasting.methods.dependencies;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import ru.nagel.sales.forecasting.Controller;
import ru.nagel.sales.forecasting.methods.Result;
import ru.nagel.sales.forecasting.models.History;
import ru.nagel.sales.forecasting.models.Sales;

import java.util.List;

public class ResultDependenciesMethod extends Result {
    private Controller controller;
    private History product1;
    private History product2;

    public ResultDependenciesMethod(){}

    public ResultDependenciesMethod(Controller controller, History p1, History p2) {
        this.controller = controller;
        product1 = p1;
        product2 = p2;
    }

    @Override
    public void viewResult() {
        if(errorMessage != null){
            viewError();
        }

        LineChart<?, ?> scene = controller.getScene();
        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        ObservableList datas1 = convertData(product1,scene.getXAxis().getWidth(),scene.getYAxis().getHeight());
        ObservableList datas2 = convertData(product2,scene.getXAxis().getWidth(),scene.getYAxis().getHeight());

        series1.setName("Bitcoin");
        series1.setData(datas1);
        series2.setName("Ethereum");
        series2.setData(datas2);
        scene.getData().add(series1);
        scene.setTitle("Bitcoin and Ethereum");
        scene.getData().add(series2);
    }

    @Override
    public void viewError() {
        //Вывод ошибки на форму
    }

    private ObservableList<XYChart.Data> convertData(History history, double xMaxScene, double yMaxScene){
        ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
        int maxParamCount = maxCount(history.getSalesList());
        int current = 0;
        for(Sales sales : history.getSalesList()){
            datas.add(new XYChart.Data(String.valueOf(current++), yMaxScene/maxParamCount*sales.getCount()));
        }
        return datas;
    }

    private int maxCount(List<Sales> salesList){
        int max = -1;
        for(Sales s : salesList){
            if(s.getCount() > max){
                max = s.getCount();
            }
        }
        return max;
    }

}
