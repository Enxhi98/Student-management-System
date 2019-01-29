/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author enxhikaziu
 */
public class CongratsController implements Initializable {

    @FXML
    private Button goBack;
    @FXML
    private Button registerToServer;
    private String name;
    private String id;
    private String lastName;
    private String city;
    private String country;
    private String password;
    String host = "localhost";
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    //Method that takes the user to CreateStudent page
    @FXML
    private void backToRegistration(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreateStudent.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    
    //Client side method of the program
    @FXML
    private void registerToServer(ActionEvent event) throws IOException {
        try {
            Socket socket = new Socket(host, 8080);
            ObjectOutputStream toServer
                    = new ObjectOutputStream(socket.getOutputStream());

            Student s = new Student(id, name, lastName, city, country, password);
            toServer.writeObject(s);

        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
