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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Karina
 */
public class GoalSummaryController {
        @FXML
    private Text goalText = new Text();
    
    @FXML
    private Text caloriesRemainingText = new Text();
    
    @FXML
    private TextField motivationalMessageField = new TextField();
    
    @FXML
    private Button caloriesRemainingButton;
    
    @FXML
    private Button previousButton;
    
    @FXML private Button showGoal;
    
    
    
        
    @FXML
    private void previousPage(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InfoInputScreen.fxml")); 
       Parent InfoInputScreen = loader.load(); 
       Scene tableViewScene = new Scene(InfoInputScreen);
       
       Stage stage = new Stage();
       stage.setScene(tableViewScene);
       stage.show();
    }
    
    @FXML 
    private void displayGoal(){
        //takes the text that was put on the previous UI intakeGoal method / text field 
    }
    
    @FXML
    private void showCaloriesRemaining(ActionEvent event){
        caloriesRemainingText.setText("1500");
    }
    
    @FXML 
    private TextField motivationalMessage(String message){
        // sets a motivational message 
        motivationalMessageField.setText(message);
        
        return motivationalMessageField;
    }
}
