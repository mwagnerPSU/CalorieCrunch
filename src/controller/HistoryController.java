/*
 * Filename: HistoryController.java
 * Short description: 
 * @author Mike Wagner
 * @version Dec 14, 2020
 */

package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


/**
 *
 * @author Owner
 */
public class HistoryController implements Initializable{

    private Text usernameText;
    
    private TableView tableView;
    
    private TableColumn dateColumn;
    
    private TableColumn goalColumn;
    
    private TableColumn totalCalColumn;
    
    private TableColumn usernameColumn;
    
    private Button displayDataButton;
    
    private Button signOutButton;
    
    EntityManager manager;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        manager = (EntityManager) Persistence.createEntityManagerFactory("CalorieCrunchFXMLPU").createEntityManager();
        
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("Username"));
        goalColumn.setCellValueFactory(new PropertyValueFactory<>("Currentgoal"));
        totalCalColumn.setCellValueFactory(new PropertyValueFactory<>("Currentcalories"));

        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
    }
    
    
    @FXML
    private void displayData(ActionEvent event){
        
    }
    
    @FXML
    private void signOut(ActionEvent event){
        
    }
}
