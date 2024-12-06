package edu.bsu.cs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExportCSV {

    public static void exportToCSV(PositionModel positionModel, String[] hospitalData, String[] hospitalYear){
        String fileName = AlertUtils.showDialogBox("");

        String directoryPath = "output/ExportedCSV/";
        File directory = new File(directoryPath);

        System.out.println("Creating directory at: " + directory.getAbsolutePath());

        if (!directory.exists()) {
            boolean dirsCreated = directory.mkdirs();
            if (!dirsCreated) {
                AlertUtils.showError("Failed to create directories: " + directoryPath);
                return; // Exit the method if directory creation failed
            }
        }

        try (FileWriter writer = new FileWriter(directoryPath + fileName+ ".csv")) {
            writer.write("Hospital Name, Year, Task, Data\n");
            for(int i = 0; i < hospitalData.length; i++){
                writer.write(String.format("%s, %s, %s, %s\n", positionModel.getHospitalName(), hospitalYear[i], positionModel.getTitle(), hospitalData[i]));

            }
            AlertUtils.showInfo("Exported data as CSV");
        } catch (IOException e) {
            ErrorProcessor.displayErrorMessage("Error creating CSV file");
        }
    }
}