module com.edu.arf.liceo.repasocoches {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    // Permiso para que los FXML usen tus Controladores
    opens com.edu.arf.liceo.repasocoches.controller to javafx.fxml;

    // Permiso para que la Tabla lea los datos de tus Coches
    opens com.edu.arf.liceo.repasocoches.model to javafx.base;

    exports com.edu.arf.liceo.repasocoches;
}