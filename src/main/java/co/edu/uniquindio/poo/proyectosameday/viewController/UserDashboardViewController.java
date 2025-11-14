package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.App;
import co.edu.uniquindio.poo.proyectosameday.controller.SendingUserController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class UserDashboardViewController {

    App app;

    @FXML
    private StackPane contenidoContainer;

    @FXML
    void onMostrarActualizar() {
        cargarVista("/co/edu/uniquindio/poo/proyectosameday/form-update.fxml");
    }

    @FXML
    void onMostrarEnvios() {
        cargarVista("/co/edu/uniquindio/poo/proyectosameday/table-shapes.fxml");
    }

    @FXML
    void onLogout() {
        app.setPersona(null);
        app.setEnvioComponent(null);
        app.setCotizacion(null);

        app.openMainView();
    }

    private void cargarVista(String ruta) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(ruta));
            Pane vista = loader.load();

            Object controller = loader.getController();

            if (controller instanceof FormUpdateViewController formUpdateViewController) {
                formUpdateViewController.setApp(app); // ejemplo
            }

            if (controller instanceof TableShapesViewController enviosController) {
                enviosController.setApp(app);
            }


            contenidoContainer.getChildren().setAll(vista);

        } catch (IOException e) {
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
