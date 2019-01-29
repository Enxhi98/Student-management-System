/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author enxhikaziu
 */
public class AdminHomepageController implements Initializable {
    
    /*Declaring variables*/
    @FXML
    private Button studentRecords;
    @FXML
    private Button logOut;
    private ListView<?> stList;
    private ObservableList items;
    private StudentsDirectory sd;
    private ArrayList<Student> studentList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    /*Method that takes the user to login page*/
    @FXML
    private void logOut1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    
    /*Method that takes the user to studentRecords page*/
    @FXML
    private void studentRecords(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("studentRecords.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    
}
    


