package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.App;
import co.edu.uniquindio.poo.proyectosameday.controller.QuoteShippingController;
import co.edu.uniquindio.poo.proyectosameday.controller.SendingUserController;
import co.edu.uniquindio.poo.proyectosameday.model.EnvioComponent;
import co.edu.uniquindio.poo.proyectosameday.model.EstadoEnvio;
import co.edu.uniquindio.poo.proyectosameday.model.Usuario;
import co.edu.uniquindio.poo.proyectosameday.repository.Database;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.util.List;

public class SendingUserViewController {

    App app;
    SendingUserController controller;

    @FXML
    private TextField originField;

    @FXML
    private TextField destinationField;

    @FXML
    private ChoiceBox<String> choiceBoxTypeSending;

    @FXML
    void onSetEnvio(){
        String origin = originField.getText();
        String destination = destinationField.getText();
        String typeSending;

        if (origin == null || destination == null || choiceBoxTypeSending.getValue() == null) {
            MethodsRecycle.showAlert("Advertencia","Debe llenar todos los campos", Alert.AlertType.WARNING);
            return;
        }

        if (choiceBoxTypeSending.getValue().equalsIgnoreCase("Envio Normal")){
            typeSending = "Normal";
        } else if (choiceBoxTypeSending.getValue().equalsIgnoreCase("Envio con Seguro")) {
            typeSending = "seguro";
        } else if (choiceBoxTypeSending.getValue().equalsIgnoreCase("Envio con entrega prioritaria")) {
            typeSending = "prioritario";
        }else {
            MethodsRecycle.showAlert("Advertencia","Debe Seleccionar el tipo de envío", Alert.AlertType.WARNING);
            return;
        }

        EnvioComponent resp = controller.createSendingUser(typeSending,app.getCotizacion(),origin,destination, app.getPersona());
        MethodsRecycle.showAlert("Exitoso!","Se ha generado el envio correctamente, Se notificará Cuando se asigne al repartidor\nSe entregara aproximadamente en la fecha "+ resp.getFechaEntrega(), Alert.AlertType.INFORMATION);
        app.openMainView();
    }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {
        this.controller= new SendingUserController(App.empresa);
    }

}
