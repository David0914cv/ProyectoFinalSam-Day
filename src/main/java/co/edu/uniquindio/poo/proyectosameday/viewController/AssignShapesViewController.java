package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.model.Envio;
import co.edu.uniquindio.poo.proyectosameday.model.EnvioComponent;
import co.edu.uniquindio.poo.proyectosameday.model.Repartidor;
import co.edu.uniquindio.poo.proyectosameday.repository.Database;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class AssignShapesViewController {

    Database db;

    @FXML
    private TableView<EnvioComponent> tablaEnvios;

    @FXML private TableColumn<EnvioComponent, String> colIdEnvio;
    @FXML private TableColumn<EnvioComponent, String> colDestino;
    @FXML private TableColumn<EnvioComponent, String> colOrigen;
    @FXML private TableColumn<EnvioComponent, String> colFecha;
    @FXML private TableColumn<EnvioComponent, String> colEstado;
    @FXML private TableColumn<EnvioComponent, String> colRepartidor;
    @FXML private TableColumn<EnvioComponent, Void> colAsignar;

    @FXML
    void initialize() {
        this.db=Database.getInstance();
        cargarColumnas();
        cargarEnvios();
    }

    private void cargarColumnas() {
        colIdEnvio.setCellValueFactory(new PropertyValueFactory<>("id"));
        colOrigen.setCellValueFactory(new PropertyValueFactory<>("ciudadOrigen"));
        colDestino.setCellValueFactory(new PropertyValueFactory<>("ciudadDestino"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaEntregaFormateada"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        // ComboBox dentro de la celda
        colRepartidor.setCellFactory(col -> new TableCell<>() {
            private final ComboBox<Repartidor> combo = new ComboBox<>();

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                } else {
                    combo.setItems(FXCollections.observableArrayList(db.getListDealers())); // Lista desde el modelo
                    setGraphic(combo);
                }
            }
        });

        // Botón de asignar
        colAsignar.setCellFactory(col -> new TableCell<>() {
            private final Button btn = new Button("Asignar");

            {
                btn.getStyleClass().add("primary-btn");
                btn.setOnAction(event -> asignarRepartidor());
            }

            private void asignarRepartidor() {
                EnvioComponent envio = getTableView().getItems().get(getIndex());
                // Aquí llamas tu lógica para asignar
                System.out.println("Asignando a envío: " + envio.getId());
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : btn);
            }
        });
    }

    private void cargarEnvios() {
        tablaEnvios.setItems(FXCollections.observableArrayList(db.getListEnvios()));
    }

    @FXML
    private void onActualizarTabla() {
        cargarEnvios();
    }
}
