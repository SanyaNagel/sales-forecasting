package ru.nagel.sales.forecasting;

import ru.nagel.sales.forecasting.models.BatchGoods;

/**
 * функции внесения товара в базу данных, или удаления его из базы
 */
public class Warehouse {
    private DbSession session = new DbSession();
    public Warehouse() {
    }

    public void addBatchGoods(BatchGoods batchGoods){
        session.addBatchGood(batchGoods);
    }

    public DbSession getSession() {
        return session;
    }

    public void removalBatchGoods(){

    }
}
