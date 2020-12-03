/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 *
 * @author Owner
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML 
    private TextField usernameText; 
    
    @FXML
    private TextField passwordText; 
    
    @FXML 
    private ComboBox credentialsDropDown;
   
    @FXML
    private Button loginButton; 
    
    
    //second view 
    
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
    private TextField intakeGoalField;
    @FXML
    private TextField recentIntakeField;
    @FXML
    private Text totalCaloriesText;
    
    //third view
    @FXML
    private TextField goalField;
    
    @FXML
    private TextField caloriesRemainingField;
    
    @FXML
    private TextField motivationalMessageField;
    
    @FXML
    private Button previousButton;
    
    
    
    //end third view
    
  
    
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {

    }
    
    //first UI
    @FXML
    private void loginUser(ActionEvent event) throws IOException {
     
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InfoInputScreen.fxml")); 
       Parent InfoInputScreen = loader.load(); 
       Scene tableViewScene = new Scene(InfoInputScreen);
       
       Stage stage = new Stage();
       stage.setScene(tableViewScene);
       stage.show();
        
    }
  

    
    //Second UI
    @FXML
    private void saveIntakeGoal(ActionEvent event) {
        //save the goal they set to their name and ID in the table 
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
    
    //third UI 
    
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
    private void motivationalMessage(){
        // sets a motivational message 
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        credentialsDropDown.getItems().add("Active Cruncher");
//        credentialsDropDown.getItems().add("Personal Trainer");
//      credentialsDropDown.getItems().add("Medical Professional");


    }    
    
    //ebh
}
