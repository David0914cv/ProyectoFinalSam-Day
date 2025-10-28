package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.App;
import co.edu.uniquindio.poo.proyectosameday.controller.QuoteShippingController;
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
    Cotizacion cotizacion;

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
    private Label resultLabel;

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

        try {

            String[] parts = dimensions.trim().toLowerCase().split("x");

            if (parts.length != 3) {
                throw new IllegalArgumentException("Formato incorrecto. Usa: largo x ancho x alto\nEjemplo: 20x20x20");
            }

            double dim1 = Double.parseDouble(parts[0]);
            double dim2 = Double.parseDouble(parts[1]);
            double dim3  = Double.parseDouble(parts[2]);


            if (dim1 <= 0 || dim2 <= 0 || dim3 <= 0) {
                MethodsRecycle.showAlert("Error","Las dimensiones deben ser mayores a 0", Alert.AlertType.ERROR);
                return;
            }


        } catch (NumberFormatException e) {
            MethodsRecycle.showAlert("Error","Error: Las dimensiones deben ser números. Ejemplo válido: 30x20x10", Alert.AlertType.ERROR);
            return;
        } catch (IllegalArgumentException e) {
            MethodsRecycle.showAlert("Error", e.getMessage(), Alert.AlertType.ERROR);
            return ;
        }


        Cotizacion resp=controller.calculatePrice(origin, destination, weight, dimensions);
        this.cotizacion=resp;

        resultLabel.setText("$" + resp.getPrice());
        System.out.println(resp);

    }

    @FXML
    void onSending(){
        app.openSendingUser();
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
