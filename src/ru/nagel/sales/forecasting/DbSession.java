package ru.nagel.sales.forecasting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.nagel.sales.forecasting.models.BatchGoods;
import ru.nagel.sales.forecasting.models.Product;
import ru.nagel.sales.forecasting.models.Sales;

import java.sql.*;

public class DbSession {
    private static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "password";  //TODO ....

    private static final Logger logger = LogManager.getLogger();
    private Connection connection;

    public DbSession() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("PostgreSQL JDBC Driver is not found. Include it in your library path");
            return;
        }

        logger.info("PostgreSQL JDBC Driver successfully connected");
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            logger.error(e, e);
            logger.error("Connection Failed");
            return;
        }

        if (connection != null) {
            logger.info("You successfully connected to database now");
        } else {
            logger.info("Failed to make connection to database");
        }
    }

    public void addBatchGood(BatchGoods batchGoods) {
        try (Statement statement = connection.createStatement()) {
            String com = "insert into public.product (name,category,expiration_date) values('" +
                    batchGoods.getProduct().getName() + "', '" +
                    batchGoods.getProduct().getCategory() + "', '" +
                    batchGoods.getProduct().getExpirationDate() + "')";
            statement.executeUpdate(com, Statement.RETURN_GENERATED_KEYS);
            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    String sql = "insert into batch_goods (date_delivery,product_id) values('" +
                            batchGoods.getDateDelivery().toString() + "'," +
                            keys.getInt(1) + ")";
                    statement.executeUpdate(sql);
                } else {
                    throw new Exception("Не удалось получить id вставленного продукта");
                }
            }
            logger.info("Успешно вставлена поставка!");
        } catch (Exception e) {
            logger.error("Не удалось добавить поставку в базу");
            logger.error(e, e);
        }
    }

    public void addSale(Sales sales){
        try (Statement statement = connection.createStatement()) {
            String sqlRequest = "insert into public.sale (date,count,product_id) values('"+
                  new Date(sales.getDate().getTime())+ "', " +
                    sales.getCount() + ", " +
                    sales.getProductId()+")";
            statement.executeUpdate(sqlRequest);
            logger.info("Успешно добавлена!");
        } catch (Exception e) {
            logger.error("Не удалось добавить поставку в базу");
            logger.error(e, e);
        }
    }
}
