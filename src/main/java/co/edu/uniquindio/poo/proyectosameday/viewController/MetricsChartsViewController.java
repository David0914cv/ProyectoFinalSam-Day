package co.edu.uniquindio.poo.proyectosameday.viewController;

import co.edu.uniquindio.poo.proyectosameday.App;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart.Data;

public class MetricsChartsViewController {

    @FXML
    private LineChart<String, Number> lineChartTiempo;

    @FXML
    private BarChart<String, Number> barChartServicios;

    @FXML
    private PieChart pieChartIncidencias;

    private App app;

    public void setApp(App app) {
        this.app = app;
    }

    /**
     * Carga datos de ejemplo en los gráficos.
     * Luego tú los traes desde la BD o tu servicio.
     */
    private void cargarDatos() {
        cargarLineaTiempo();
        cargarBarrasServicios();
        cargarPieIncidencias();
    }

    private void cargarLineaTiempo() {
        LineChart.Series<String, Number> serie = new LineChart.Series<>();
        serie.setName("Tiempo promedio");

        serie.getData().add(new LineChart.Data<>("Lunes", 42));
        serie.getData().add(new LineChart.Data<>("Martes", 38));
        serie.getData().add(new LineChart.Data<>("Miércoles", 45));
        serie.getData().add(new LineChart.Data<>("Jueves", 40));
        serie.getData().add(new LineChart.Data<>("Viernes", 36));

        lineChartTiempo.getData().add(serie);
    }

    private void cargarBarrasServicios() {
        BarChart.Series<String, Number> serie = new BarChart.Series<>();
        serie.setName("Uso de servicios");

        serie.getData().add(new XYChart.Data<>("Envío normal", 120));
        serie.getData().add(new XYChart.Data<>("Fragil", 75));
        serie.getData().add(new XYChart.Data<>("Seguro extra", 50));
        serie.getData().add(new XYChart.Data<>("Prioritaria", 110));
        serie.getData().add(new XYChart.Data<>("Firma requerida", 110));

        barChartServicios.getData().add(serie);
    }

    private void cargarPieIncidencias() {
        pieChartIncidencias.getData().add(new PieChart.Data("CALARCA", 10));
        pieChartIncidencias.getData().add(new PieChart.Data("ARMENIA", 25));
        pieChartIncidencias.getData().add(new PieChart.Data("CIRCASIA", 15));
        pieChartIncidencias.getData().add(new PieChart.Data("FILANDIA", 20));
        pieChartIncidencias.getData().add(new PieChart.Data("SALENTO", 5));
        pieChartIncidencias.getData().add(new PieChart.Data("PIJAO", 5));
        pieChartIncidencias.getData().add(new PieChart.Data("PIJAO", 5));
    }

    @FXML
    public void initialize() {
        cargarDatos();
    }


}