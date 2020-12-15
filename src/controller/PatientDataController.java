/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Karina
 */
public class PatientDataController {
    
    @FXML
    private TextField setGoalField;

    @FXML
    private TextField calorieViewField;

    @FXML
    private TextField sendMessage;

    @FXML
    private Button setGoalButton;

    @FXML
    private Button viewCaloriesButton;

    @FXML
    private Button sendMessageButton;

    @FXML
    private Button signOutButton3;
    
    @FXML
    private Button checkHistoryButton;

    @FXML
    private void viewCalories(ActionEvent event) {
        //view the clients current calorie intake
        calorieViewField.setText("1000");
    }

    @FXML
    private void setGoal(ActionEvent event) {
        //allow trainer to set clients goal 
    }

    @FXML
    private void sendMessage(ActionEvent event) {
        //send client a motivational message 
    }

    //sign out method
    @FXML
    private void signOut(ActionEvent event) throws IOException {
        //send client a motivational message 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LoginPage.fxml"));
        Parent LoginScreen = loader.load();
        Scene tableViewScene = new Scene(LoginScreen);

        Stage stage = new Stage();
        stage.setScene(tableViewScene);
        stage.show();
    }
    
    @FXML
    private void checkHistory(ActionEvent event){
        
    }
}
