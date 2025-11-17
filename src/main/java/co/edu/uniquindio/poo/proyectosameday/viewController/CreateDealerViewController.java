package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.App;
import co.edu.uniquindio.poo.proyectosameday.controller.AdminController;
import co.edu.uniquindio.poo.proyectosameday.controller.RegisterUserController;
import co.edu.uniquindio.poo.proyectosameday.model.Persona;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CreateDealerViewController {

    AdminController controller;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtDocumento;

    @FXML
    private PasswordField txtPassword;


    @FXML
    public void oncreateDealer() {
        String name = txtNombre.getText();
        String cell = txtTelefono.getText();
        String document = txtDocumento.getText();
        String password = txtPassword.getText();


        if (name.isEmpty() || cell.isEmpty() || password.isEmpty() || document.isEmpty()) {
            MethodsRecycle.showAlert("Error", "Debe llenar todos los campos", Alert.AlertType.ERROR);
            return;
        }

        Persona resp = controller.createDealer(document,name,cell,password);

        if (resp != null) {
            MethodsRecycle.showAlert("Éxito", "Repartidor creado correctamente", Alert.AlertType.INFORMATION);
            clearFields();
            return;
        }

        MethodsRecycle.showAlert("Error", "Ha ocurrido un error al crear el repartidor", Alert.AlertType.ERROR);

    }

    private void clearFields() {
        txtNombre.clear();
        txtTelefono.clear();
        txtDocumento.clear();
        txtPassword.clear();
    }

    @FXML
    void initialize() {
        this.controller = new AdminController(App.empresa);
    }

}
