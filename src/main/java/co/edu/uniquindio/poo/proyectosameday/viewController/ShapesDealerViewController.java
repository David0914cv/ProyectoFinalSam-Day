package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.App;
import co.edu.uniquindio.poo.proyectosameday.model.EnvioComponent;
import co.edu.uniquindio.poo.proyectosameday.repository.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class ShapesDealerViewController {
    App app;
    Database db;

    @FXML private TableView<EnvioComponent> tablaEnvios;

    @FXML private TableColumn<EnvioComponent, String> colCodigo;
    @FXML
    private TableColumn<EnvioComponent, String> colDestino;
    @FXML private TableColumn<EnvioComponent, String> colEstado;
    @FXML private TableColumn<EnvioComponent, String> colFecha;


    public void setApp(App app) {
        this.app = app;
        cargarTabla();

    }
    @FXML
    public void initialize() {
        this.db = Database.getInstance();
    }

    private void cargarTabla(){
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("id"));
        colDestino.setCellValueFactory(new PropertyValueFactory<>("ciudadDestino"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaEntrega"));

        List<EnvioComponent> listShapes = new ArrayList<>();

        for (EnvioComponent shape : db.getListEnvios()) {
            if (shape.getRepartidor() != null) {
                if (shape.getRepartidor().getId().equals(app.getPersona().getId())) {
                    listShapes.add(shape);
                }
            }
        }

        ObservableList<EnvioComponent> datos = FXCollections.observableArrayList(
                listShapes
        );

        tablaEnvios.setItems(datos);

        tablaEnvios.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                mostrarDetalleEnvio(newSelection);
            }
        });
    }

    private void mostrarDetalleEnvio(EnvioComponent envio) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Detalle del Envío");
        alert.setContentText("ID: " + envio.getId() + "\n" +
                "Destino: " + envio.getCiudadDestino() + "\n" +
                "Estado: " + envio.getEstado());
        alert.show();
    }

}
