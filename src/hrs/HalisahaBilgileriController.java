/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import sınıflar.database;
import sınıflar.halisahalar;

public class HalisahaBilgileriController implements Initializable {
    @FXML
    private AnchorPane anp_halisahaBilgileri;
    @FXML
    private Button btnhalisahageri;
    @FXML
    private Label lbl_hAd;
    @FXML
    private Label lbl_hAdres;
    @FXML
    private Label lbl_hServis;
    @FXML
    private ImageView imgv1;
    @FXML
    private ImageView imgv2;
    @FXML
    private ImageView imgv3;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        database db = new database();
        db.halisahaBilgileri();
        String [] bilgiler = new String[3];
        bilgiler = db.halisahaBilgileri();
        lbl_hAd.setText(bilgiler[0]);
        lbl_hAdres.setText(bilgiler[1]);
        lbl_hServis.setText(bilgiler[2]);
        
    }    

    @FXML
    private void Halisaha_randevuAl(ActionEvent event) {
        try
            {
                Scene d = new Scene(FXMLLoader.load(getClass().getResource("randevular.fxml")));
                Stage sg = (Stage)((Node)event.getSource()).getScene().getWindow();
                sg.setScene(d);
                sg.show();
            }
        catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
    }

    @FXML
    private void halisahalarGeriGel(ActionEvent event) {
        try
            {
                Scene d = new Scene(FXMLLoader.load(getClass().getResource("Halisahalar.fxml")));
                Stage sg = (Stage)((Node)event.getSource()).getScene().getWindow();
                sg.setScene(d);
                sg.show();
            }
        catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
    }
    
    
}
