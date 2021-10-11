/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garments.management.system;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mohammad Rasel
 */
public class HomepageController implements Initializable {

    @FXML
    private Button employee_table;
    @FXML
    private Button buyer_table;
    @FXML
    private Button order_table;
    @FXML
    private Button productlist_table;
    @FXML
    private Button production_table;
    @FXML
    private Button productStatus_table;
    @FXML
    private Button transaction_table;
    @FXML
    private Button shipment_table;
    private TextField torder;

    /**
     * Initializes the controller class.
     */
    
    //private Button employee_table;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=Garment_Production_Management;selectMethod=cursor", "sa", "123456");
           
             String q="select OrderId from Ordered";
            
           ResultSet rs= con.createStatement().executeQuery(q);
           while(rs.next()){   
               //String a= Integer.toString(rs.getInt("OrderId"));
                torder.setText(rs.getString("OrderId"));
                
               
               
                
                      
             }            
            
             
                                                                                   
      } catch (Exception e) {
            e.printStackTrace();
       }
       
    }    

    @FXML
   private void gotoemployeepageOnAction(ActionEvent event) throws IOException{
        
        Parent employee_page_parent = FXMLLoader.load(getClass().getResource("employeepage.fxml"));
        Scene  employee_page_scene = new Scene(employee_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(employee_page_scene);
        app_stage.show();
        
    } 

    @FXML
    private void gotobuyerpageOnAction(ActionEvent event) throws IOException {
        Parent employee_page_parent = FXMLLoader.load(getClass().getResource("Buyer.fxml"));
        Scene  employee_page_scene = new Scene(employee_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(employee_page_scene);
        app_stage.show();
        
    }

    @FXML
    private void gotoorderpageOnActionpage(ActionEvent event) throws IOException {
        
          Parent employee_page_parent = FXMLLoader.load(getClass().getResource("orderpage.fxml"));
        Scene  employee_page_scene = new Scene(employee_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(employee_page_scene);
        app_stage.show();
        
        
        
    }

    @FXML
    private void gotoproductlistpageOnAction(ActionEvent event) throws IOException {
          Parent employee_page_parent = FXMLLoader.load(getClass().getResource("productlistpage.fxml"));
        Scene  employee_page_scene = new Scene(employee_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(employee_page_scene);
        app_stage.show();
        
        
        
        
}

    @FXML
    private void gotoproductionpageOnAction(ActionEvent event) throws IOException {
        
          Parent employee_page_parent = FXMLLoader.load(getClass().getResource("productionpage.fxml"));
        Scene  employee_page_scene = new Scene(employee_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(employee_page_scene);
        app_stage.show();
        
        
    }

    @FXML
    private void gotoproductStatusOnAction(ActionEvent event) throws IOException {
        
             Parent employee_page_parent = FXMLLoader.load(getClass().getResource("productionstatuspage.fxml"));
        Scene  employee_page_scene = new Scene(employee_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(employee_page_scene);
        app_stage.show();
        
        
    }

    @FXML
    private void gotoTransactionpageOnAction(ActionEvent event) throws IOException {
        
             Parent employee_page_parent = FXMLLoader.load(getClass().getResource("transactionpage.fxml"));
        Scene  employee_page_scene = new Scene(employee_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(employee_page_scene);
        app_stage.show();
        
        
    }

    @FXML
    private void gotoshipmentpageaOnAction(ActionEvent event) throws IOException {
        
            Parent employee_page_parent = FXMLLoader.load(getClass().getResource("shipmentinfopage.fxml"));
        Scene  employee_page_scene = new Scene(employee_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(employee_page_scene);
        app_stage.show();
        
        
    }

    @FXML
    private void backtoadsignin(ActionEvent event) throws IOException {
        
          Parent employee_page_parent = FXMLLoader.load(getClass().getResource("E:\\ckeakpoint2\\Garments Management System\\src\\login\\adsigninad.fxml"));
        Scene  employee_page_scene = new Scene(employee_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(employee_page_scene);
        app_stage.show();
        
        
    }

    @FXML
    private void gotostatreport(ActionEvent event) throws IOException {
        
          Parent employee_page_parent = FXMLLoader.load(getClass().getResource("statreport.fxml"));
        Scene  employee_page_scene = new Scene(employee_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(employee_page_scene);
        app_stage.show();
        
        
        
        
    }
    
    
    

    

   
    
}
