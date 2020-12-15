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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import model.Person;

/**
 *
 * @author Karina
 */
public class CreateUserController implements Initializable  {
    
   @FXML
   private Button saveUserButton; 
   
   @FXML
   private TextField usernameText; 
   
   @FXML
   private TextField passwordText; 
    
   @FXML
   private TextField credentialsText; 
   

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
    
     
    private ObservableList<Person> personData;
    
    EntityManager manager;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        manager = (EntityManager) Persistence.createEntityManagerFactory("CalorieCrunchFXMLPU").createEntityManager();
        
        id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        username.setCellValueFactory(new PropertyValueFactory<>("Username"));
        password.setCellValueFactory(new PropertyValueFactory<>("Password"));
        credentials.setCellValueFactory(new PropertyValueFactory<>("Credentials"));
        currentCalories.setCellValueFactory(new PropertyValueFactory<>("Currentcalories"));

        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
    }
 
       
   @FXML
     private void saveUser(Person Person){
          try {
            // begin transaction
            manager.getTransaction().begin();
            
            // sanity check
            if (Person.getId() != null) {
                
        
                manager.persist(Person);
                
            
                manager.getTransaction().commit();
                
                System.out.println(Person.toString() + " is created");
                
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }  
     }
   
    

public void saveUser(ActionEvent event){
    String username = usernameText.getText();
    String password = passwordText.getText();
    String credentials = credentialsText.getText();
    
    
    Person person = new Person(); 
    
    person.setCredentials(credentials);
    person.setUsername(username);
    person.setUsername(password);
    
   
    
    saveUser(Person);
} 
     
     
     
     
     
     
     
     
}
