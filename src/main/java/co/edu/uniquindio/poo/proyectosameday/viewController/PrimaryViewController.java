package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.App;
import co.edu.uniquindio.poo.proyectosameday.repository.Database;
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

import java.util.ArrayList;
import java.util.List;
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
        Database db =Database.getInstance();

        if (app.getPersona() != null) {
            btnNotifications.setVisible(true);
            login.setText(app.getPersona().getName());
            signUp.setText("Cerrar Sesión");
            menuNotificaciones = new ContextMenu();

            List<MenuItem> items = new ArrayList<>();

            for (String message : db.getUserId(app.getPersona().getId()).getListNotifications()){
                items.add(new MenuItem(message));
            }

            menuNotificaciones.getItems().addAll(items);

            btnNotifications.setOnAction(e -> {
                if (menuNotificaciones.isShowing()) {
                    menuNotificaciones.hide();
                } else {
                    menuNotificaciones.show(btnNotifications,
                            Side.BOTTOM, 0, 0);
                }
            });
        }else{
            btnNotifications.setVisible(false);
            btnNotifications.setManaged(false);
            signUp.setText("Registrarse");
            login.setText("Iniciar sesión");
        }

    }

    @FXML
    void initialize() {

    }

}