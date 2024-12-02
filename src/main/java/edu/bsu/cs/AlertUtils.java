package edu.bsu.cs;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public final class AlertUtils {
    public static void showError(String message) {
        showAlert(Alert.AlertType.ERROR, "Error", message);
    }

    public static void showInfo(String message) {
        showAlert(AlertType.INFORMATION, "Information", message);
    }

    public static void showWarning(String message) {
        showAlert(AlertType.WARNING, "Warning", message);
    }

    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
