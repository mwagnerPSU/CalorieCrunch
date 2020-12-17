/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.History;

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
    
    public String searchedUsername;
    
    EntityManager manager;
    
    public void initData(String searchedUser){
        searchedUsername = searchedUser;
    }
    @FXML
    private void viewCalories(ActionEvent event) {
        //view the clients current calorie intake
        calorieViewField.setText(readByUsernameCalS(searchedUsername));
    }

    @FXML
    private void setGoal(ActionEvent event) {
        //allow trainer to set clients goal 
        History newHistory = new History();
        newHistory.setId(readByUsernameID(searchedUsername));
        newHistory.setUsername(searchedUsername);
        newHistory.setDate(new Date());
        newHistory.setCurrentgoal(Integer.parseInt(setGoalField.getText()));
        newHistory.setCurrentcalories(readByUsernameCals(searchedUsername));
        
        createHistory(newHistory);
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
    
    public void createHistory(History newHistory) {
        try {
            // begin transaction
            manager.getTransaction().begin();
            
            // sanity check
            if (newHistory.getId() != null) {
                
                // create student
                manager.persist(newHistory);
                
                // end transaction
                manager.getTransaction().commit();
                
                System.out.println("Added: ID: " + newHistory.getId() + " | Username: " + newHistory.getUsername() + " | Date:" + newHistory.getDate() + " | Current Goal: " + newHistory.getCurrentgoal() + " | Current Calories: " + newHistory.getCurrentcalories());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int readByUsernameID(String username){
        Query query = manager.createNamedQuery("History.findByUsername");
        
        // setting query parameter
        query.setParameter("username", username);
        
        // execute query
        History result = (History) query.getSingleResult();
        if (result != null){
            System.out.println("Id: " + result.getId() + " | Username: " + result.getUsername() + " | Date" + result.getDate() + " | Current Goal: " + result.getCurrentgoal() + " | Current Calories: " + result.getCurrentcalories());
        }
        
        return result.getId();        
    }
    
    public int readByUsernameCals(String username){
        Query query = manager.createNamedQuery("History.findByUsername");
        
        // setting query parameter
        query.setParameter("username", username);
        
        // execute query
        History result = (History) query.getSingleResult();
        if (result != null){
            System.out.println("Id: " + result.getId() + " | Username: " + result.getUsername() + " | Date" + result.getDate() + " | Current Goal: " + result.getCurrentgoal() + " | Current Calories: " + result.getCurrentcalories());
        }
        
        return result.getCurrentcalories();        
    }
    
    public String readByUsernameCalS(String username){
        Query query = manager.createNamedQuery("History.findByUsername");
        
        // setting query parameter
        query.setParameter("username", username);
        
        // execute query
        History result = (History) query.getSingleResult();
        if (result != null){
            System.out.println("Id: " + result.getId() + " | Username: " + result.getUsername() + " | Date" + result.getDate() + " | Current Goal: " + result.getCurrentgoal() + " | Current Calories: " + result.getCurrentcalories());
        }
        
        return result.getCurrentcalories().toString();        
    }
    
}
