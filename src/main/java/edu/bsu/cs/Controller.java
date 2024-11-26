package edu.bsu.cs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

public abstract class Controller {
    UserModel model = new UserModel();
    InStateModel inStateModel = new InStateModel();
    @FXML
    ObservableList<String> observableList = FXCollections.observableArrayList();

    @FXML
    ComboBox<String> stateComboBox;

    @FXML
    ListView<String> stateSelectionHospitals;

    public void selectionHandler(String state) throws IOException, URISyntaxException {
        //Based on the state use the build url to get the list of hospitals in the state
        clearListView();
        stateSelectionHospitals.setItems(retrieveInStateHospitals(state));
    }

    public void logout(ActionEvent actionEvent) {
        Alert alert = confirmationAlert("Are you sure you want to logout?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.close();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
                Parent root = loader.load();

                Stage loginStage = new Stage();
                loginStage.setTitle("Login");
                loginStage.setScene(new Scene(root));
                loginStage.show();

            } catch (Exception e) {
                showAlert("Failed to load login screen");
            }
        }
    }

    public void stateSelector(ActionEvent actionEvent){
        stateComboBox.setOnAction(event -> {
            String selectedState = stateComboBox.getSelectionModel().getSelectedItem();
            if (selectedState != null) {
                try {
                    selectionHandler(selectedState);
                } catch (IOException | URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public ObservableList<String> showStates() {
        return FXCollections.observableArrayList(
                "AL", "AK", "AZ", "AR", "CA",
                "CO", "CT", "DE", "FL", "GA",
                "HI", "ID", "IL", "IN", "IA",
                "KS", "KY", "LA", "ME", "MD",
                "MA", "MI", "MN", "MS", "MO",
                "MT", "NE", "NV", "NH", "NJ",
                "NM", "NY", "NC", "ND", "OH",
                "OK", "OR", "PA", "RI", "SC",
                "SD", "TN", "TX", "UT", "VT",
                "VA", "WA", "WV", "WI", "WY"
        );
    }

    public ObservableList<String> retrieveInStateHospitals(String stateSelection) throws IOException, URISyntaxException {
        inStateModel.formatHospitalInfoJsonData(stateSelection);
        // Combine hospital names and IDs and add to the observable list
        for (int i = 0; i < inStateModel.getJsonHospitalNameArray().length; i++) {
            // Format each hospital name with its corresponding ID
            String hospitalInfo = inStateModel.jsonHospitalNameArray[i] + " (ID: " + inStateModel.getJsonHospitalIDArray()[i] + ")";
            observableList.add(hospitalInfo);
        }
        return observableList;
    }

    public void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private Alert confirmationAlert(String message){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText(null);
        alert.setContentText(message);
        return alert;
    }

    private void clearListView(){
        observableList.clear();
    }

}