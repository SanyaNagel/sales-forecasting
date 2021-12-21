package ru.nagel.sales.forecasting.models;

import java.util.List;

public class History {
    private List<Sales> salesList;

    public History(List<Sales> salesList) {
        this.salesList = salesList;
    }

    public List<Sales> getSalesList() {
        return salesList;
    }

    public void setSalesList(List<Sales> salesList) {
        this.salesList = salesList;
    }
}
