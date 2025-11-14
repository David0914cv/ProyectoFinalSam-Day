package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.App;
import co.edu.uniquindio.poo.proyectosameday.controller.AdminController;
import co.edu.uniquindio.poo.proyectosameday.controller.FormUpdateController;
import co.edu.uniquindio.poo.proyectosameday.model.Repartidor;
import co.edu.uniquindio.poo.proyectosameday.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateDealerModalViewController {
    AdminController controller;
    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    private Repartidor dealer;
    private Runnable onUpdateCallback;


    public void setDealer(Repartidor dealer) {
        this.dealer = dealer;
        this.controller = new AdminController(App.empresa);
        txtNombre.setText(dealer.getNombre());
        txtTelefono.setText(dealer.getTelefono());

    }

    public void setOnUpdateCallback(Runnable callback) {
        this.onUpdateCallback = callback;
    }

    @FXML
    void onSave() {

        controller.updateDealer(dealer.getId(),dealer.getNombre(),dealer.getTelefono());
        dealer.setNombre(txtNombre.getText());
        dealer.setTelefono(txtTelefono.getText());

        if (onUpdateCallback != null) {
            onUpdateCallback.run();
        }

        close();
    }

    @FXML
    void onCancel() {
        close();
    }

    private void close() {
        Stage stage = (Stage) txtNombre.getScene().getWindow();
        stage.close();
    }
}
