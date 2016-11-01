/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yönetici;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sınıflar.database;

/**
 * FXML Controller class
 *
 * @author TalhaBadik
 */
public class HalisahaEkleController implements Initializable {
    @FXML
    private AnchorPane anp_halisahaEkle;
    @FXML
    private TextField txt_halisahaAdi;
    @FXML
    private TextField txt_halisahaAdresi;
    @FXML
    private TextField txt_halisahaServis;
    @FXML
    private TextField txtil;
    @FXML
    private TextField txtilce;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void halisahaKaydet(ActionEvent event) {
        database db = new database();
        
        db.halisahaekle(txtilce.getText(),txt_halisahaAdi.getText(),txt_halisahaAdresi.getText(),txt_halisahaServis.getText());
        
    }

    @FXML
    private void halisahaResimEkle(ActionEvent event) {
    }

    @FXML
    private void HalisahaEkleSilGeri(ActionEvent event) throws IOException{
        Scene c = new Scene(FXMLLoader.load(getClass().getResource("HalisahaEkleSil.fxml")));
                    Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
                    st.setScene(c);
                    st.show();
    }
    
}
