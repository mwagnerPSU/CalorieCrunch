/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Karina
 */
public class SearchController {

    @FXML
    private Button searchButton;

    @FXML
    private Button signOutButton;

    @FXML
    private TextField searchField;
    
    public String dropDownValue = "Personal Trainer";

    @FXML
    private void search(ActionEvent event) throws IOException {
        //search by username 
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/clientDataView.fxml"));
            Parent SearchScreen = loader.load();
            Scene tableViewScene = new Scene(SearchScreen);

            Stage stage = new Stage();
            stage.setScene(tableViewScene);
            stage.show();
        
        /*
        if (dropDownValue.equals("Personal Trainer")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/clientDataView.fxml"));
            Parent SearchScreen = loader.load();
            Scene tableViewScene = new Scene(SearchScreen);

            Stage stage = new Stage();
            stage.setScene(tableViewScene);
            stage.show();
        } else if (dropDownValue.equals("Medical Professional")) {
            //put screen to go to
        }
        */
    }

    @FXML
    private void signOut(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LoginPage.fxml"));
        Parent SearchScreen = loader.load();
        Scene tableViewScene = new Scene(SearchScreen);

        Stage stage = new Stage();
        stage.setScene(tableViewScene);
        stage.show();
    }
}
