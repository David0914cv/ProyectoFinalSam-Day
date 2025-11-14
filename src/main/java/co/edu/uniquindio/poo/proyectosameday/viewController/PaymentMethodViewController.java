package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.App;
import co.edu.uniquindio.poo.proyectosameday.controller.PaymentMethodController;
import co.edu.uniquindio.poo.proyectosameday.model.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class PaymentMethodViewController {

    App app;
    PaymentMethodController controller;

    @FXML
    private ComboBox<String> metodoPagoCombo;

    @FXML
    private StackPane paymentContainer;

    private Object formControllerActual;

    @FXML
    void onBack(){
        app.openSendingUser();
    }

    @FXML
    void onPay(){
        if (formControllerActual instanceof FormTargetViewController) {
            MethodsRecycle.showAlert("Confirmación","Se realizó el pago correctamente", Alert.AlertType.INFORMATION);
            controller.addEnvio(app.getEnvioComponent());
            controller.SetPay(controller.getUser(app.getPersona()),app.getEnvioComponent());
            MethodsRecycle.showAlert("Confirmación","Cuando el repartidor sea asignado será notificado", Alert.AlertType.INFORMATION);
            app.openMainView();
        }

        if (formControllerActual instanceof FormTransferViewController controllerTranfer) {
            controllerTranfer.procesarPago();
            MethodsRecycle.showAlert("Confirmación","Se realizó el pago correctamente", Alert.AlertType.INFORMATION);
            controller.addEnvio(app.getEnvioComponent());
            controller.SetPay(controller.getUser(app.getPersona()),app.getEnvioComponent());
            MethodsRecycle.showAlert("Confirmación","Cuando el repartidor sea asignado será notificado", Alert.AlertType.INFORMATION);
            app.openMainView();
        }

    }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {
        this.controller = new PaymentMethodController(App.empresa);
        metodoPagoCombo.getItems().addAll(
                "Tarjeta de Credito",
                "Transferencia Bancaria"
        );

        metodoPagoCombo.setOnAction(e -> cargarFormulario(metodoPagoCombo.getValue()));
    }

    private void cargarFormulario(String metodoSeleccionado) {
        String fxml = null;

        switch (metodoSeleccionado) {
            case "Tarjeta de Credito" -> fxml = "form-target.fxml";
            case "Transferencia Bancaria" -> fxml = "form-transfer.fxml";
        }

        if (fxml != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(
                        "/co/edu/uniquindio/poo/proyectosameday/" + fxml
                ));
                Pane formPane = loader.load();


                formControllerActual = loader.getController();

                paymentContainer.getChildren().clear();
                paymentContainer.getChildren().add(formPane);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
