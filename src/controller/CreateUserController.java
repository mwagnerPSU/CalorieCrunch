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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
public class CreateUserController implements Initializable{
    
   @FXML
   private Button saveUserButton; 
   
   @FXML
   private TextField usernameText; 
   
   @FXML
   private TextField passwordText; 
    
   @FXML
   private TextField credentialsText; 
   
    EntityManager manager;
    public void initialize(URL url, ResourceBundle rb) {
        
        manager = (EntityManager) Persistence.createEntityManagerFactory("CalorieCrunchFXMLPU").createEntityManager();
        
    }    
       
    public void saveUserMethod(Person person){
          try {
              System.out.println("got here 0");
            // begin transaction
            manager.getTransaction().begin();
              System.out.println("got here 1");
            
            // sanity check
            if (person.getUsername() != null) {
                
                System.out.println("got here 2");
        
                manager.persist(person);
                
                System.out.println("got here 3");
            
                manager.getTransaction().commit();
                
                System.out.println(person.toString() + " is created");
                
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + " error");
        }  
    }
    
    public void saveUserMethodHistory(History history){
          try {
              System.out.println("got here 0");
            // begin transaction
            manager.getTransaction().begin();
              System.out.println("got here 1");
            
            // sanity check
            if (history.getUsername() != null) {
                
                System.out.println("got here 2");
        
                manager.persist(history);
                
                System.out.println("got here 3");
            
                manager.getTransaction().commit();
                
                System.out.println(history.toString() + " is created");
                
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + " error");
        }  
    }
   
    
    @FXML
    public void saveUser(ActionEvent event) throws IOException{
        String username = usernameText.getText();
        String password = passwordText.getText();
        String credentials = credentialsText.getText();
        int currentCalories = 0;
        int currentGoal = 0;


        Person person = new Person(); 

        person.setCredentials(credentials);
        person.setUsername(username);
        person.setPassword(password);
        person.setId(readAll().size() + 1);
        person.setCurrentcalories(currentCalories);
        person.setCurrentgoal(currentGoal);

        saveUserMethod(person);
        
        History history = new History();
        
        history.setId(readAllHistory().size() + 1);
        history.setUsername(username);
        history.setDate(new Date());
        history.setCurrentgoal(currentGoal);
        history.setCurrentcalories(currentCalories);
        
        saveUserMethodHistory(history);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LoginPage.fxml")); 
        Parent searchScreen = loader.load(); 
        Scene tableViewScene = new Scene(searchScreen);
        LoginPageController loginCont = loader.getController();

        Stage stage = new Stage();
        stage.setScene(tableViewScene);
        stage.show();
    } 
    
    public List<Person> readAll(){
        Query query = manager.createNamedQuery("Person.findAll");
        List<Person> persons = query.getResultList();
        
        return persons;
    }
    
    public List<History> readAllHistory(){
        Query query = manager.createNamedQuery("History.findAll");
        List<History> historys = query.getResultList();
        
        return historys;
    }
}
