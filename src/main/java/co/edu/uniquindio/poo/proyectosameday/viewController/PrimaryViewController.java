package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.App;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Objects;

public class PrimaryViewController {

    App app;

    @FXML
    private Button login;

    @FXML
    private Button signUp;

    @FXML
    void onOpenSignUp() {

        if (signUp.getText().equals("Registrarse")) {
            app.openRegister();
        } else if (signUp.getText().equals("Cerrar Sesión")) {
            signUp.setText("Registrarse");
            login.setText("Iniciar sesión");
            app.setPersona(null);
            app.setAdmin(null);
        }
    }

    @FXML
    void onOpenSignIn() {
        if (login.getText().equals("Iniciar sesión")){
            app.openLogin();
        }else{
            System.out.println("En mi cuenta");
        }

    }

    @FXML
    void onOpenQuote() {
        app.openQuote();
    }

    public void setApp(App app) {
        this.app = app;
        if (app.getPersona() != null) {
            login.setText(app.getPersona().getName());
            signUp.setText("Cerrar Sesión");
        }else{
            signUp.setText("Registrarse");
            login.setText("Iniciar sesión");
        }
    }

    @FXML
    void initialize() {

    }

}