package edu.bsu.cs;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;

//cannot make unit tests for class - requires user input and live url connection to display errors
public final class AlertUtils {
    public static void showError(String message) {
        showAlert(Alert.AlertType.ERROR, "Error", message);
    }

    public static void showInfo(String message) {
        showAlert(AlertType.INFORMATION, "Information", message);
    }

    public static String showDialogBox(String message){
        return showText(message);
    }

    private static String showText(String message){
        TextInputDialog text = new TextInputDialog(message);
        text.setTitle("Name file to Export");
        text.setHeaderText(null);
        text.showAndWait();
        return text.getEditor().getText();
    }

    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
