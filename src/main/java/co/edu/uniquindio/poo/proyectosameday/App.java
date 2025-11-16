package co.edu.uniquindio.poo.proyectosameday;

import co.edu.uniquindio.poo.proyectosameday.controller.PrimaryController;
import co.edu.uniquindio.poo.proyectosameday.model.*;
import co.edu.uniquindio.poo.proyectosameday.model.dtos.AdministradorDTO;
import co.edu.uniquindio.poo.proyectosameday.model.dtos.PersonaDTO;
import co.edu.uniquindio.poo.proyectosameday.viewController.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {

    public static Empresa empresa= Empresa.getInstance();

    private PersonaDTO persona =null;
    private AdministradorDTO admin=null;
    private Cotizacion cotizacion =null;
    private EnvioComponent envioComponent = null;

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

            ajustarPantallaCompleta(stage,rootLayout);

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

            ajustarPantallaCompleta(stage,rootLayout);

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
            ajustarPantallaCompleta(stage,rootLayout);
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
            ajustarPantallaCompleta(stage,rootLayout);
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
            ajustarPantallaCompleta(stage,rootLayout);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openAdmin() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("admin.fxml"));
            BorderPane rootLayout = (BorderPane) loader.load();
            AdminViewController adminViewController = loader.getController();
            adminViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());
            stage.setTitle("Administrador");
            stage.setScene(scene);
            ajustarPantallaCompleta(stage,rootLayout);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openPaymentMethod() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("payment-method.fxml"));
            BorderPane rootLayout = (BorderPane) loader.load();
            PaymentMethodViewController paymentMethodViewController = loader.getController();
            paymentMethodViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());
            stage.setTitle("Metodo de pago");
            stage.setScene(scene);
            ajustarPantallaCompleta(stage,rootLayout);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openUserDashboard() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("user-dashboard.fxml"));
            BorderPane rootLayout = (BorderPane) loader.load();
            UserDashboardViewController userDashboardViewController = loader.getController();
            userDashboardViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());
            stage.setTitle("Perfil");
            stage.setScene(scene);
            ajustarPantallaCompleta(stage,rootLayout);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openDealerDashboard() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("dealer-dashboard.fxml"));
            BorderPane rootLayout = (BorderPane) loader.load();
            DealerDashboardViewController dealerDashboardViewController = loader.getController();
            dealerDashboardViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());
            stage.setTitle("Vista repartidor");
            stage.setScene(scene);
            ajustarPantallaCompleta(stage,rootLayout);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void ajustarPantallaCompleta(Stage stage, BorderPane root) {

        stage.setResizable(true);
        stage.setFullScreen(false);

        if (stage.getScene() == null) {
            stage.setScene(new Scene(root));
        } else {
            stage.getScene().setRoot(root);
        }

        if (!stage.isShowing()) stage.show();


        try {
            root.prefWidthProperty().unbind();
            root.prefHeightProperty().unbind();
        } catch (Exception ignored) {}


        Platform.runLater(() -> {
            Rectangle2D vb = Screen.getPrimary().getVisualBounds();

            root.prefWidthProperty().bind(stage.widthProperty());
            root.prefHeightProperty().bind(stage.heightProperty());

            stage.setX(vb.getMinX());
            stage.setY(vb.getMinY());
            stage.setWidth(vb.getWidth());
            stage.setHeight(vb.getHeight());

            Platform.runLater(() -> {
                root.requestLayout();
                stage.setMaximized(true);
                stage.sizeToScene();
                root.requestLayout();
               });
        });
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    public AdministradorDTO getAdmin() {
        return admin;
    }

    public void setAdmin(AdministradorDTO admin) {
        this.admin = admin;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public EnvioComponent getEnvioComponent() {
        return envioComponent;
    }

    public void setEnvioComponent(EnvioComponent envioComponent) {
        this.envioComponent = envioComponent;
    }

    public static void main(String[] args) {
        launch();
    }
}