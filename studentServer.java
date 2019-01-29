package project;

import java.io.*;
import java.net.*;


public class studentServer {
    
    //Declaration of variables
    private ObjectOutputStream outputToFile;
    private ObjectInputStream inputFromClient;
    
    public static void main(String[]args){
        new studentServer();
       
    }
    
    /*Server side method which reads the client requests(student details) and stores all the details in a file 
    whilst printing out a statement
    */
   
    public studentServer(){
        try{
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started");
            
            outputToFile = new ObjectOutputStream(
            new FileOutputStream("student.sql", true));
            
            while(true){
                Socket socket = serverSocket.accept();
                
                inputFromClient = new ObjectInputStream(socket.getInputStream());
                
                Object object = inputFromClient.readObject();
                
                outputToFile.writeObject(object);
                System.out.println("A new student is stored in the system");
            }
        }
        
        catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        
        catch(IOException ex){
            ex.printStackTrace();
        }
        
        finally{
            try{
                inputFromClient.close();
                outputToFile.close();
            }
            
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
    
}