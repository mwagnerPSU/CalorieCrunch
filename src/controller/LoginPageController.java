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
import javafx.collections.ObservableList;
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
public class LoginPageController implements Initializable{    
    //login
    @FXML 
    private TextField usernameText; 
    
    @FXML
    private TextField passwordText; 
    
    @FXML 
    public ComboBox credentialsDropDown;
   
    @FXML
    private Button loginButton; 
    
    @FXML
    private Button signUpButton;    
    
    private ArrayList<String> dropItems = new ArrayList();
    
    String currentUsername;
    
    //public InfoInputController infoCont = new InfoInputController();

    public String getCurrentUsername() {
        return currentUsername;
    }

    public void setCurrentUsername(String currentUsername) {
        this.currentUsername = currentUsername;
    }
    

    
    
    @FXML
    private void loginUser(ActionEvent event) throws IOException {

        if(credentialsDropDown.getValue().equals("Active Cruncher")){
            
            setCurrentUsername(usernameText.getText());
            //infoCont.setCurrentUsername(currentUsername);
            System.out.println(currentUsername);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InfoInputScreen.fxml")); 
            Parent InfoInputScreen = loader.load(); 
            Scene tableViewScene = new Scene(InfoInputScreen);

            Stage stage = new Stage();
            stage.setScene(tableViewScene);
            stage.show();
            
            
        } else if (credentialsDropDown.getValue().equals("Personal Trainer") || credentialsDropDown.getValue().equals("Medical Professional")) {
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Search.fxml")); 
            Parent searchScreen = loader.load(); 
            Scene tableViewScene = new Scene(searchScreen);

            Stage stage = new Stage();
            stage.setScene(tableViewScene);
            stage.show();
        }
       
    }
    
    @FXML
    private void createUser(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/createUser.fxml")); 
            Parent searchScreen = loader.load(); 
            Scene tableViewScene = new Scene(searchScreen);

            Stage stage = new Stage();
            stage.setScene(tableViewScene);
            stage.show();
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
   
   public void initialize(URL url, ResourceBundle rb) {
       addToDropDown();
   }

    
}
