package ru.nagel.sales.forecasting;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.MenuItem;
import ru.nagel.sales.forecasting.methods.DependenciesMethod;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem dependenciesProduct;

    @FXML
    private LineChart<?, ?> scene;

    private SystemClass systemClass;

    @FXML
    void initialize() {
        scene.setCreateSymbols(false);
        systemClass = new SystemClass();
        dependenciesProduct.setOnAction(event -> {
            systemClass.getGenerator().setMethod(new DependenciesMethod(Constants.METHOD_DEPENDENCIES));
            systemClass.getGenerator().executeMethod(this);
        });
    }


    public ResourceBundle getResources() {
        return resources;
    }

    public URL getLocation() {
        return location;
    }

    public MenuItem getDependenciesProduct() {
        return dependenciesProduct;
    }

    public LineChart<?, ?> getScene() {
        return scene;
    }

    public SystemClass getSystemClass() {
        return systemClass;
    }
}
