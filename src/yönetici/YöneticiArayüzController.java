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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author TalhaBadik
 */
public class YöneticiArayüzController implements Initializable {
    @FXML
    private AnchorPane anp_yoneticiarayuz;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void randevuGör(ActionEvent event) throws IOException{
        Scene c = new Scene(FXMLLoader.load(getClass().getResource("Randevular.fxml")));
                    Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
                    st.setScene(c);
                    st.show();
    }

    @FXML
    private void halisahaEkleSil(ActionEvent event) throws IOException{
        Scene c = new Scene(FXMLLoader.load(getClass().getResource("HalisahaEkleSil.fxml")));
                    Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
                    st.setScene(c);
                    st.show();
    }

    @FXML
    private void uyelikHatirlat(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Bu işlem teknik bir arızadan dolayı kullanılamamaktadır");
    }

    @FXML
    private void cikislogin(ActionEvent event) {
        
        
    }
    
}
