package edu.bsu.cs;

import java.util.Scanner;

public class UserInput {
    private static final Scanner scanner = new Scanner(System.in);
    private static String hospitalID;

    protected static String credentialInput() {
        System.out.println("Please enter your credentials based on your position:");
        return scanner.nextLine();
    }

    protected static String stateInput() {
        System.out.println("Please enter a state to view a list of hospitals within that state:");
        return scanner.nextLine().toUpperCase();
    }

    protected static String hospitalIDInput() {
        System.out.println("Please enter a hospital ID to view retrieve data from that hospital:");
        hospitalID = scanner.nextLine();
        return hospitalID;
    }

    protected static String taskIDInput() {
        System.out.println("Please specify your task to view the corresponding data:");
        return scanner.nextLine();
    }

    protected static String getHospitalID(){
        return hospitalID;
    }
}
