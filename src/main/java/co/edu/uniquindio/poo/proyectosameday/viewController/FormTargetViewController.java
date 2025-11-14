package co.edu.uniquindio.poo.proyectosameday.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FormTargetViewController {

    @FXML
    private TextField numeroTarjetaField;

    @FXML
    private TextField titularField;

    @FXML
    private TextField fechaExpField;

    @FXML
    private PasswordField cvvField;

    public String getNumeroTarjeta() {
        return numeroTarjetaField.getText();
    }

    public String getTitular() {
        return titularField.getText();
    }

    public String getFechaExp() {
        return fechaExpField.getText();
    }

    public String getCvv() {
        return cvvField.getText();
    }

}
