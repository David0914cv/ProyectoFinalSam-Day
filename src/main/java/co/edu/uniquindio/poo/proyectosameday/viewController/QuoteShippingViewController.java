package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.App;
import co.edu.uniquindio.poo.proyectosameday.controller.QuoteShippingController;
import co.edu.uniquindio.poo.proyectosameday.controller.RegisterUserController;
import co.edu.uniquindio.poo.proyectosameday.model.Ciudad;
import co.edu.uniquindio.poo.proyectosameday.model.Cotizacion;
import co.edu.uniquindio.poo.proyectosameday.repository.Database;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.List;

public class QuoteShippingViewController {

    App app;
    Database db;
    QuoteShippingController controller;

    @FXML
    private Label lblTitle;

    @FXML
    private TextField originField;

    @FXML
    private TextField destinationField;

    @FXML
    private Spinner<Integer> weightField;

    @FXML
    private TextField dimensionsField;


    @FXML
    void onBack(){
        app.openMainView();
    }

    @FXML
    void onCalculate(){
        String origin = originField.getText();
        String destination = destinationField.getText();
        int weight = weightField.getValue();
        String dimensions = dimensionsField.getText();

        if (origin.isEmpty() || destination.isEmpty() || dimensions.isEmpty()) {
            MethodsRecycle.showAlert("Error","Debe llenar todos los campos",Alert.AlertType.ERROR);
            return;
        }

        if (weight <= 0 || weight > 100){
            MethodsRecycle.showAlert("Error","El peso debe ser mayor a 0 y menor a 100 kilos",Alert.AlertType.ERROR);
            return;
        }

        Cotizacion resp=controller.calculatePrice(origin, destination, weight, dimensions);

        System.out.println(resp);

    }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {

        this.controller= new QuoteShippingController(App.empresa);
        this.db = Database.getInstance();

        List<String> cities = db.getListCiudades();

        MethodsRecycle.setUpAutoComplete(originField, cities);
        MethodsRecycle.setUpAutoComplete(destinationField, cities);

        Platform.runLater(() -> lblTitle.requestFocus());
    }

}
