module com.misiontic.informes {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.misiontic.informes to javafx.fxml;
    exports com.misiontic.informes;
}