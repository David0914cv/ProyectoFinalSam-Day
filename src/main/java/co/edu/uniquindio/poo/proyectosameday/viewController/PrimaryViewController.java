package co.edu.uniquindio.poo.proyectosameday.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PrimaryViewController {
    @FXML
    private Label welcomeText;

    @FXML
    void onOpenSignUp() {
        System.out.println("Registrarse");
    }

    @FXML
    void onOpenSignIn() {
        System.out.println("Iniciar sesion");
    }

    @FXML
    void onOpenQuote() {
        System.out.println("Cotizar");
    }

}