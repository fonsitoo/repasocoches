module com.edu.arf.liceo.repasocoches {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.edu.arf.liceo.repasocoches to javafx.fxml;
    exports com.edu.arf.liceo.repasocoches;
}