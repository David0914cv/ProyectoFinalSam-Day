package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.App;
import co.edu.uniquindio.poo.proyectosameday.controller.LoginUserController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class AdminViewController {

    App app;

    @FXML
    private StackPane contentArea;


    @FXML
    void onOpenUsers() {
        cargarVista("table-users.fxml");
    }

    @FXML
    void onOpenCreateUser(){
        cargarVista("create-user.fxml");
    }

    @FXML
    void onOpenRepartidores() {
        cargarVista("table-dealers.fxml");
    }

    @FXML
    void onOpenCreateDealer(){
        cargarVista("create-dealer.fxml");
    }

    @FXML
    void onOpenAssignShape() {
        cargarVista("assign-shapes.fxml");
    }

    @FXML
    void onOpenMetricas() {
        cargarVista("metricas-view.fxml");
    }

    @FXML
    void onOpenVisualizacion() {
        cargarVista("visualizacion-view.fxml");
    }

    @FXML
    void onLogout() {
        app.setAdmin(null);
        app.openMainView();
    }

    @FXML
    private VBox usuariosMenu;

    @FXML
    private VBox repartidoresMenu;

    private boolean usuariosOpen = false;
    private boolean repartidoresOpen = false;

    @FXML
    void toggleUsuarios() {
        usuariosOpen = !usuariosOpen;
        usuariosMenu.setVisible(usuariosOpen);
        usuariosMenu.setManaged(usuariosOpen);
    }

    @FXML
    void toggleRepartidores() {
        repartidoresOpen = !repartidoresOpen;
        repartidoresMenu.setVisible(repartidoresOpen);
        repartidoresMenu.setManaged(repartidoresOpen);
    }

    private void cargarVista(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/proyectosameday/" + fxml));
            Pane newView = loader.load();

            Object controller = loader.getController();

            if (controller instanceof TableUsersViewController tableUsersViewController) {
                tableUsersViewController.setApp(app);
            }

            contentArea.getChildren().setAll(newView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {
    }
}
