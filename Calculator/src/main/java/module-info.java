module org.openjfx.Calculator {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;
	requires javafx.base;

    opens org.openjfx.Calculator to javafx.fxml;
    exports org.openjfx.Calculator;
}