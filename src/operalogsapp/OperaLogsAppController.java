/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operalogsapp;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author absasahu
 */
public class OperaLogsAppController implements Initializable {
    
   
    @FXML
    private TableView<modal> table;
    @FXML
    private TableColumn<modal, Integer> seq_noCol;
    @FXML
    private TableColumn<modal, String> plsql_unitCol;
    @FXML
    private TextField keywordTextField;
    @FXML
    private TableColumn<modal, String> chainCodeCol;
    @FXML
    private TableColumn<modal, Integer> instanceNumCol;
    @FXML
    private TableColumn<modal, String> logtextCol;
    @FXML
    private TableColumn<modal, String> resortCol;
    ObservableList<modal> modalObservableList=FXCollections.observableArrayList();
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        String query="select * from FinalProjectDemo";
        try {
            Connection connectDB;
            connectDB=databaseConnection.con;
            Statement statement=connectDB.createStatement();
            System.out.println("statement created");
            ResultSet rs=statement.executeQuery(query);
            System.out.println("resultset created");
            
            
            while(rs.next()){
                ///string --
                String r1=rs.getString("CHAIN_CODE");
                String r2=rs.getString("PLSQL_UNIT");
                String r3=rs.getString("LOG_TEXT");
                String r4=rs.getString("RESORT");
                Integer r5= rs.getInt("SEQ_NO");
                Integer r6= rs.getInt("INSTANCE_NO");
                
                //// POPULATING THE OBSERBABLE LIST
                modalObservableList.add(new modal(r1,r2,r3,r4,r5,r6));
                seq_noCol.setCellValueFactory(new PropertyValueFactory<>("seqnum"));
                plsql_unitCol.setCellValueFactory(new PropertyValueFactory<>("plsqlunit"));
                chainCodeCol.setCellValueFactory(new PropertyValueFactory<>("chainCode"));
                instanceNumCol.setCellValueFactory(new PropertyValueFactory<>("instNum"));
                logtextCol.setCellValueFactory(new PropertyValueFactory<>("logText"));
                resortCol.setCellValueFactory(new PropertyValueFactory<>("resort"));
                table.setItems(modalObservableList);
                
                // initialised text field
                FilteredList<modal> filteredData= new FilteredList<>(modalObservableList, b->true);
                
                //
                keywordTextField.textProperty().addListener((observable, oldValue, newValue)->{
                    filteredData.setPredicate(modal->{
                        if(newValue.isEmpty()|| newValue==null){
                            return  true;
                        }
                        String searchKeyword=newValue.toLowerCase();
                        if(modal.getResort().toLowerCase().indexOf(searchKeyword)>-1){
                            return  true;
                        }else if(modal.getChainCode().toLowerCase().indexOf(searchKeyword)>-1){
                            return  true;
                        }else if(modal.getPlsqlunit().toLowerCase().indexOf(searchKeyword)>-1){
                            return  true;
                        }else if(modal.getLogText().toLowerCase().indexOf(searchKeyword)>-1){
                            return  true;
                        }else if(modal.getSeqnum().toString().indexOf(searchKeyword)>-1){
                            return  true;
                        }else if(modal.getInstNum().toString().indexOf(searchKeyword)>-1){
                            return  true;
                        }
                        return false;
                    });
                
                });
                SortedList<modal> sortedData=new SortedList<>(filteredData);
                sortedData.comparatorProperty().bind(table.comparatorProperty());
                table.setItems(sortedData);
                
            }
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(OperaLogsAppController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
