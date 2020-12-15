/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.History;

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
    
    EntityManager manager;
    
     @FXML
    private Text goalText = new Text();
    
    @FXML
    private Button totalCals;
    
    public String calorieHolder = "Hello";
    
    public LoginPageController loginCont = new LoginPageController();
    
    //public String currentUsername;

//    public void setCurrentUsername(String currentUsername) {
//        this.currentUsername = currentUsername;
//    }
//    
    
    
    public void create(History newHistory) {
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
    
    
        @FXML
    public void saveIntakeGoal(ActionEvent event) {
        //save the goal they set to their name and ID in the table
        calorieHolder = intakeGoalField.getText();
        System.out.println(calorieHolder + "save");
            System.out.println(loginCont.getCurrentUsername());
            //System.out.println(currentUsername);
        
        History newHistory = new History();
        
        newHistory.setId(readAll().size() + 1);
        newHistory.setUsername(loginCont.getCurrentUsername());
//        newHistory.setFirstname(fName);
//        newHistory.setLastname(lName);
        
        create(newHistory);
        
    }
    
    @FXML
    private void setCalText(ActionEvent event){
        totalCaloriesText.setText("1000");
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
       Parent GoalSummaryScreen = loader.load(); 
       Scene tableViewScene = new Scene(GoalSummaryScreen);
       
       Stage stage = new Stage();
       stage.setScene(tableViewScene);
       stage.show();
    }
    
//     public void update(History model) {
//        try {
//
//            MedicalProfessionalModel existingMedicalProfessional = manager.find(MedicalProfessionalModel.class, model.getId());
//
//            if (existingMedicalProfessional != null) {
//                // begin transaction
//                manager.getTransaction().begin();
//                
//                // update all atttributes
//                existingMedicalProfessional.setFirstname(model.getFirstname());
//                existingMedicalProfessional.setLastname(model.getLastname());
//                existingMedicalProfessional.setCredentials(model.getCredentials());
//                
//                // end transaction
//                manager.getTransaction().commit();
//            }
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
    
    
    public History readByUsername(String username){
        Scanner userInput = new Scanner(System.in);
        Query query = manager.createNamedQuery("History.findByUsername");
        
        // setting query parameter
        query.setParameter("username", username);
        
        // execute query
        History result = (History) query.getSingleResult();
        if (result != null){
            System.out.println("Id: " + result.getId() + " | Username: " + result.getUsername() + " | Date" + result.getDate() + " | Current Goal: " + result.getCurrentgoal() + " | Current Calories: " + result.getCurrentcalories());
        }
        
        return result;        
    }
    
    public List<History> readAll(){
        Query query = manager.createNamedQuery("History.findAll");
        List<History> history = query.getResultList();

        for (History p : history) {
            System.out.println("ID: " + p.getId() + " | Name: " + p.getUsername() + " | Date:" + p.getDate() + " | Current Goal: " + p.getCurrentgoal() + " | Current Calories: " + p.getCurrentcalories());
        }
        
        return history;
    }
}
