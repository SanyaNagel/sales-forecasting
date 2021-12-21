package ru.nagel.sales.forecasting.models;

import java.util.Date;

public class BatchGoods {
    private Date dateDelivery;
    private int count;
    private Product product;

    public BatchGoods(Date dateDelivery, int count, Product product) {
        this.dateDelivery = dateDelivery;
        this.count = count;
        this.product = product;
    }

    public Date getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(Date dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
