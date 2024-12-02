package edu.bsu.cs;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.net.URL;

public class LoginController extends Controller{

    @FXML
    private PasswordField credentialsPassword;

    @FXML
    private Label infoLabel;

    public void login(ActionEvent actionEvent) {
        try {
            if (model.isValidCredential(credentialsPassword.getText())) {
                String password = credentialsPassword.getText();
                String fxmlFile = "";
                String role = "";

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

                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
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
            e.printStackTrace();
            showAlert("Program failed");
        }
    }

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
}