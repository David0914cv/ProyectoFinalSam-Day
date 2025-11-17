package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.App;
import co.edu.uniquindio.poo.proyectosameday.controller.AdminController;
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

public class TableUsersViewController {

    AdminController controller;

    @FXML
    private TableView<Usuario> tablaUsuarios;

    @FXML
    private TableColumn<Usuario, String> colId;

    @FXML
    private TableColumn<Usuario, String> colNombre;

    @FXML
    private TableColumn<Usuario, String> colCorreo;

    @FXML
    private TableColumn<Usuario, String> colTelefono;

    @FXML
    private TableColumn<Usuario, Void> colUpdate;

    @FXML
    private TableColumn<Usuario, Void> colDelete;

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
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        agregarBotonesAcciones();

        tablaUsuarios.setItems(FXCollections.observableArrayList(
            db.getListUsers()
        ));
    }

    private void agregarBotonesAcciones() {
        colUpdate.setCellFactory(param -> new TableCell<>() {

            private final Button btnEditar = new Button("Actualizar");
            private final HBox contenedor = new HBox(10, btnEditar);

            {
                btnEditar.getStyleClass().add("primary-btn");


                btnEditar.setOnAction(e -> {
                    Usuario user = getTableView().getItems().get(getIndex());
                    openModal(user);
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
                    Usuario user = getTableView().getItems().get(getIndex());
                    if (MethodsRecycle.showAlertCondicion("Confirmación","¿Está seguro?","¿Seguro que quiere eliminar el usuario "+user.getNombre())) {
                        controller.deleteUser(user.getId());
                    }
                    tablaUsuarios.setItems(FXCollections.observableArrayList(db.getListUsers()));
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : contenedor);
            }
        });
    }

    private void openModal(Usuario user) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/co/edu/uniquindio/poo/proyectosameday/update-user-modal.fxml"
            ));
            Pane root = loader.load();

            UpdateUserModalViewController controller = loader.getController();
            controller.setUsuario(user);

            controller.setOnUpdateCallback(() -> tablaUsuarios.refresh());

            Stage modal = new Stage();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/co/edu/uniquindio/poo/proyectosameday/styles.css")).toExternalForm());
            modal.setTitle("Editar Usuario");
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
