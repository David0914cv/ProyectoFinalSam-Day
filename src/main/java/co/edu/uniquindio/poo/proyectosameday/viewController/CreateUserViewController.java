package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.App;
import co.edu.uniquindio.poo.proyectosameday.controller.RegisterUserController;
import co.edu.uniquindio.poo.proyectosameday.model.Persona;
import co.edu.uniquindio.poo.proyectosameday.model.dtos.PersonaDTO;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CreateUserViewController {

    RegisterUserController controller;

    @FXML private TextField txtNombre;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtDocumento;
    @FXML private PasswordField txtPassword;

    @FXML
    public void onCrearUsuario() {
        String name = txtNombre.getText();
        String email = txtCorreo.getText();
        String cell = txtTelefono.getText();
        String document = txtDocumento.getText();
        String password = txtPassword.getText();


        if (name.isEmpty() || email.isEmpty() || cell.isEmpty() || password.isEmpty() || document.isEmpty() || !MethodsRecycle.checkEmail(email)) {
            MethodsRecycle.showAlert("Error", "Debe llenar todos los campos", Alert.AlertType.ERROR);
            return;
        }

        Persona resp = controller.SignUp(email,document,name,cell,password);

        if (resp != null) {
            MethodsRecycle.showAlert("Éxito", "Usuario creado correctamente", Alert.AlertType.INFORMATION);
            clearFields();
            return;
        }

        MethodsRecycle.showAlert("Error", "Ha ocurrido un error al crear el usuario", Alert.AlertType.ERROR);

    }

    private void clearFields() {
        txtNombre.clear();
        txtCorreo.clear();
        txtTelefono.clear();
        txtDocumento.clear();
        txtPassword.clear();
    }

    @FXML
    void initialize() {
        this.controller = new RegisterUserController(App.empresa);
    }
}
