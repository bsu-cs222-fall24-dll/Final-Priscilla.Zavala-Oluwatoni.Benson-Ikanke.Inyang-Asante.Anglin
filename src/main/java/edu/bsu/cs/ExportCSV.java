package edu.bsu.cs;

import java.io.File;
import java.io.FileWriter;

//known class handles business logic and controller flow - UNABLE TO REFACTOR TO SEPARATE
//attempt to refactor class to separate into model and controller, error consistently occurs with exporting
public class ExportCSV {
    static UserView view = new UserView();

    public static void exportToCSV(PositionModel positionModel, String[] hospitalData, String[] hospitalYear){
        String directoryPath = "output/ExportedCSV/";
        File directory = new File(directoryPath);
        view.displayMessage("Creating directory at: " + directory.getAbsolutePath());

        //cannot create unit tests as requires direct access to user directory
        if (!directory.exists()) {
            boolean dirsCreated = directory.mkdirs();
            if (!dirsCreated) {
                AlertUtils.showError("Failed to create directories: " + directoryPath);
                return;
            }
        }

        //cannot write user test as requires user input to retrieve hospital name & year
        String fileName = AlertUtils.showDialogBox("");
        try (FileWriter writer = new FileWriter(directoryPath + fileName + ".csv")) {
            writer.write("Hospital Name, Year, Task, Data\n");
            for(int i = 0; i < hospitalData.length; i++){
                writer.write(String.format("%s, %s, %s, %s\n", positionModel.getHospitalName(), hospitalYear[i],
                        positionModel.getTitle(), hospitalData[i]));
            }
            AlertUtils.showInfo("Exported data as CSV");
        } catch (Exception e) {
            AlertUtils.showError("Data not found");
        }
    }
}