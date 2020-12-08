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
import javafx.scene.control.TextField;
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
public class LoginPageController implements Initializable {    
    //login
    @FXML 
    private TextField usernameText; 
    
    @FXML
    private TextField passwordText; 
    
    @FXML 
    public ComboBox credentialsDropDown;
   
    @FXML
    private Button loginButton; 
    
    private ArrayList<String> dropItems = new ArrayList();
    
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
    
    SearchController cont = new SearchController();
    
    
    
    EntityManager manager;
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
        
        addToDropDown(); 
    }
    

    @FXML
    private void populateDropDown(ActionEvent event){
        credentialsDropDown.getItems().add("Active Cruncher");
        credentialsDropDown.getItems().add("Personal Trainer");
        credentialsDropDown.getItems().add("Medical Professional");
    }
    
    private ComboBox addToDropDown(){
        dropItems.clear();
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
        if(credentialsDropDown.getValue().equals("Active Cruncher")){
            cont.dropDownValue = credentialsDropDown.getValue().toString();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InfoInputScreen.fxml")); 
            Parent InfoInputScreen = loader.load(); 
            Scene tableViewScene = new Scene(InfoInputScreen);

            Stage stage = new Stage();
            stage.setScene(tableViewScene);
            stage.show();
            
        } else if (credentialsDropDown.getValue().equals("Personal Trainer") || credentialsDropDown.getValue().equals("Medical Professional")) {
            cont.dropDownValue = credentialsDropDown.getValue().toString();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Search.fxml")); 
            Parent searchScreen = loader.load(); 
            Scene tableViewScene = new Scene(searchScreen);

            Stage stage = new Stage();
            stage.setScene(tableViewScene);
            stage.show();
        }
       
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
  
    
   
  
    
}
