module edu.farmingdale.csc311_loan {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens edu.farmingdale.csc311_loan to javafx.fxml;
    exports edu.farmingdale.csc311_loan;
}