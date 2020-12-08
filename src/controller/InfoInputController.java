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
public class InfoInputController {
    @FXML
    private Button checkGoalButton;
    
    @FXML
    private Button signOutButton;
    @FXML
    private Button saveGoalButton;
    @FXML
    private Button updateIntakeButton;
    @FXML
    private Button totalCaloriesButton;
    
    @FXML
    private TextField intakeGoalField = new TextField();
    @FXML
    private TextField recentIntakeField;
    @FXML
    private Text totalCaloriesText;
    
     @FXML
    private Text goalText = new Text();
    
    @FXML
    private Button totalCals;
    
    public String calorieHolder = "Hello";
    
    
    
        @FXML
    public void saveIntakeGoal(ActionEvent event) {
        //save the goal they set to their name and ID in the table
        calorieHolder = intakeGoalField.getText();
        System.out.println(calorieHolder + "save");
    }
    
    @FXML
    private void showGoal(ActionEvent event){
        System.out.println(calorieHolder + "show");
        goalText.setText("2000");
    }
    
    @FXML
    private void setCalText(ActionEvent event){
        totalCaloriesText.setText("500");
    }
    
    @FXML
    private void updateIntake(ActionEvent event) {
        // update their current intake in the table 
    }
    @FXML
    private void signOut(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LoginPage.fxml")); 
       Parent InfoInputScreen = loader.load(); 
       Scene tableViewScene = new Scene(InfoInputScreen);
       
       Stage stage = new Stage();
       stage.setScene(tableViewScene);
       stage.show();   
    }
    
    @FXML
    private void intakeGoal(){
       //sets this text into the table for the person logged in 
       //gets the text to give to the goal text in UI 3 
       
    }
    
    
    @FXML
    private void showTotalCalories (ActionEvent event) {
      //takes the most updated number from recent intake and subtrrracts from the goal and displays in the text field 
    }
    
    @FXML
    private void checkGoal(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/GoalSummaryPage.fxml")); 
       Parent InfoInputScreen = loader.load(); 
       Scene tableViewScene = new Scene(InfoInputScreen);
       
       Stage stage = new Stage();
       stage.setScene(tableViewScene);
       stage.show();
    }
}
