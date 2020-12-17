/*
 * Filename: HistoryController.java
 * Short description: 
 * @author Mike Wagner
 * @version Dec 14, 2020
 */

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.History;
import model.Person;


/**
 *
 * @author Owner
 */
public class HistoryController implements Initializable{

    private Text usernameText;
    
    private TableView <History> tableView;
    
    private TableColumn <History, Date> dateColumn;
    
    private TableColumn <History, Integer> goalColumn;
    
    private TableColumn <History, Integer> totalCalColumn;
    
    private TableColumn <History, String> usernameColumn;
    
    private ObservableList<History> historyData;
    
    public void setTableData(List<History> historyList){
        historyData = FXCollections.observableArrayList();
        
        historyList.forEach(mP -> {
            historyData.add(mP);
        });
        
        tableView.setItems(historyData);
        tableView.refresh();
    }
    
    private Button displayDataButton;
    
    private Button signOutButton;
    
    
    String searchedUsername;
    
    public void initData(String searchedUser){
        searchedUsername = searchedUser;
    }
    
    EntityManager manager;

    public void initialize(URL url, ResourceBundle rb) {
        
        manager = (EntityManager) Persistence.createEntityManagerFactory("CalorieCrunchFXMLPU").createEntityManager();
        
//        dateColumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
//        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("Username"));
//        goalColumn.setCellValueFactory(new PropertyValueFactory<>("Currentgoal"));
//        totalCalColumn.setCellValueFactory(new PropertyValueFactory<>("Currentcalories"));

        //tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
    }
    
    
    @FXML
    private void displayData(ActionEvent event){
        setTableData(readByUsername(searchedUsername));
    }
    
    @FXML
    private void signOut(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LoginPage.fxml"));
        Parent LoginScreen = loader.load();
        Scene tableViewScene = new Scene(LoginScreen);
        
        Stage stage = new Stage();
        stage.setScene(tableViewScene);
        stage.show();
    }
    
    public List<History> readByUsername(String username){
        Query query = manager.createNamedQuery("History.findByUsername");
        query.setParameter("username", username);
        List<History> history = query.getResultList();

        for (History p : history) {
            System.out.println("ID: " + p.getId() + " | Name: " + p.getUsername() + " | Date:" + p.getDate() + " | Current Goal: " + p.getCurrentgoal() + " | Current Calories: " + p.getCurrentcalories());
        }
        
        return history;
    }
}

