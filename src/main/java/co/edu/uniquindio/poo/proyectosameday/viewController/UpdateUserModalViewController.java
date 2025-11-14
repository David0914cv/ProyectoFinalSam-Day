package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.App;
import co.edu.uniquindio.poo.proyectosameday.controller.FormUpdateController;
import co.edu.uniquindio.poo.proyectosameday.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateUserModalViewController {

    FormUpdateController controller;
    @FXML private TextField txtNombre;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtTelefono;

    private Usuario user;
    private Runnable onUpdateCallback;


    public void setUsuario(Usuario user) {
        this.user = user;
        this.controller = new FormUpdateController(App.empresa);
        txtNombre.setText(user.getNombre());
        txtCorreo.setText(user.getCorreo());
        txtTelefono.setText(user.getTelefono());

    }

    public void setOnUpdateCallback(Runnable callback) {
        this.onUpdateCallback = callback;
    }

    @FXML
    void onSave() {

        if (!MethodsRecycle.checkEmail(txtCorreo.getText())) {
            MethodsRecycle.showAlert("Advertencia","El correo electronico no es valido", Alert.AlertType.WARNING);
            return;
        }

        controller.updateUser(user.getId(),user.getNombre(),user.getCorreo(),user.getTelefono());
        user.setNombre(txtNombre.getText());
        user.setCorreo(txtCorreo.getText());
        user.setTelefono(txtTelefono.getText());


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
