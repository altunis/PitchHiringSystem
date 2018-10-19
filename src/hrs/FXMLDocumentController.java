/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs;

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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import sınıflar.database;
import sınıflar.musteriler;
import sınıflar.sehirler;
import yönetici.*;

public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private AnchorPane anp_login;
    @FXML
    private Hyperlink hl_uyeOl;
    @FXML
    private TextField txt_kullaniciAdi;
    private TextField txt_sifre;
    @FXML
    private Button btn_giris;
    @FXML
    private PasswordField passwordField;
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void giris(ActionEvent event) throws IOException {
        database db = new database();
        musteriler musteri = new musteriler();
        musteri.setKullaniciadi(txt_kullaniciAdi.getText());
        musteri.setSifre(passwordField.getText());
        String ad = db.giris(musteri);
        if (ad ==null)
        {
            JOptionPane.showMessageDialog(null, "Kullanıcı Adı ya da Şifre Hatalı!");
        }
        else if(ad.equals("admin")){
            Scene c = new Scene(FXMLLoader.load(getClass().getResource("/yönetici/YöneticiArayüz.fxml")));
                    Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
                    st.setScene(c);
                    st.show();
        }
        else{
        {
            try
                {
                    Scene d = new Scene(FXMLLoader.load(getClass().getResource("Halisahalar.fxml")));
                    Stage sg = (Stage)((Node)event.getSource()).getScene().getWindow();
                    sg.setScene(d);
                    sg.show();
         }
            catch(Exception e)
            {
                    JOptionPane.showMessageDialog(null, e.getMessage());
            }}
        }
    }

    @FXML
    private void uyelikgecis(ActionEvent event) {
         try
         {Scene d = new Scene(FXMLLoader.load(getClass().getResource("uyeKaydi.fxml")));
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
