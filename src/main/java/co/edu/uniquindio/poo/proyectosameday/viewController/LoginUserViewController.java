package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.App;
import co.edu.uniquindio.poo.proyectosameday.controller.LoginUserController;
import co.edu.uniquindio.poo.proyectosameday.model.dtos.AdministradorDTO;
import co.edu.uniquindio.poo.proyectosameday.model.dtos.PersonaDTO;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Map;

public class LoginUserViewController {
    App app;

    LoginUserController controller;
    private String rol="Usuario";

    @FXML
    private Label lblTitle;

    @FXML
    private Label userLabel;

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Hyperlink linkRol2;

    @FXML
    void onLogin(){
        System.out.println(this.rol);
        String user = userField.getText();
        String password = passwordField.getText();

        if(user.isEmpty() || password.isEmpty()){
            MethodsRecycle.showAlert("Advertencia","Debe rellenar todos los campos",Alert.AlertType.WARNING);
            return;
        }

        if (rol.equalsIgnoreCase("Usuario")){
            PersonaDTO resp =controller.loginUser(user, password);
            if (resp!=null){
                app.setPersona(resp);
                if (app.getCotizacion() != null){
                    app.openSendingUser();
                    return;
                }
                app.openMainView();
            }else {
                MethodsRecycle.showAlert("Erros","Usuario o contraseña incorrecta",Alert.AlertType.ERROR);
            }
        }

        if (rol.equalsIgnoreCase("Administrador")){
            AdministradorDTO resp =controller.loginAdmin(user, password);
            if (resp!=null){
                app.setAdmin(resp);
                app.openAdmin();
            } else {
                MethodsRecycle.showAlert("Erros","Usuario o contraseña incorrecta",Alert.AlertType.ERROR);
            }
        }

    }

    @FXML
    void onRegister(){
        app.openRegister();
    }

    @FXML
    void onLoginAdmin(){
        if (rol.equals("Usuario")){
            this.rol="Administrador";
            lblTitle.setText("Iniciar sesión como Administrador");
            linkRol2.setText("Iniciar Sesión como Usuario");
        }
        else if (rol.equals("Administrador")){
            this.rol="Usuario";
            lblTitle.setText("Iniciar sesión");
            linkRol2.setText("Iniciar Sesión como Administrador");
        }
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
        this.controller = new LoginUserController(App.empresa);
        lblTitle.setText("Iniciar sesión");
    }
}
