package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.App;
import co.edu.uniquindio.poo.proyectosameday.controller.LoginUserController;
import co.edu.uniquindio.poo.proyectosameday.controller.RegisterUserController;
import co.edu.uniquindio.poo.proyectosameday.model.Persona;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterUserViewController {

    App app;
    RegisterUserController controller;

    @FXML
    private TextField emailField;

    @FXML
    private TextField documentField;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField cellField;

    @FXML
    void onSignUp(){
        System.out.println("Sign Up");

        String email = emailField.getText();
        String document = documentField.getText();
        String name = nameField.getText();
        String cell = cellField.getText();
        String password = passwordField.getText();

        if (email.isEmpty() || name.isEmpty() || cell.isEmpty() || password.isEmpty()) {
            MethodsRecycle.showAlert("Advertencia","Debe llenar todos los campos del formulario", Alert.AlertType.WARNING);
            return;
        }

        if(!MethodsRecycle.checkEmail(email)){
            MethodsRecycle.showAlert("Error","Correo inválido, debe ingresar un correo electrónico válido", Alert.AlertType.ERROR);
            return;
        }

        Persona resp = controller.SignUp(email,document, name, cell, password);

        if (resp != null) {
            MethodsRecycle.showAlert("Registro exitoso!","Se ha registrado con exito en el sistema",Alert.AlertType.INFORMATION);
            app.openLogin();
        }else{
            MethodsRecycle.showAlert("Advertencia","Usuario ya existe",Alert.AlertType.WARNING);
        }


    }

    @FXML
    void onOpenLogin(){
        app.openLogin();
    }

    @FXML
    void onBack(){
        app.openMainView();
    }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {
        this.controller = new RegisterUserController(App.empresa);
    }


}
