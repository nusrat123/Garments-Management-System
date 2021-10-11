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
import java.sql.SQLException;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Mohammad Rasel
 */
public class BuyerController implements Initializable {

    @FXML
    private Button home;
    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField address;
    @FXML
    private TextField country;
    @FXML
    private TextField email;
    @FXML
    private Button updatebutton;
    @FXML
    private Button insertButton;
    @FXML
    private TextField phone;
    @FXML
    private Button deleteButton;
    @FXML
    private TableColumn<Buyer, Integer> col_id;
    @FXML
    private TableColumn<Buyer, String> col_name;
    @FXML
    private TableColumn<Buyer, String> col_address;
    @FXML
    private TableColumn<Buyer, String> col_country;
    @FXML
    private TableColumn<Buyer, String> col_email;
    @FXML
    private TableColumn<Buyer, String> col_phone;
    @FXML
    private TableView<Buyer> Buyer;
     ObservableList<Buyer>list=FXCollections.observableArrayList();
      int index=-1;
    @FXML
    private TextField phone2;
    @FXML
    private TextField phone1;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       fetch();
    }    

    
    
    @FXML
    private void gotohomepageOnaction(ActionEvent event) throws IOException {
        
            Parent employee_page_parent = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        Scene  employee_page_scene = new Scene(employee_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(employee_page_scene);
        app_stage.show();
    }

    @FXML
    private void updateAction(ActionEvent event) {
        
        try{
           Connection con = DriverManager.getConnection(
                     "jdbc:sqlserver://localhost:1433;databaseName=checkpoint2;selectMethod=cursor", "sa", "123456");                       
           String v1=id.getText();
            String v2=name.getText();
             String v3=address.getText();
              String v4=country.getText();
               String v5=email.getText();
               String v6=phone.getText();
               String sql="update Buyer set BuyerId='"+v1+"', Name='"+v2+"',Address='"+v3+"',"
                       + "Country='"+v4+"',EmailId='"+v5+"',PhoneNumber='"+v6+"' where BuyerId='"+v1+"' ";
               PreparedStatement pst=con.prepareStatement(sql);
               pst.execute();
               JOptionPane.showMessageDialog(null,"Updated");
             fetch();  
              
               
               
             
      }
           catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void InsertAction(ActionEvent event) {
         if(name.getText().equals(""))
    {
      JOptionPane.showMessageDialog(null,"name is empty");
      
     }
         else
         {
        
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=Garment_Production_Management;selectMethod=cursor", "sa", "123456");
           
             String q="insert into Buyer (BuyerId,Name,Address,Country,EmailId,PhoneNumber) values(?,?,?,?,?,?)";
            
            PreparedStatement pst=con.prepareStatement(q);
            pst.setString(1,id.getText());
            pst.setString(2,name.getText());
              pst.setString(3,address.getText());
              pst.setString(4,country.getText());
              pst.setString(5,email.getText());
              pst.setString(5,email.getText());
                  pst.setString(6,phone.getText());
              pst.executeUpdate();
             JOptionPane.showMessageDialog(null,"inserted");
             fetch();                                      
            
           
           
    
      } catch (Exception e) {
            e.printStackTrace();
       }
         }
         
         
   
        
    }

    
    
    @FXML
    private void deleteAction(ActionEvent event) {
        
         
        try{
           Connection con = DriverManager.getConnection(
                     "jdbc:sqlserver://localhost:1433;databaseName=checkpoint2;selectMethod=cursor", "sa", "123456");                       
           String v1=id.getText();
           
               String sql="delete from Buyer where BuyerId=? ";
                       
               PreparedStatement pst=con.prepareStatement(sql);
               pst.setString(1, v1);
          
               pst.execute();
               JOptionPane.showMessageDialog(null,"Deleted");
             fetch();  
             
               
               
             
      }
           catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
      public void fetch()
    {
     list.clear();
         try{
           Connection con = DriverManager.getConnection(
                     "jdbc:sqlserver://localhost:1433;databaseName=checkpoint2;selectMethod=cursor", "sa", "123456");                       
           
             ResultSet rs= con.createStatement().executeQuery("select *from Buyer");
             while(rs.next()){
                 
                     
                list.add(new Buyer(rs.getInt("BuyerId"),rs.getString("Name"),rs.getString("Address"),
                        rs.getString("Country"),rs.getString("EmailId"),rs.getString("PhoneNumber")));
                
             }
            
            
      }
           catch (SQLException e) {
            e.printStackTrace();
        }
      col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
    col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
     col_country.setCellValueFactory(new PropertyValueFactory<>("country"));
      col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
      col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
      Buyer.setItems(list);
      
      name.clear();
             id.clear();
             country.clear();
             address.clear();
             email.clear(); 
             phone.clear();
             
    }

    @FXML
    private void MouseClick(MouseEvent event) {
         index=Buyer.getSelectionModel().getSelectedIndex();
        if(index<=-1)
        {
            return;
        }
        id.setText(col_id.getCellData(index).toString());
         name.setText(col_name.getCellData(index));
          address.setText(col_address.getCellData(index));
           country.setText(col_country.getCellData(index));
            email.setText(col_email.getCellData(index));
            phone.setText(col_phone.getCellData(index));
    }

    
}


