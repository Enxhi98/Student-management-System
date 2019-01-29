package project;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author enxhikaziu
 */
public class CreateStudentController implements Initializable {
    
    //Declaring variables
    @FXML
    private TextField name;
    private StudentsDirectory directory;
    @FXML
    private TextField lastName;
    @FXML
    private TextField city;
    @FXML
    private TextField country;
    @FXML
    private Button goBack1;
    String host = "localhost";
    @FXML
    private PasswordField password;
    int number = ThreadLocalRandom.current().nextInt(100000, 999999 + 1);
    String id = Integer.toString(number);
    @FXML
    private Text fillOut;

    /**
     * Initializes the controller class.
     */
    @Override

    public void initialize(URL url, ResourceBundle rb) {
        fillOut.setVisible(false);
        directory = StudentsDirectory.getDirectory();
    }
    
    //Method that generates unique ID for each student
    @FXML
    private void createStudent(ActionEvent event) throws IOException {

        for (int i = 0; i < directory.getList().size(); i++) {
            if (id.equals(directory.getList().get(i).getID())) {
                i = 0;
                id = Integer.toString(ThreadLocalRandom.current().nextInt(100000, 999999 + 1));
            }
        }
        //If statement which authenticantes the completion of all registration fields
        if (name.getText().isEmpty() || lastName.getText().isEmpty() || city.getText().isEmpty() || country.getText().isEmpty() || password.getText().isEmpty()) {
            fillOut.setVisible(true);
        } else {
            directory.addStudent(new Student(id, name.getText(), lastName.getText(), city.getText(), country.getText(), password.getText()));
            Parent root = FXMLLoader.load(getClass().getResource("Congrats.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }

    }

   

    
    //Back to login page
    @FXML
    private void backToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
