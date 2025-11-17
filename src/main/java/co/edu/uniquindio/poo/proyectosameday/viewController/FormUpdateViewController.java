package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.App;
import co.edu.uniquindio.poo.proyectosameday.controller.FormUpdateController;
import co.edu.uniquindio.poo.proyectosameday.model.Persona;
import co.edu.uniquindio.poo.proyectosameday.model.Usuario;
import co.edu.uniquindio.poo.proyectosameday.model.dtos.PersonaDTO;
import co.edu.uniquindio.poo.proyectosameday.repository.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class FormUpdateViewController {

    App app;
    FormUpdateController controller;

    @FXML
    private TextField nombreField;

    @FXML
    private TextField correoField;

    @FXML
    private TextField telefonoField;


    @FXML
    private void onGuardar() {
        String name = nombreField.getText();
        String email = correoField.getText();
        String cell = telefonoField.getText();

        if(!MethodsRecycle.checkEmail(email)){
            MethodsRecycle.showAlert("Advertencia","El correo electronico no es valido",Alert.AlertType.WARNING);
            return;
        }

        PersonaDTO resp = controller.updateUser(app.getPersona().getId(), name, email, cell);
        new Alert(Alert.AlertType.INFORMATION, "Información actualizada con éxito").showAndWait();

        app.setPersona(resp);
        app.openMainView();
    }

    @FXML
    void initialize() {
        this.controller = new FormUpdateController(App.empresa);
    }

    public void setApp(App app) {
        this.app = app;
        Database database = Database.getInstance();
        Usuario resp = database.getUserId(app.getPersona().getId());
        nombreField.setText(resp.getNombre());
        correoField.setText(resp.getCorreo());
        telefonoField.setText(resp.getTelefono());
    }
}
