/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garments.management.system;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mohammad Rasel
 */
public class StatreportController implements Initializable {

    @FXML
      private LineChart<String, Number> lineChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showmeline(ActionEvent event) {
        
        lineChart.getData().clear();
        XYChart.Series<String,Number> series=new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("Jan",200));
        series.getData().add(new XYChart.Data<>("April",500));
        series.getData().add(new XYChart.Data<>("August",700));
        series.getData().add(new XYChart.Data<>("December",100));
        series.setName("Total Order");
        lineChart.getData().add(series);
        
    }

    @FXML
    private void printthereport(ActionEvent event) {
    }

    @FXML
    private void gotohomepage(ActionEvent event) throws IOException {
        
            Parent employee_page_parent = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        Scene  employee_page_scene = new Scene(employee_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(employee_page_scene);
        app_stage.show();
    }
    
}
