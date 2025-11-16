package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.App;
import co.edu.uniquindio.poo.proyectosameday.model.EnvioComponent;
import co.edu.uniquindio.poo.proyectosameday.model.EstadoEnvio;
import co.edu.uniquindio.poo.proyectosameday.model.Usuario;
import co.edu.uniquindio.poo.proyectosameday.repository.Database;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;

public class TableShapesViewController {

    App app;
    Database db;

    @FXML
    private TableView<EnvioComponent> tablaEnvios;

    @FXML
    private TableColumn<EnvioComponent, String> colDestino;
    @FXML
    private TableColumn<EnvioComponent, String> colFecha;
    @FXML
    private TableColumn<EnvioComponent, EstadoEnvio> colEstado;
    @FXML
    private TableColumn<EnvioComponent, String> colPrecio;

    @FXML
    private DatePicker dateFilter;

    @FXML
    private ChoiceBox<String> choiceBoxState;

    @FXML
    void onClean(){
        tablaEnvios.setItems(FXCollections.observableArrayList(db.getListEnviosUser(app.getPersona().getId())));
    }

    @FXML
    void onSearchState(){
        String state = choiceBoxState.getValue();
        System.out.println(state);
        List<EnvioComponent>listShapes=db.getListShapesState(state);

        tablaEnvios.setItems(FXCollections.observableList(listShapes));
    }

    @FXML
    void onSearchDate(){
        LocalDate date = dateFilter.getValue();
        List<EnvioComponent>listShapes=db.getListShapesDate(date);

        tablaEnvios.setItems(FXCollections.observableList(listShapes));
    }

    @FXML
    public void initialize() {

    }

    public void setApp(App app) {
        this.app = app;
        this.db = Database.getInstance();

        colDestino.setCellValueFactory(new PropertyValueFactory<>("direccionDestino"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaEntregaFormateada"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("price"));
        System.out.println("holiii"+db.getListShapesState(app.getPersona().getId()));
        tablaEnvios.setItems(FXCollections.observableArrayList(db.getListEnviosUser(app.getPersona().getId())));

        tablaEnvios.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                mostrarDetallesEnvio(newSel);
                if (MethodsRecycle.showAlertCondicion("Confirmación","Deseas generar Reporte PDF","Destino: " + newSel.getDireccionDestino() + "\n" +
                        "Fecha: " + newSel.getFechaEntregaFormateada() + "\n" +
                        "Estado: " + newSel.getEstado() + "\n" +
                        "Precio: $" + newSel.getPrice())){

                    onGenerarPDF(newSel);

                }
            }
        });
    }

    private void mostrarDetallesEnvio(EnvioComponent envio) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Detalles del Envío");
        alert.setHeaderText("Información del envío seleccionado");
        alert.setContentText(
                "Destino: " + envio.getDireccionDestino() + "\n" +
                        "Fecha: " + envio.getFechaEntregaFormateada() + "\n" +
                        "Estado: " + envio.getEstado() + "\n" +
                        "Precio: $" + envio.getPrice()
        );
        alert.showAndWait();
    }

    void onGenerarPDF(EnvioComponent shape) {
        try {
            String route = "C:/Users/luis3/Downloads/comprobante-envio.pdf";
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(route));
            doc.open();

            // 📄 Contenido del PDF
            doc.add(new Paragraph("Comprobante de Envío"));
            doc.add(new Paragraph("Cliente: "+shape.getUsuario().getNombre()+"\n"));
            doc.add(new Paragraph("Origen: "+shape.getCiudadOrigen()+"\n"));
            doc.add(new Paragraph("Destino: "+shape.getCiudadDestino()+"\n"));
            doc.add(new Paragraph("Precio total: $"+shape.getPrice()+"\n"));
            doc.add(new Paragraph("Fecha: "+shape.getFechaEntregaFormateada()+"\n"));
            doc.add(new Paragraph("\n¡Gracias por usar Same-Day! 🚚"));

            doc.close();

            // 🔔 Mostrar alerta de éxito
            MethodsRecycle.showAlert("PDF generado","El comprobante se ha guardado correctamente en la ruta "+route,Alert.AlertType.INFORMATION);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
