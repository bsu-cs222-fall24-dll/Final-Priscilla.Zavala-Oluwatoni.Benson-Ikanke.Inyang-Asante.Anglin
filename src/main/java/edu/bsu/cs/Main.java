package edu.bsu.cs;

public class Main {
    public static void main(String[] args){
        UserModel model = new UserModel();
        UserView view = new UserView();
        BuildURL buildURL = new BuildURL();
        MenuController controller = new MenuController(model, view, buildURL);
        controller.runMenu();
        //will have hospitals in state and hospital data displayed in list format from json docs
    }
}
