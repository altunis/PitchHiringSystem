/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import sınıflar.database;
import sınıflar.musteriler;

/**
 * FXML Controller class
 *
 * @author TalhaBadik
 */
public class UyeKaydiController implements Initializable {
    @FXML
    private TextField txt_uyeKullaniciAdi;
    @FXML
    private TextField txt_uyeEmail;
    @FXML
    private TextField txt_uyeAd;
    @FXML
    private TextField txt_uyeSoyad;
    @FXML
    private TextField txt_uyeTelefon;
    @FXML
    private DatePicker dp_uyeDogumTarihi;
    @FXML
    private Button btn_uyeKaydi;
    @FXML
    private PasswordField passwordSifre;
    @FXML
    private Button btn_geri;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void Kaydet(ActionEvent event) {
        database db = new database();
        musteriler musteri = new musteriler();
        LocalDate localDate = dp_uyeDogumTarihi.getValue();
        musteri.setMusteriAd(txt_uyeAd.getText());
        musteri.setMusteriSoyad(txt_uyeSoyad.getText());
        musteri.setMusteriDogum(localDate.toString());
        musteri.setMusteriTel(txt_uyeTelefon.getText());
        musteri.setMusteriEmail(txt_uyeEmail.getText());
        musteri.setKullaniciadi(txt_uyeKullaniciAdi.getText());
        musteri.setSifre(passwordSifre.getText());
        db.kayitol(musteri);
    }

    @FXML
    private void loginGeriGel(ActionEvent event){
        try
         {Scene d = new Scene(FXMLLoader.load(getClass().getResource("FXMLDocument.fxml")));
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
