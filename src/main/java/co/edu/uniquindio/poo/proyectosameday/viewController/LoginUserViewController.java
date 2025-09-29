package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.App;
import co.edu.uniquindio.poo.proyectosameday.controller.LoginUserController;
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
    private Label userLabel;

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Hyperlink linkRol;

    @FXML
    private Hyperlink linkRol2;

    @FXML
    void onLogin(){
        System.out.println(this.rol);
        String user = userField.getText();
        String password = passwordField.getText();

        Map<String,String> resp =controller.login(this.rol, user, password);

        if (resp.get("message").equals("Login exitoso")){
            app.setUser(resp.get("user"));
            app.setName(resp.get("name"));
            app.openMainView();

        }else{
            Stage stage = (Stage) passwordField.getScene().getWindow();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(stage);
            alert.initModality(Modality.WINDOW_MODAL);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(resp.get("message"));
            alert.showAndWait();
            System.out.println(resp.get("message"));
        }
        System.out.println("hola =" +resp);
    }

    @FXML
    void onRegistrarse(){}

    @FXML
    void onLoginRepartidor(){
        if (rol.equals("Usuario")){
            this.rol="Repartidor";
            userField.setPromptText("Documento:");
            userLabel.setText("Documento:");
            linkRol.setText("Iniciar como Cliente");
        }
        else if (rol.equals("Repartidor")){
            this.rol="Usuario";
            userField.setPromptText("Correo electrónico:");
            userLabel.setText("Correo electrónico:");
            linkRol.setText("Iniciar como Repartidor");
        }

    }

    @FXML
    void onLoginAdmin(){
        if (rol.equals("Usuario")){
            this.rol="Administrador";
            userField.setPromptText("Documento:");
            userLabel.setText("Documento:");
            linkRol.setText("Iniciar como Cliente");
        }
        else if (rol.equals("Administrador")){
            this.rol="Usuario";
            userField.setPromptText("Correo electrónico:");
            userLabel.setText("Correo electrónico:");
            linkRol2.setText("Iniciar como Administrador");
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
    }
}
