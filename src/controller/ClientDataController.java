/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Karina
 */
public class ClientDataController {
    
    @FXML
    private TextField setGoalField; 
    
    @FXML
    private TextField calorieViewField; 
    
    @FXML
    private TextField sendMesage; 
    
    @FXML
    private Button setGoalButton;
    
    @FXML
    private Button viewCaloriesButton;
    
    @FXML
    private Button sendMessageButton;
    
    @FXML
    private Button signOutButton3;
    
    
    @FXML
    private void viewCalories (ActionEvent event) {
      //view the clients current calorie intake
    }
    
    @FXML
    private void setGoal (ActionEvent event) {
      //allow trainer to set clients goal 
    }
    
    @FXML
    private void sendMessage (ActionEvent event) {
      //send client a motivational message 
    }
    
    //sign out method
}
