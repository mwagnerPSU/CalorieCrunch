/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import model.Person;

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
    public ComboBox credentialsDropDown;
   
    @FXML
    private Button loginButton; 
    
    private ArrayList<String> dropItems = new ArrayList();
    
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
    private TextField intakeGoalField = new TextField();
    @FXML
    private TextField recentIntakeField;
    @FXML
    private Text totalCaloriesText;
    
    @FXML
    private Button totalCals;
    
    public String calorieHolder = "Hello";
    
    //third view
    @FXML
    private Text goalText = new Text();
    
    @FXML
    private Text caloriesRemainingText = new Text();
    
    @FXML
    private TextField motivationalMessageField = new TextField();;
    
    @FXML
    private Button caloriesRemainingButton;
    
    @FXML
    private Button previousButton;
    
    @FXML private Button showGoal;
    
    
    
    //end third view
    
    
    //for database
    @FXML
    private TableView <Person> tableView;
    @FXML
    private TableColumn <Person, Integer> id;
    @FXML
    private TableColumn <Person, String> username;
    @FXML
    private TableColumn <Person, String> password;
    @FXML
    private TableColumn <Person, String> credentials;
    @FXML
    private TableColumn <Person, String> currentCalories;
  
    
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {

    }
    
    //first UI
    @FXML
    private void populateDropDown(ActionEvent event){
        credentialsDropDown.getItems().add("Active Cruncher");
        credentialsDropDown.getItems().add("Personal Trainer");
        credentialsDropDown.getItems().add("Medical Professional");
    }
    
    private ComboBox addToDropDown(){
        dropItems.add("Active Cruncher");
        dropItems.add("Personal Trainer");
        dropItems.add("Medical Professional");
        
        for (Object item : dropItems) {
            credentialsDropDown.getItems().add(item);
        }
        
        
        
        return credentialsDropDown;
    }
    
    @FXML
    private void loginUser(ActionEvent event) throws IOException {
        /*
        if(usernameText.getText().equals("") || passwordText.getText().equals("")){
            System.out.println("error message");
            //add error message
        }
        else{
            //Person newPerson = new Person();
            
            newPerson.setId();
            newPerson.setCredentials();
            newPerson.setUsername();
            newPerson.setPassword();
            newPerson.setCurrentcalories();
            
            //create(newPerson);
            
            
        }
        */
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InfoInputScreen.fxml")); 
            Parent InfoInputScreen = loader.load(); 
            Scene tableViewScene = new Scene(InfoInputScreen);

            Stage stage = new Stage();
            stage.setScene(tableViewScene);
            stage.show();
    }
    /*
    //makes new person with username and password fields
    public void create(Person newPerson) {
        try {
            // begin transaction
            manager.getTransaction().begin();
            
            // sanity check
            if (newPerson.getId() != null) {
                
                // create student
                manager.persist(newPerson);
                
                // end transaction
                manager.getTransaction().commit();
                
                System.out.println("Added: ID: " + newPerson.getId() + " | Username: " + newPerson.getUsername() + " | Password: " + newPerson.getPassword() + " | Credentials: " + newPerson.getCredentials() + " | Current Calories: " + newPerson.getCurrentcalories());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
*/
    
    //Second UI
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
    private void showCaloriesRemaining(ActionEvent event){
        caloriesRemainingText.setText("1500");
    }
    
    @FXML 
    private TextField motivationalMessage(String message){
        // sets a motivational message 
        motivationalMessageField.setText(message);
        
        return motivationalMessageField;
    }
    
    //EntityManager manager;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*
        manager = (EntityManager) Persistence.createEntityManagerFactory("CalorieCrunchFXMLPU").createEntityManager();
        
        id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        username.setCellValueFactory(new PropertyValueFactory<>("Username"));
        password.setCellValueFactory(new PropertyValueFactory<>("Password"));
        credentials.setCellValueFactory(new PropertyValueFactory<>("Credentials"));
        currentCalories.setCellValueFactory(new PropertyValueFactory<>("Currentcalories"));

        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        */
        
        motivationalMessage("Keep going! You still have time!");
    }    
    //ebh
}
