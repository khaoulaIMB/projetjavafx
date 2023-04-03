module com.fsttanger.khawlaproject {
    requires javafx.controls;

    requires javafx.fxml;
    requires java.sql;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.fsttanger.khawlaproject to javafx.fxml;
    exports com.fsttanger.khawlaproject;
}