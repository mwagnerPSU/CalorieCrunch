/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.ComboBox;

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
    private TextField intakeGoalField;
    @FXML
    private TextField recentIntakeField;
    @FXML
    private Text totalCaloriesText;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {

    }
    
    @FXML
    private void loginUser(ActionEvent event) {
      //show the  input screen
        
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
    private void signOut(ActionEvent event) {
        
    }
    
    @FXML
    private void showTotalCalories (ActionEvent event) {
        
    }
    @FXML
    private void checkGoal(ActionEvent event) {
        
    }
    
    
    //third UI 
    
    @FXML
    private void previousPage(ActionEvent event) {
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        credentialsDropDown.getItems().add("Active Cruncher");
        credentialsDropDown.getItems().add("Personal Trainer");
        credentialsDropDown.getItems().add("Medical Professional");


    }    
    
    //ebh
}
