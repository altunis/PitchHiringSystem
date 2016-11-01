/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yönetici;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sınıflar.*;

/**
 * FXML Controller class
 *
 * @author TalhaBadik
 */
public class RandevularController implements Initializable {
    @FXML
    private AnchorPane anp_yöneticiRandevular;
    @FXML
    private TableView<randevular> tbl_randevular;
    @FXML
    private TableColumn<randevular, String> colid;
    @FXML
    private TableColumn<randevular, String> coldad;
    @FXML
    private TableColumn<randevular, String> colsoyad;
    @FXML
    private TableColumn<randevular, String> colil;
    @FXML
    private TableColumn<randevular, String> colhalisaha;
    @FXML
    private TableColumn<randevular, String> coltarih;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<randevular> ol = FXCollections.observableArrayList();
       coldad.setCellValueFactory(new PropertyValueFactory<randevular,String>("ad"));
       colsoyad.setCellValueFactory(new PropertyValueFactory<randevular,String>("soyad"));
       colil.setCellValueFactory(new PropertyValueFactory<randevular,String>("sehir"));
       colhalisaha.setCellValueFactory(new PropertyValueFactory<randevular,String>("halisaha"));
       coltarih.setCellValueFactory(new PropertyValueFactory<randevular,String>("tarih"));
       colid.setCellValueFactory(new PropertyValueFactory<randevular,String>("randevuid"));
       database db  = new database();
       ol = db.listele();
       tbl_randevular.setItems(ol);
       
       
       
       
    }    

    @FXML
    private void RandevulariSil(ActionEvent event) {
        database db = new database();
        ObservableList<randevular> ol = FXCollections.observableArrayList();
        db.sil(tbl_randevular.getSelectionModel().getSelectedItem().getRandevuid().toString());  
        ol=tbl_randevular.getItems();
        ol.remove(tbl_randevular.getSelectionModel().getSelectedItem());        
        
        tbl_randevular.setItems(ol);
    }

    @FXML
    private void YöneticiArayüzGeri(ActionEvent event)throws  IOException {
        Scene c = new Scene(FXMLLoader.load(getClass().getResource("YöneticiArayüz.fxml")));
                    Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
                    st.setScene(c);
                    st.show();
    }
    
}
