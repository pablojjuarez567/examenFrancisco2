module com.example.examenjrfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.examenjrfx to javafx.fxml;
    exports com.example.examenjrfx;
}