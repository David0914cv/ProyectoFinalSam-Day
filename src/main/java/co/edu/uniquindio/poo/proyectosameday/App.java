package co.edu.uniquindio.poo.proyectosameday;

import co.edu.uniquindio.poo.proyectosameday.controller.PrimaryController;
import co.edu.uniquindio.poo.proyectosameday.model.*;
import co.edu.uniquindio.poo.proyectosameday.viewController.LoginUserViewController;
import co.edu.uniquindio.poo.proyectosameday.viewController.PrimaryViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {

    public static Empresa empresa= Empresa.getInstance();

    private String user=null;
    private String name=null;
    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        inicializarData();
        openMainView();
    }

    public void openMainView(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("main-view.fxml"));
            javafx.scene.layout.BorderPane rootLayout = (javafx.scene.layout.BorderPane) loader.load();
            PrimaryViewController primaryViewController = loader.getController();
            primaryViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());
            stage.setTitle("Same-day");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openLogin() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("login-user.fxml"));
            BorderPane rootLayout = (BorderPane) loader.load();
            LoginUserViewController loginUserViewController = loader.getController();
            loginUserViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void inicializarData(){
        Persona user1 = new Usuario("David","3015112641","dabeats0914@gmail.com","123");
        Persona rp1= new Repartidor("Nico","3124579888","1234","10911789", EstadoDisponibilidad.ACTIVO);
        Administrador admin1 = new Administrador("789","Jorge Ivan Quintero","qwerty");

        empresa.agregarPersona(user1);
        empresa.agregarPersona(rp1);
        empresa.agregarAdministrador(admin1);

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        launch();
    }
}