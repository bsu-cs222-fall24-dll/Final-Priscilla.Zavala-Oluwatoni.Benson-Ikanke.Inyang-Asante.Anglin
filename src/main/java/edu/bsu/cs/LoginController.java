package edu.bsu.cs;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.net.URL;

public class LoginController extends Controller{
    public MenuItem closeApplication;

    @FXML
    private PasswordField credentialsPassword;

    public void handleKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            login();
        }
    }

    @FXML
    private Label infoLabel;

    public void login() {
        try {
            if (model.isValidCredential(credentialsPassword.getText())) {
                String password = credentialsPassword.getText();
                String fxmlFile;
                String role;

                switch (password) {
                    case "100":
                        role = "Cost Analyst";
                        fxmlFile = "/CostAnalystView.fxml";
                        break;
                    case "200":
                        role = "Auditor";
                        fxmlFile = "/AuditorView.fxml";
                        break;
                    case "300":
                        role = "HR Director";
                        fxmlFile = "/HRDirectorView.fxml";
                        break;
                    case "400":
                        role = "Medicaid Data Analyst";
                        fxmlFile = "/MedicaidAnalystView.fxml";
                        break;
                    default:
                        showAlert("Unknown role");
                        return;
                }

                infoLabel.setText(role);

                Stage stage = (Stage) credentialsPassword.getScene().getWindow();
                stage.close();

                URL resource = getClass().getResource(fxmlFile);
                if (resource == null) {
                    showAlert("FXML file not found: " + fxmlFile);
                    return;
                }

                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
                Parent root = loader.load();

                Controller controller = loader.getController();
                controller.stateComboBox.setItems(showStates());
                controller.setTaskOptions();

                Stage newStage = new Stage();
                newStage.setTitle(role + " Dashboard");
                newStage.setScene(new Scene(root));
                newStage.show();

            } else {
                showAlert("Incorrect password");
            }

        } catch (Exception e) {
            showAlert("Program failed");
        }
    }

    @SuppressWarnings("unused")
    public void handleClose(ActionEvent actionEvent) {
        System.exit(0);
    }

    @Override
    public ObservableList<String> taskOptions() {
        return null;
    }

    @Override
    protected void setTaskOptions() {

    }

    @SuppressWarnings("unused")
    public void aboutLogin(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Login");
        alert.setHeaderText("About & How to Login to Hospital Data App");
        alert.setContentText("""
                This application connects to a hospital API to display respective data. \n
                To login as a Cost Analyst enter credential ID: 100 \n
                To login as an Auditor enter credential ID: 200 \n
                To login as a HR Director enter credential ID: 300 \n
                To login as a Medicaid Analyst enter credential ID: 400 \n
                To close GUI Application, click "Close" under the File button.
                
                Team Members: Priscilla Zavala, Ikanke Inyang, Asante Anglin, Toni Benson.""");
        alert.setResizable(false);
        alert.showAndWait();
    }
}