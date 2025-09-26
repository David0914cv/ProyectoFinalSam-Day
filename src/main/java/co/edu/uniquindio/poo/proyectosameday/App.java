package co.edu.uniquindio.poo.proyectosameday;

import co.edu.uniquindio.poo.proyectosameday.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    public static Empresa empresa= Empresa.getInstance();


    @Override
    public void start(Stage stage) throws IOException {
        inicializarData();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void inicializarData(){
        Persona user1 = new Usuario("David","3015112641","dabeats0914@gmail.com","123");
        Persona rp1= new Repartidor("Nico","3124579888","1234","10911789", EstadoDisponibilidad.ACTIVO);

        empresa.agregarPersona(user1);
        empresa.agregarPersona(rp1);

    }

    public static void main(String[] args) {
        launch();
    }
}