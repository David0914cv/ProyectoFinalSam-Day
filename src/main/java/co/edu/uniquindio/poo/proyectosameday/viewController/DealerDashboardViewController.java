package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.App;
import co.edu.uniquindio.poo.proyectosameday.model.EstadoDisponibilidad;
import co.edu.uniquindio.poo.proyectosameday.repository.Database;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DealerDashboardViewController {

    App app;
    Database db;

    @FXML
    private Button btnName;

    @FXML
    private Button btnNotifications;

    @FXML
    private Button btnDisponibilidad;

    @FXML
    private Button btnEnvios;

    @FXML
    private Button btnLogout;

    @FXML
    private StackPane contentArea;

    private ContextMenu menuNotificaciones;

    private String estadoActual = "Activo"; // Estado inicial

    @FXML
    public void initialize() {
        this.db=Database.getInstance();
    }

    private void configurarEventos() {

        btnDisponibilidad.setOnAction(e -> cambiarDisponibilidad());

        btnEnvios.setOnAction(e -> {
            try {
                cargarVista("shapes-dealer.fxml");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnLogout.setOnAction(e -> {
            app.setPersona(null);
            app.openMainView();
        });

        menuNotificaciones = new ContextMenu();
        List<MenuItem> items = new ArrayList<>();

        for (String message : db.getDealerId(app.getPersona().getId()).getListNotifications()){
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
    }

    private void cambiarDisponibilidad() {
        String state ="";
        if (db.getDealerId(app.getPersona().getId()).getEstado() == EstadoDisponibilidad.ACTIVO) {
            state = "Activo";
        }
        if (db.getDealerId(app.getPersona().getId()).getEstado() == EstadoDisponibilidad.INACTIVO) {
            state = "Inactivo";
        }
        if (db.getDealerId(app.getPersona().getId()).getEstado() == EstadoDisponibilidad.EN_RUTA) {
            state = "En ruta";
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cambio disponibilidad");
        alert.setHeaderText("Su estado actual es "+state);
        alert.setContentText("¿Qué estado desea cambiar?");

        // Personalizar los botones
        ButtonType botonRuta = new ButtonType("En ruta");
        ButtonType botonActivo = new ButtonType("Activo");
        ButtonType botonInactivo = new ButtonType("Inactivo");
        alert.getButtonTypes().setAll(botonRuta, botonActivo, botonInactivo);

        // Mostrar la alerta y esperar respuesta
        Optional<ButtonType> resultado = alert.showAndWait();

        if (resultado.isPresent() && resultado.get() == botonRuta){
            System.out.println("En ruta");
        }
    }

    private void cargarVista(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/proyectosameday/" + fxml));
            Parent newView = loader.load();

            Object controller = loader.getController();

            if (controller instanceof ShapesDealerViewController shapesDealerViewController) {
                shapesDealerViewController.setApp(this.app);
            }

            contentArea.getChildren().setAll(newView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setApp(App app){
        this.app=app;
        btnName.setText(app.getPersona().getName());
        configurarEventos();
    }
}
