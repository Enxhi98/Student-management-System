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
public class StudentRecordsController implements Initializable {

    //Declaration of variables
    @FXML
    private ListView<?> stList;
    private ObservableList items;
    private StudentsDirectory sd;
    private ArrayList<Student> studentList;
    @FXML
    private Button bToHomepage;

    /**
     * Initializes the controller class.
     */
    
    //Add new student to students list
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sd = StudentsDirectory.getDirectory();
        items = FXCollections.observableArrayList();
        studentList = sd.getList();
        for (int i = 0; i < studentList.size(); i++) {
            items.add(studentList.get(i).getID() + " " + studentList.get(i).getName() + " " + studentList.get(i).getLastName() + " " + studentList.get(i).getCity()
                    + " " + studentList.get(i).getCountry() + " " + studentList.get(i).getPassword());
        }
        stList.setItems(items);

    }

    //Admin homepage when "Go back" button pressed
    @FXML
    private void adminHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("adminHomepage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
