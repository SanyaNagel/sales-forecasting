package ru.nagel.sales.forecasting.models;

import java.util.Date;

public class Sales {
    private Date date;
    private int count;
    private int price; //Все цены в копейках
    private int promotion;
    private int productId;

    public Sales(Date date, int count, int price, int promotion, int productId) {
        this.date = date;
        this.count = count;
        this.price = price;
        this.promotion = promotion;
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }
}
