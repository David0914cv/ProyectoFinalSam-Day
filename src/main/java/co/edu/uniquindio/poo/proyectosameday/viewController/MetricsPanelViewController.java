package co.edu.uniquindio.poo.proyectosameday.viewController;

import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class MetricsPanelViewController {
    @FXML
    private BarChart<String, Number> chartTiempos;
    @FXML private PieChart chartServicios;
    @FXML private AreaChart<Number, Number> chartIngresos;
    @FXML private BarChart<String, Number> chartIncidencias;

    @FXML
    public void initialize() {
        cargarTiemposPromedio();
        cargarServiciosAdicionales();
        cargarIngresosPeriodo();
        cargarIncidenciasZona();
    }

    // ===============================
    // 1. TIEMPOS PROMEDIO
    // ===============================
    private void cargarTiemposPromedio() {
        XYChart.Series<String, Number> s = new XYChart.Series<>();
        s.setName("Tiempo promedio");

        s.getData().add(new XYChart.Data<>("Lunes", 32));
        s.getData().add(new XYChart.Data<>("Martes", 28));
        s.getData().add(new XYChart.Data<>("Miércoles", 30));

        chartTiempos.getData().add(s);
    }

    // ===============================
    // 2. SERVICIOS MÁS USADOS
    // ===============================
    private void cargarServiciosAdicionales() {
        chartServicios.getData().add(new PieChart.Data("Fragil", 45));
        chartServicios.getData().add(new PieChart.Data("Express", 30));
        chartServicios.getData().add(new PieChart.Data("Contraentrega", 25));
    }

    // ===============================
    // 3. INGRESOS POR PERIODO
    // ===============================
    private void cargarIngresosPeriodo() {
        XYChart.Series<Number, Number> s = new XYChart.Series<>();
        s.setName("Ingresos");

        s.getData().add(new XYChart.Data<>(1, 4000));
        s.getData().add(new XYChart.Data<>(2, 6000));
        s.getData().add(new XYChart.Data<>(3, 5500));

        chartIngresos.getData().add(s);
    }

    // ===============================
    // 4. INCIDENCIAS POR ZONA
    // ===============================
    private void cargarIncidenciasZona() {
        XYChart.Series<String, Number> s = new XYChart.Series<>();
        s.setName("Incidencias");

        s.getData().add(new XYChart.Data<>("Norte", 12));
        s.getData().add(new XYChart.Data<>("Sur", 5));
        s.getData().add(new XYChart.Data<>("Centro", 18));

        chartIncidencias.getData().add(s);
    }
}
