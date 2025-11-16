package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.Objects;

public class DealerDashboardViewController {

    App app;

    @FXML
    private Button btnName;

    @FXML
    private Button btnDisponibilidad;

    @FXML
    private Button btnEnvios;

    @FXML
    private Button btnLogout;

    @FXML
    private StackPane contentArea;

    private String estadoActual = "Activo"; // Estado inicial

    @FXML
    public void initialize() {
        configurarEventos();
    }

    private void configurarEventos() {

        btnDisponibilidad.setOnAction(e -> cambiarDisponibilidad());

        btnEnvios.setOnAction(e -> {
            try {
                cargarVista("EnviosAsignadosView.fxml");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnLogout.setOnAction(e -> {
            app.setPersona(null);
            app.openMainView();
        });
    }

    private void cambiarDisponibilidad() {

        if (estadoActual.equals("Activo")) estadoActual = "En ruta";
        else if (estadoActual.equals("En ruta")) estadoActual = "Inactivo";
        else estadoActual = "Activo";

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Estado actualizado");
        alert.setContentText("Tu disponibilidad ahora es: " + estadoActual);
        alert.show();
    }

    private void cargarVista(String fxml) throws IOException {
        Node node = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/co/edu/uniquindio/poo/proyectosameday/" + fxml)));
        contentArea.getChildren().setAll(node);
    }

    public void setApp(App app){
        this.app=app;
        btnName.setText(app.getPersona().getName());
    }
}
