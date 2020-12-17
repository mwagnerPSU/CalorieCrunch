/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
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
public class InfoInputController implements Initializable{
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
    
    @FXML
    private Text goalText = new Text();
    
    @FXML
    private Button totalCals;

    String currentUser;
    String credentials;
    
    public void initData(String username, String creds){
        currentUser = username;
        credentials = creds;
        
        System.out.println("Welcome " + currentUser);
        System.out.println("Creds: " + credentials);
    }
    
    EntityManager manager;
    public void initialize(URL url, ResourceBundle rb) {
        
        manager = (EntityManager) Persistence.createEntityManagerFactory("CalorieCrunchFXMLPU").createEntityManager();
        
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
    
    public void updatePerson(Person model) {
        try {

            Person existingPerson = manager.find(Person.class, model.getUsername());

            if (existingPerson != null) {
                // begin transaction
                manager.getTransaction().begin();
                
                // update current calories
                existingPerson.setCurrentcalories(model.getCurrentcalories());
                existingPerson.setCurrentgoal(model.getCurrentgoal());
                
                // end transaction
                manager.getTransaction().commit();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    @FXML
    public void saveIntakeGoal(ActionEvent event) {
        //save the goal they set to their name and ID in the table
        System.out.println("Save");
        
        int idSize = readAll().size() + 1;
        int currCals = readByUsername(currentUser).getCurrentcalories();

        History newHistory = new History();
        
        newHistory.setId(idSize);
        newHistory.setUsername(currentUser);
        newHistory.setDate(new Date());
        newHistory.setCurrentgoal(Integer.parseInt(intakeGoalField.getText()));
        newHistory.setCurrentcalories(currCals);
        
        createHistory(newHistory);
        
        
        int idPerson = readByUsername(currentUser).getId();
        String password = readByUsername(currentUser).getPassword();
        String currCredentials = readByUsername(currentUser).getCredentials();
        int currCalsPerson = readByUsername(currentUser).getCurrentcalories();
        int currGoal = Integer.parseInt(intakeGoalField.getText());
        
        Person updatedPerson = new Person();
        
        updatedPerson.setId(idPerson);
        updatedPerson.setUsername(currentUser);
        updatedPerson.setPassword(password);
        updatedPerson.setCredentials(currCredentials);
        updatedPerson.setCurrentcalories(currCalsPerson);
        updatedPerson.setCurrentgoal(currGoal);
        
        updatePerson(updatedPerson);
    }
    
    @FXML
    private void updateIntake(ActionEvent event) {
        System.out.println("update");
        
        // update their current intake in the history and person table 
        int idSize = readAll().size() + 1;
        int currCals = readByUsername(currentUser).getCurrentcalories();
        int currGoal = readByUsername(currentUser).getCurrentgoal();
        
        History newHistory = new History();
        newHistory.setId(idSize);
        newHistory.setUsername(currentUser);
        newHistory.setDate(new Date());
        newHistory.setCurrentgoal(currGoal);
        newHistory.setCurrentcalories(currCals);
        
        createHistory(newHistory);
        
        int idPerson = readByUsername(currentUser).getId();
        String password = readByUsername(currentUser).getPassword();
        String currCredentials = readByUsername(currentUser).getCredentials();
        int oldCals = Integer.parseInt(readByUsernameP(currentUser));
        int newCals = Integer.parseInt(recentIntakeField.getText());
        int currCalsPerson = oldCals + newCals;
        int currGoalP = readByUsername(currentUser).getCurrentgoal();
        
        Person updatedPerson = new Person();
        
        updatedPerson.setId(idPerson);
        updatedPerson.setUsername(currentUser);
        updatedPerson.setPassword(password);
        updatedPerson.setCredentials(currCredentials);
        updatedPerson.setCurrentcalories(currCalsPerson);
        updatedPerson.setCurrentgoal(currGoalP);
        
        updatePerson(updatedPerson);
    }
    
    @FXML
    private void setCalText(ActionEvent event){
        System.out.println("set cal");
        
        //save new intake goal to history table
        
        totalCaloriesText.setText(readByUsernameP(currentUser));
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
       GoalSummaryController goalSumCont = loader.getController();
       goalSumCont.initData(currentUser);
       
       Stage stage = new Stage();
       stage.setScene(tableViewScene);
       stage.show();
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
    
    public String readByUsernameP(String username){
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
    
    public List<History> readAll(){
        Query query = manager.createNamedQuery("History.findAll");
        List<History> history = query.getResultList();

        for (History p : history) {
            System.out.println("ID: " + p.getId() + " | Name: " + p.getUsername() + " | Date:" + p.getDate() + " | Current Goal: " + p.getCurrentgoal() + " | Current Calories: " + p.getCurrentcalories());
        }
        
        return history;
    }
    
    public List<Person> readAllPerson(){
        Query query = manager.createNamedQuery("Person.findAll");
        List<Person> people = query.getResultList();

        for (Person p : people) {
            System.out.println("ID: " + p.getId() + " | Name: " + p.getUsername() + " | Password:" + p.getPassword() + " | Credentials: " + p.getCredentials() + " | Current Calories: " + p.getCurrentcalories());
        }
        
        return people;
    }
}
