/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author enxhikaziu
 */

//Students list
public class StudentsDirectory {

    private static StudentsDirectory sd = null;
    private ArrayList<Student> StudentList = new ArrayList<>();

    private StudentsDirectory() {
    }

    //If students directory is empty create a new one, if not return the one that already exists
    public static StudentsDirectory getDirectory() {

        if (sd == null) {
            sd = new StudentsDirectory();
            return sd;
        } else {
            return sd;
        }
    }
    
    public ArrayList<Student> getList(){
    
    return StudentList;
    }
    
    //Add new student method
    public void addStudent(Student student){
        StudentList.add(student);
    }
}
