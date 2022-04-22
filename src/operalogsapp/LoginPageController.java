/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operalogsapp;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author absasahu
 */
public class LoginPageController implements Initializable {
    

    @FXML
    private TextField username;
    @FXML
    private TextField port_number;
    
    @FXML
    private TextField password;
    @FXML
    private TextField service_name;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        
    }    

    @FXML
    private void OnSubmit(ActionEvent event) {
        String databaseuser=username.getText();
        
        String databasepassword=password.getText();
         Integer portNumber= Integer.parseInt(port_number.getText());
        String serviceName=service_name.getText();
//    
        
      
            System.out.println("NoNoNo");
            
            Connection con=databaseConnection.getDBConnection(databaseuser,databasepassword,portNumber,serviceName);
            
            System.out.println(con==null);
            System.out.println("yes");
            if(con!= null){
                Parent root1;
                try {
                    root1 = FXMLLoader.load(getClass().getResource("tableLoader.fxml"));
                    System.out.println("fxml loaded");
                    Stage stage=(Stage)password.getScene().getWindow();
                    System.out.println("Stage created");
                    Scene scene= new Scene(root1);
                    System.out.println("Scene Created");
                    stage.setScene(scene);
                } catch (IOException ex) {
                    System.out.println("tableLoader cant open due to some reasonms");
                }
                
            }
        } 
    }
    

