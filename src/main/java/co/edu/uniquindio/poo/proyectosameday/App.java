package co.edu.uniquindio.poo.proyectosameday;

import co.edu.uniquindio.poo.proyectosameday.controller.PrimaryController;
import co.edu.uniquindio.poo.proyectosameday.model.*;
import co.edu.uniquindio.poo.proyectosameday.viewController.*;
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

    private String id =null;
    private String user=null;
    private String name=null;
    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
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

            System.out.println(empresa.getListPersonas());
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

    public void openRegister() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("register-user.fxml"));
            BorderPane rootLayout = (BorderPane) loader.load();
            RegisterUserViewController registerUserViewController = loader.getController();
            registerUserViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());
            stage.setTitle("Sign Up");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openQuote() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("quote-shipping.fxml"));
            BorderPane rootLayout = (BorderPane) loader.load();
            QuoteShippingViewController quoteShippingViewController = loader.getController();
            quoteShippingViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());
            stage.setTitle("Cotización");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openSendingUser() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("sending-user.fxml"));
            BorderPane rootLayout = (BorderPane) loader.load();
            SendingUserViewController sendingUserViewController = loader.getController();
            sendingUserViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());
            stage.setTitle("Registro en Proceso...");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public static void main(String[] args) {
        launch();
    }
}