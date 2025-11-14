package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.App;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
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
    private Button btnNotifications;

    private ContextMenu menuNotificaciones;

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
            app.openUserDashboard();
        }

    }

    @FXML
    void onOpenQuote() {
        app.openQuote();
    }

    public void setApp(App app) {
        this.app = app;
        if (app.getPersona() != null) {
            btnNotifications.setVisible(true);
            login.setText(app.getPersona().getName());
            signUp.setText("Cerrar Sesión");
        }else{
            btnNotifications.setVisible(false);
            btnNotifications.setManaged(false);
            signUp.setText("Registrarse");
            login.setText("Iniciar sesión");
        }
    }

    @FXML
    void initialize() {
        menuNotificaciones = new ContextMenu();

        MenuItem n1 = new MenuItem("📦 Envío #12345 entregado");
        MenuItem n2 = new MenuItem("🚚 Envío en camino");
        MenuItem n3 = new MenuItem("✅ Pago confirmado");

        menuNotificaciones.getItems().addAll(n1, n2, n3);

        btnNotifications.setOnAction(e -> {
            if (menuNotificaciones.isShowing()) {
                menuNotificaciones.hide();
            } else {
                menuNotificaciones.show(btnNotifications,
                        Side.BOTTOM, 0, 0);
            }
        });
    }

}