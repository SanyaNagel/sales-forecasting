package ru.nagel.sales.forecasting;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.MenuItem;
import ru.nagel.sales.forecasting.methods.dependencies.DependenciesMethod;
import ru.nagel.sales.forecasting.methods.dependencies.DependenciesProxy;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem dependenciesProduct;

    @FXML
    private LineChart<?, ?> scene;

    private System systemClass;

    @FXML
    void initialize() {
        scene.setCreateSymbols(false);
        systemClass = new System();
        dependenciesProduct.setOnAction(event -> {
            systemClass.getGenerator().setMethod(new DependenciesProxy(Constants.METHOD_DEPENDENCIES));
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

    public System getSystemClass() {
        return systemClass;
    }
}
