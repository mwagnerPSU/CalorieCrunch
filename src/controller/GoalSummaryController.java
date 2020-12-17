/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.History;
import model.Person;

/**
 *
 * @author Karina
 */
public class GoalSummaryController implements Initializable{
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
    
    @FXML
    private Button showGoal;
    
    EntityManager manager;
    public void initialize(URL url, ResourceBundle rb) {
        
        manager = (EntityManager) Persistence.createEntityManagerFactory("CalorieCrunchFXMLPU").createEntityManager();
        
        motivationalMessage("Keep going! You still have time!");
        
//        id.setCellValueFactory(new PropertyValueFactory<>("Id"));
//        username.setCellValueFactory(new PropertyValueFactory<>("Username"));
//        password.setCellValueFactory(new PropertyValueFactory<>("Password"));
//        credentials.setCellValueFactory(new PropertyValueFactory<>("Credentials"));
//        currentCalories.setCellValueFactory(new PropertyValueFactory<>("Currentcalories"));
//
//        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
    }
    
    String currentUser;
    
    public void initData(String username){
        currentUser = username;
        
    }
        
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
    private void showGoal(ActionEvent event){
        goalText.setText(String.valueOf(readByUsername(currentUser).getCurrentgoal()));
    }
    
    @FXML
    private void showCaloriesRemaining(ActionEvent event){
        int goalCals = readByUsername(currentUser).getCurrentgoal();
        int currentCals  = readByUsername(currentUser).getCurrentcalories();
        int calsLeft = goalCals - currentCals;
        
        caloriesRemainingText.setText(String.valueOf(calsLeft));
    }
    
    @FXML 
    private TextField motivationalMessage(String message){
        // sets a motivational message 
        motivationalMessageField.setText(message);
        
        return motivationalMessageField;
    }
    
    public String readByUsernameGoal(String username){
        Query query = manager.createNamedQuery("History.findByUsername");
        
        // setting query parameter
        query.setParameter("username", username);
        
        // execute query
        History result = (History) query.getSingleResult();
        if (result != null){
            System.out.println("Id: " + result.getId() + " | Username: " + result.getUsername() + " | Date" + result.getDate() + " | Current Goal: " + result.getCurrentgoal() + " | Current Calories: " + result.getCurrentcalories());
        }
        
        return result.getCurrentgoal().toString();        
    }
    
    public String readByUsernameCals(String username){
        Query query = manager.createNamedQuery("Person.findByUsername");
        
        // setting query parameter
        query.setParameter("username", username);
        
        // execute query
        Person result = (Person) query.getSingleResult();
        if (result != null){
            System.out.println("Id: " + result.getId() + " | Username: " + result.getUsername() + " | Password" + result.getPassword() + " | Credentials: " + result.getCredentials() + " | Current Calories: " + result.getCurrentcalories());
        }
        
        return result.getCurrentcalories().toString();        
    }
    
    public Person readByUsername(String username){
        Query query = manager.createNamedQuery("Person.findByUsername");
        
        // setting query parameter
        query.setParameter("username", username);
        
        // execute query
        Person result = (Person) query.getSingleResult();
        if (result != null){
            System.out.println("Id: " + result.getId() + " | Username: " + result.getUsername() + " | Password" + result.getPassword() + " | Credentials: " + result.getCredentials() + " | Current Calories: " + result.getCurrentcalories());
        }
        
        return result;        
    }
}
