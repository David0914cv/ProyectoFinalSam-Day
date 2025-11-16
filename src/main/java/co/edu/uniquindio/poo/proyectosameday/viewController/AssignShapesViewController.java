package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.App;
import co.edu.uniquindio.poo.proyectosameday.controller.AdminController;
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
    App app;
    AdminController controller;

    @FXML
    private TableView<EnvioComponent> tablaEnvios;

    @FXML private TableColumn<EnvioComponent, String> colIdEnvio;
    @FXML private TableColumn<EnvioComponent, String> colDestino;
    @FXML private TableColumn<EnvioComponent, String> colOrigen;
    @FXML private TableColumn<EnvioComponent, String> colFecha;
    @FXML private TableColumn<EnvioComponent, String> colEstado;
    @FXML private TableColumn<EnvioComponent, String> colRepartidor;
    @FXML private TableColumn<EnvioComponent, Void> colAsignar;

    Repartidor dealer;

    @FXML
    void initialize() {
        this.db=Database.getInstance();
        this.controller=new AdminController(App.empresa);
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
                    return;
                }

                EnvioComponent shape = getTableView().getItems().get(getIndex());

                // 🔹 Si ya tiene repartidor → mostrar solo el nombre
                if (shape.getRepartidor() != null) {
                    Label lbl = new Label(shape.getRepartidor().getNombre());
                    setGraphic(lbl);
                    return;
                }

                // 🔹 Si NO tiene → mostrar ComboBox
                combo.setItems(FXCollections.observableArrayList(db.getListDealers()));
                combo.setValue(null); // Importante: evitar valores previos reciclados
                setGraphic(combo);

                combo.setOnAction(e -> {
                    dealer = combo.getValue();
                });
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
                EnvioComponent shape = getTableView().getItems().get(getIndex());
                if (shape.getRepartidor() != null) {
                    MethodsRecycle.showAlert("Error","El envio ya tiene un repartidor asignado",Alert.AlertType.ERROR);
                    return;
                }
                controller.assignDealer(db.getAdminId(app.getAdmin().getId()),shape,dealer);
                MethodsRecycle.showAlert("Correcto","Se ha asignado correctamente el repartidor al envío", Alert.AlertType.INFORMATION);
                cargarEnvios();
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

    public void setApp(App app) {
        this.app = app;
    }
}
