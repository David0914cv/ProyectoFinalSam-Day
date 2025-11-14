package co.edu.uniquindio.poo.proyectosameday.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FormTransferViewController {

    @FXML
    private TextField nombreBancoField;

    @FXML
    private TextField numeroCuentaField;

    @FXML
    private TextField titularCuentaField;

    @FXML
    private Button btnCargarComprobante;

    @FXML
    void onOpenArchive(){
        MethodsRecycle.showAlert("Información","Cargando imagen comprobante...", Alert.AlertType.INFORMATION);
    }

    public String getNombreBanco() {
        return nombreBancoField.getText();
    }

    public String getNumeroCuenta() {
        return numeroCuentaField.getText();
    }

    public String getTitularCuenta() {
        return titularCuentaField.getText();
    }

    public void procesarPago() {
        MethodsRecycle.showAlert("Información","Se esta procesando el pago...", Alert.AlertType.INFORMATION);
    }

}
