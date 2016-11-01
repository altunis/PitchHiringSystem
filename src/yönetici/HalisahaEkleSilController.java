/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yönetici;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sınıflar.*;

/**
 * FXML Controller class
 *
 * @author TalhaBadik
 */
public class HalisahaEkleSilController implements Initializable {
    @FXML
    private AnchorPane anp_halisahaEkleSil;
    @FXML
    private TableView<halisahalar> tbl_halisahalar;
    
    @FXML
    private TableColumn<halisahalar, String> colhalisahaad;
   
    @FXML
    private TableColumn<halisahalar,String> coladres;
    @FXML
    private TableColumn<halisahalar, String> colservis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        database db  = new database();
        ObservableList<halisahalar> ol = FXCollections.observableArrayList();
             
       colhalisahaad.setCellValueFactory(new PropertyValueFactory<halisahalar,String>("halisahaAd"));
       coladres.setCellValueFactory(new PropertyValueFactory<halisahalar,String>("adres"));
       colservis.setCellValueFactory(new PropertyValueFactory<halisahalar,String>("servis"));
       
       ol = db.hlistele();
       tbl_halisahalar.setItems(ol);
        
    }    

    @FXML
    private void YöneticiArayüzGeri(ActionEvent event) throws IOException{
        Scene c = new Scene(FXMLLoader.load(getClass().getResource("YöneticiArayüz.fxml")));
                    Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
                    st.setScene(c);
                    st.show();
    }

    @FXML
    private void HalisahaSil(ActionEvent event) {
        database db = new database();
        ObservableList<halisahalar> ol = FXCollections.observableArrayList();
        db.halisahasil(tbl_halisahalar.getSelectionModel().getSelectedItem().getHalisahaAd());  
        ol=tbl_halisahalar.getItems();
        ol.remove(tbl_halisahalar.getSelectionModel().getSelectedItem());        
        
        tbl_halisahalar.setItems(ol);
        
    }

    @FXML
    private void HalisahaEkle(ActionEvent event)throws IOException{
        Scene c = new Scene(FXMLLoader.load(getClass().getResource("HalisahaEkle.fxml")));
                    Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
                    st.setScene(c);
                    st.show();
    }
    
}
