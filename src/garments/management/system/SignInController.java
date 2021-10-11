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
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SignInController implements Initializable {

    private TextField name;
    private TextField address;
    private TextField country;
    private TextField email;
    private TextField phone;
    private PasswordField password;
    private TextField age;

     public Connection connection;
    @FXML
    private TextField user_email;
    @FXML
    private TextField user_password;
    @FXML
    private Button user_signin;
    String e,p;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void register(ActionEvent event) {
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=demo ;selectMethod=cursor", "sa", "123456");
           
             String q="insert into Buyer (Name,Address,Country,EmailId,PhoneNumber,Pass,Age,Gender) values(?,?,?,?,?,?,?,?)";
            
            PreparedStatement pst=con.prepareStatement(q);
              pst.setString(1,name.getText());
              pst.setString(2,address.getText());
              pst.setString(3,country.getText());
              pst.setString(4,email.getText());
              pst.setString(5,phone.getText());
              pst.setString(6,password.getText());
              pst.setString(7,age.getText());
              pst.setString(8,null);
              pst.executeUpdate();
             JOptionPane.showMessageDialog(null,"inserted");
            //fetch();                                      
            System.out.println(name.getText());
           
           
    
            } catch (Exception e) {
                e.printStackTrace();
        }
        
    }
    PreparedStatement pst = null;
    ResultSet rs = null;
    @FXML
    private void check_signin(ActionEvent event) {
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=demo ;selectMethod=cursor", "sa", "123456");
             String email=user_email.getText();
             String password=user_password.getText();
             
             String q="SELECT EmailId,Pass FROM Buyer Where EmailId = '"+email+"' AND Pass = '"+password+"' ";
              System.out.println(q);
             
               //PreparedStatement pst=con.prepareStatement(q);
                
                rs = con.createStatement().executeQuery(q);

                while(rs.next()){
                   System.out.println(rs.getString("EmailId"));
                     e=rs.getString("EmailId");
                     p=rs.getString("Pass");
                     System.out.println(e+p);
                }
                
                if(e.equals(email) && p.equals(password)){
                     JOptionPane.showMessageDialog(null,"okay");
                      Parent employee_page_parent = FXMLLoader.load(getClass().getResource("BestSelling.fxml"));
                     Scene  employee_page_scene = new Scene(employee_page_parent);
                    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    app_stage.setScene(employee_page_scene);
                    app_stage.show();
                }
                //else{
                    //JOptionPane.showMessageDialog(null,"failed");
                //}
               /* user_email.clear();
                user_password.clear();
                pst.close();
                rs.close();*/
                System.out.println(user_email.getText());
            }  catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"Wrong");
        
        }
    }

    @FXML
    private void goto_forgetPage(ActionEvent event) throws IOException {
        Parent employee_page_parent = FXMLLoader.load(getClass().getResource("ForgetPass.fxml"));
        Scene  employee_page_scene = new Scene(employee_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(employee_page_scene);
        app_stage.show();
    }

    
}

