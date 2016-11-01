/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import sınıflar.database;
import sınıflar.sehirler;
import javax.swing.*;
import sınıflar.ilceler;
import sınıflar.musteriler;

/**
 * FXML Controller class
 *
 * @author TalhaBadik
 */
public class HalisahalarController implements Initializable {
    @FXML
    private AnchorPane anp_halisahalar;
    @FXML
    private ComboBox<?> cmb_il;
    @FXML
    private ComboBox<?> cmb_ilce;

    /**
     * Initializes the controller class.
     */
    File dizim[];
        int sayac = 0;
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        database db = new database();
        ObservableList iller = FXCollections.observableArrayList();
        iller = db.ilgonder();
        cmb_il.setItems(iller);
        
    }    

    @FXML
    private void randevular(ActionEvent event) {
        database db = new database();
        musteriler m = new musteriler();
        String randevuBilgisi=db.randevuBilgisiGetir(m);
        JOptionPane.showMessageDialog(null, randevuBilgisi);
    }

    @FXML
    private void randevuiptal(ActionEvent event) {
    }

    @FXML
    private void halisahaEkle(ActionEvent event) {
    }

    @FXML
    private void loginGeriGel(ActionEvent event) throws IOException {
        Scene s = new Scene(FXMLLoader.load(getClass().getResource("randevular.fxml")));
          Stage sg = (Stage)((Node)event.getSource()).getScene().getWindow();
            sg.setScene(s);
            sg.show();
    }
    

    @FXML
    private void ilceDoldur(ActionEvent event) {
        database db = new database();
        sehirler s = new sehirler();
        s.setSehirAd(cmb_il.getSelectionModel().getSelectedItem().toString());
        ObservableList ilceler=FXCollections.observableArrayList();
        ilceler = db.ilcegonder(s);
        cmb_ilce.setItems(ilceler);
        
        
        
    }

    public static String seciliIlce,secilenhalisaha;
    @FXML
    private void halisahalistele(ActionEvent event) {
        try
        {
        
        database db = new database();
        ilceler ilce = new ilceler();
        ilce.setIlcead(cmb_ilce.getSelectionModel().getSelectedItem().toString());
        int sayi = db.halisahaSayisiOgren(ilce);
        String [] halisahalar = new String[sayi];
        seciliIlce = cmb_ilce.getSelectionModel().getSelectedItem().toString();
        halisahalar=db.halisahaGetir(ilce);
        int x1=10,y1=220;
            for (int i = 0; i < sayi; i++) {
                File folder = new File("C:\\Users\\Bilgin\\Desktop\\HRSv1\\HRS\\src\\hrs");
                dizim=folder.listFiles();
                Image img=new Image(dizim[sayac].toURI().toString());
                ImageView imgv = new ImageView();
                imgv.setImage(img);
                imgv.setLayoutX(x1);
                imgv.setLayoutY(y1);
                imgv.setFitHeight(80);
                imgv.setFitWidth(120);
                imgv.setId(halisahalar[i]);
                imgv.setOnMouseClicked((event1) -> this.tiklandi(event1));
                x1+=150;
                anp_halisahalar.getChildren().add(imgv);
                
            }
        
        
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void tiklandi(MouseEvent event1) {
        try
        {
        ImageView img = (ImageView)event1.getSource();
        secilenhalisaha = img.getId();
        Scene s = new Scene(FXMLLoader.load(getClass().getResource("HalisahaBilgileri.fxml")));
          Stage sg = (Stage)((Node)event1.getSource()).getScene().getWindow();
            sg.setScene(s);
            sg.show();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
