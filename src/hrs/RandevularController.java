/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import sınıflar.*;

/**
 * FXML Controller class
 *
 * @author ismail
 */
public class RandevularController implements Initializable {

    @FXML
    private TableView<randevular> twrandevu;
    @FXML
    private TableColumn<randevular,String> colisim;
    @FXML
    private TableColumn<randevular, String> colsoyad;
    @FXML
    private TableColumn<randevular, String> colhalisaha;
    @FXML
    private TableColumn<randevular, String> colsehir;
    @FXML
    private TableColumn<randevular, String> coltarih;
    @FXML
    private Button btn_geri;
    @FXML
    private Button btn_sil;
    @FXML
    private TableColumn<randevular, String> colid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        database db = new database();
        musteriler m = new musteriler();
        colisim.setCellValueFactory(new PropertyValueFactory<randevular,String>("ad"));
        colsoyad.setCellValueFactory(new PropertyValueFactory<randevular,String>("soyad"));
        colhalisaha.setCellValueFactory(new PropertyValueFactory<randevular,String>("halisaha"));
        colsehir.setCellValueFactory(new PropertyValueFactory<randevular,String>("sehir"));
        coltarih.setCellValueFactory(new PropertyValueFactory<randevular,String>("tarih"));
        colid.setCellValueFactory(new PropertyValueFactory<randevular,String>("randevuid"));
        ObservableList<randevular> ol = db.randevu(m.getKullaniciadi());
        twrandevu.setItems(ol);
        
   
        
    }    

    @FXML
    private void geri(ActionEvent event) {
        String a=twrandevu.getSelectionModel().getSelectedItem().getAd();
        JOptionPane.showMessageDialog(null, a);
    }

    @FXML
    private void sil(ActionEvent event) {
        database db = new database();
        ObservableList<randevular> ol = FXCollections.observableArrayList();
        db.sil(twrandevu.getSelectionModel().getSelectedItem().getRandevuid().toString());  
        ol=twrandevu.getItems();
        ol.remove(twrandevu.getSelectionModel().getSelectedItem());        
        
        twrandevu.setItems(ol);
        
        
        
    }
    
}
