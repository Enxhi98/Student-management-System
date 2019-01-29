/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import javafx.collections.ObservableList;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author enxhikaziu
 */

//Student class and its variables
class Student implements Serializable {
    private String name;
    private String id;
    private String lastName;
    private String city;
    private String country;
    private String password;
    
    
    
    public Student(String id, String name, String lastName, String city, String country, String password){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.city = city;
        this.country = country;
        this.password = password;
        

       
    }
    
    //Get student details methods
    
    public String getID(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getCity(){
        return city;
    }
    
    public String getCountry(){
        return country;
    }
    
    public String getPassword(){
        return password;
    }
    
    
    
   
}
