package ru.nagel.sales.forecasting.models;

public class Product {
    /**Name – название товара
     Category – категория товара
     ExpirationDate – срок годности
     History – Объект «история товара» (описан следующим пунктом)
     */
    private String name;
    private String category;
    private int expirationDate; //Срок годности в днях
    private History history;

    public Product(String name, String category, int expirationDate, History history) {
        this.name = name;
        this.category = category;
        this.expirationDate = expirationDate;
        this.history = history;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }
}
