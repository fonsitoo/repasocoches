module com.edu.arf.liceo.repasocoches {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.edu.arf.liceo.repasocoches to javafx.fxml;
    exports com.edu.arf.liceo.repasocoches;
}