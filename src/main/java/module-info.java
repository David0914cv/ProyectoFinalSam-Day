module co.edu.uniquindio.poo.proyectosameday {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.unsupported.desktop;
    requires com.github.librepdf.openpdf;
    requires javafx.base;
    requires javafx.graphics;



    opens co.edu.uniquindio.poo.proyectosameday to javafx.fxml;
    exports co.edu.uniquindio.poo.proyectosameday;
    exports co.edu.uniquindio.poo.proyectosameday.viewController;
    opens co.edu.uniquindio.poo.proyectosameday.viewController to javafx.fxml;
    opens co.edu.uniquindio.poo.proyectosameday.model to javafx.base;

}