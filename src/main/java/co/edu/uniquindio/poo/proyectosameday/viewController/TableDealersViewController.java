package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.App;
import co.edu.uniquindio.poo.proyectosameday.controller.AdminController;
import co.edu.uniquindio.poo.proyectosameday.model.Repartidor;
import co.edu.uniquindio.poo.proyectosameday.model.Usuario;
import co.edu.uniquindio.poo.proyectosameday.repository.Database;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Objects;

public class TableDealersViewController {

    AdminController controller;

    @FXML
    private TableView<Repartidor> tablaRepartidores;

    @FXML
    private TableColumn<Repartidor, String> colId;

    @FXML
    private TableColumn<Repartidor, String> colNombre;

    @FXML
    private TableColumn<Repartidor, String> colTelefono;

    @FXML
    private TableColumn<Repartidor, Void> colUpdate;

    @FXML
    private TableColumn<Repartidor, Void> colDelete;

    private App app;
    private Database db;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    public void initialize() {
        this.db=Database.getInstance();
        this.controller = new AdminController(App.empresa);

        colId.setCellValueFactory(new PropertyValueFactory<>("documento"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        agregarBotonesAcciones();

        tablaRepartidores.setItems(FXCollections.observableArrayList(
                db.getListDealers()
        ));
    }

    private void agregarBotonesAcciones() {
        colUpdate.setCellFactory(param -> new TableCell<>() {

            private final Button btnEditar = new Button("Actualizar");
            private final HBox contenedor = new HBox(10, btnEditar);

            {
                btnEditar.getStyleClass().add("primary-btn");


                btnEditar.setOnAction(e -> {
                    Repartidor dealer = getTableView().getItems().get(getIndex());
                    openModal(dealer);
                });

            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : contenedor);
            }
        });

        colDelete.setCellFactory(param -> new TableCell<>() {

            private final Button btnEliminar = new Button("Eliminar");
            private final HBox contenedor = new HBox(10, btnEliminar);

            {
                btnEliminar.getStyleClass().add("danger-btn");

                btnEliminar.setOnAction(e -> {
                    Repartidor dealer = getTableView().getItems().get(getIndex());
                    if (MethodsRecycle.showAlertCondicion("Confirmación","¿Está seguro?","¿Seguro que quiere eliminar el usuario "+dealer.getNombre())) {
                        controller.deleteUser(dealer.getId());
                    }
                    tablaRepartidores.setItems(FXCollections.observableArrayList(db.getListDealers()));
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : contenedor);
            }
        });
    }

   private void openModal(Repartidor dealer) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/co/edu/uniquindio/poo/proyectosameday/update-dealer-modal.fxml"
            ));
            Pane root = loader.load();

            UpdateDealerModalViewController updateDealerModalViewController = loader.getController();
            updateDealerModalViewController.setDealer(dealer);

            updateDealerModalViewController.setOnUpdateCallback(() -> tablaRepartidores.refresh());

            Stage modal = new Stage();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/co/edu/uniquindio/poo/proyectosameday/styles.css")).toExternalForm());
            modal.setTitle("Editar Repartidor");
            modal.setScene(scene);
            modal.setResizable(false);

            // Hace la ventana modal
            modal.initModality(Modality.APPLICATION_MODAL);

            modal.showAndWait();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
