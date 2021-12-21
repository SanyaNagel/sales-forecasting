package ru.nagel.sales.forecasting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.nagel.sales.forecasting.models.BatchGoods;
import ru.nagel.sales.forecasting.models.History;
import ru.nagel.sales.forecasting.models.Product;
import ru.nagel.sales.forecasting.models.Sales;

import java.io.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LoadBase {
    private static Warehouse warehouse;
    private static final Logger logger = LogManager.getLogger();

    @BeforeClass
    public static void before(){
        warehouse = new Warehouse();
    }

    @Test
    public void createValute(){
        warehouse.addBatchGoods(new BatchGoods(new Date(),1, new Product("Ethereum",
                "Валюта",
                1,
                new History(new ArrayList<>()))));
    }

    /**
     * Вставляем продажи-котировки
     */
    @Test
    public void loadQuotes() throws IOException, ParseException {
        String btc = "GDAX.BTC-USD_180101_211220.txt";
        String etc = "GDAX.ETH-USD_180101_211220.txt";
        BufferedReader reader = new BufferedReader(new FileReader(new File(etc)));
        reader.readLine();  //пропускаем первую строку
        String line = reader.readLine();
        while (line != null) {
            // считываем остальные строки в цикле
            warehouse.getSession().addSale(parseSale(line));
            line = reader.readLine();
        }
    }

    /**
     * Для работы алгоритма прогнозирования с валютой, в базе сделаем соответствие:
     * count - что является количеством продаж (в базе)
     * будет текущей ценой валюты в этот день
     *
     * <DATE>;  <TIME>;   <OPEN>;    <HIGH>;      <LOW>;     <CLOSE>;  <VOL>
     * 01/01/18;000000;741.2400000;764.9700000;727.1400000;759.0300000;55,669
     */
    private Sales parseSale(String line) throws ParseException {
        logger.info(line);
        String[] dateList = line.split(";");
        //Date date, int count, int price, int promotion, int productId
        Sales sales = new Sales(new SimpleDateFormat("dd/MM/yy").parse(dateList[0]),
                new BigDecimal(dateList[5]).movePointRight(2).intValue(),
                0,
                0,
                32);
        return sales;
    }
}
