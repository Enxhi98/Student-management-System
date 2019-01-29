/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author enxhikaziu
 */
public class LoginController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Text wrongText;

    /*static ObjectInputStream inputFromServer;
    private DataInputStream dataFromServer;
    private static final long serialVersionUID = 01L;
    private static final int PORT = 8080;
    private final String host = "localhost";*/
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        wrongText.setVisible(false); //Error message primarily set as not visible
    }

    //Validation method for login information
    @FXML
    private void validate(ActionEvent event) throws IOException {

        //If login credentials belong to "student", student homepage will open up
        if (username.getText().equals("Student") && password.getText().equals("student18")) {
            Parent root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }
        //If login credentials belong to "admin", admin homepage will open up
        if (username.getText().equals("Admin") && password.getText().equals("admin18")) {
            Parent root = FXMLLoader.load(getClass().getResource("adminHomepage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } 
        //If none of the above, display error message
        else {
            wrongText.setVisible(true);
        }
    }

    //Registration page when button clickes
    @FXML
    private void register(ActionEvent event) throws IOException {
        

            Parent root = FXMLLoader.load(getClass().getResource("CreateStudent.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setResizable(
                    false);
            stage.setScene(scene);

            stage.show();
        }

    }
