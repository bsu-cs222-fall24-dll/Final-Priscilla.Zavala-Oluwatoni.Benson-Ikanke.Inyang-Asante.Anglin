package edu.bsu.cs;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class MenuController extends UserView{
    private final UserModel model;
    private final UserView view;
    private final BuildURL buildURL;
    public String state = "";
    public TaskOptions taskOptions = new TaskOptions();
    public String positionChoice = "";
    public String taskID = "";
    public InStateModelView inStateModelView = new InStateModelView();
    private PositionModel currentModel;
    private PositionView currentView;

    public MenuController(UserModel model, UserView view, BuildURL buildURL) {
        this.model = model;
        this.view = view;
        this.buildURL = buildURL;


        //list is meant for initialization only and populated as part of the setup process
        //position objects are necessary for program to function, even if the list itself is not directly queried
        @SuppressWarnings("unused")
        List<PositionModel> positionModels = new ArrayList<>();
        positionModels.add(new CostAnalystModel());
        positionModels.add(new AuditorModel());
        positionModels.add(new MedicaidDataAnalystModel());
        positionModels.add(new HRDirectorModel());
    }

    private void initializeCurrentModel(String position){
        switch (position) {
            case "Cost Analyst":
                currentModel = new CostAnalystModel();
                break;
            case "Auditor":
                currentModel = new AuditorModel();
                break;
            case "HR Director":
                currentModel = new HRDirectorModel();
                break;
            case "Medicaid Data Analyst":
                currentModel = new MedicaidDataAnalystModel();
                break;
            default:
                view.displayErrorMessage("Invalid position selected.");
                break;
        }
    }

    private void initializeCurrentView(String position){
        switch (position) {
            case "Cost Analyst":
                currentView = new CostAnalystView(currentModel);
                break;
            case "Auditor":
                currentView = new AuditorView(currentModel);
                break;
            case "HR Director":
                currentView = new HRDirectorView(currentModel);
                break;
            case "Medicaid Data Analyst":
                currentView = new MedicaidDataAnalystView(currentModel);
                break;
            default:
                view.displayErrorMessage("Invalid position selected.");
                break;
        }
    }

    protected void runMenu() throws IOException, URISyntaxException {
        view.displayPositionOptions();
        String credentialID = UserInput.credentialInput();
        if (model.isValidCredential(credentialID)) {
            String welcomeRoleMessage = model.getPositionByCredential(credentialID);
            view.displayMessage("Now logged in as a " + welcomeRoleMessage + "!");
            runPositionTaskMenu(credentialID);
        } else {
            view.displayErrorMessage("Invalid credential. Please try again.");
            runMenu();
        }
    }

    protected void runPositionTaskMenu(String credentialID) throws IOException, URISyntaxException {
        String position = model.getPositionByCredential(credentialID);
        initializeCurrentModel(position);
        if (currentModel != null) {
            initializeCurrentView(position);
            displayTasksBasedOnPosition(position);
            processUserTaskInput(position);
        }
    }

    private void displayTasksBasedOnPosition(String position) {
        switch (position) {
            case "Cost Analyst" -> view.displayTasksForPosition(taskOptions.getTasksForPosition("Cost Analyst"));
            case "Auditor" -> view.displayTasksForPosition(taskOptions.getTasksForPosition("Auditor"));
            case "HR Director" -> view.displayTasksForPosition(taskOptions.getTasksForPosition("HR Director"));
            case "Medicaid Data Analyst" ->
                    view.displayTasksForPosition(taskOptions.getTasksForPosition("Medicaid Data Analyst"));
        }
    }

    private void processUserTaskInput(String position) throws IOException, URISyntaxException {
        taskID = UserInput.taskIDInput();
        boolean isValidPositionTask = false;

        switch (position) {
            case "Cost Analyst" -> {
                positionChoice = "Cost Analyst";
                isValidPositionTask = model.isValidCostAnalystSpecification(taskID);
            }
            case "Auditor" -> {
                positionChoice = "Auditor";
                isValidPositionTask = model.isValidAuditorSpecification(taskID);
            }
            case "HR Director" -> {
                positionChoice = "HR Director";
                isValidPositionTask = model.isValidHRDirectorSpecification(taskID);
            }
            case "Medicaid Data Analyst" -> {
                positionChoice = "Medicaid Data Analyst";
                isValidPositionTask = model.isValidMedicaidDataAnalystSpecification(taskID);
            }
        }

        if (isValidPositionTask) {
            view.displayMessage("Valid " + position + " task selected: " + taskID);
            runHospitalInfoMenu();
        } else {
            view.displayErrorMessage("Invalid " + position + " task. Please try again.");
            processUserTaskInput(position);
        }
    }

    private void runHospitalInfoMenu() throws IOException, URISyntaxException {
        state = buildURL.stateValidator();
        String hospitalsInStateURL = buildURL.buildStateHospitalURL(state);
        view.displayMessage("List of hospitals in state: " + hospitalsInStateURL);
        menuDisplayState();

        String hospitalID = UserInput.hospitalIDInput();
        String hospitalDataURL = buildURL.buildHospitalDataURL(hospitalID);
        view.displayMessage("Data for hospital ID: " + hospitalDataURL);
        menuDisplayHospitalID(hospitalID);
    }

    private void menuDisplayHospitalID(String hospitalID) throws IOException, URISyntaxException {
        String jsonPath = currentModel.retrieveJsonPath(taskID);
        String jsonFile = currentModel.retrieveJsonFile(hospitalID, jsonPath);
        currentModel.loadNumericJsonData(jsonFile);
        String[] jsonDataArray = currentModel.getJsonDataArray();
        String[] jsonYearArray = currentModel.getJsonYearArray();
        int maxDataWidth = currentModel.calculateMaxDataWidth();
        String title = currentModel.getTitle();
        String formattedData = currentView.formatDataForDisplay(jsonDataArray, jsonYearArray, maxDataWidth, title);
        currentView.displayFormattedData(formattedData, jsonPath);
    }

    private void menuDisplayState() throws IOException, URISyntaxException {
        inStateModelView.displayHospitalsByState(state);
    }
}