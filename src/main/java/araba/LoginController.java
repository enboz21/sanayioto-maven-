/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package araba;

import java.sql.Statement;
import java.sql.ResultSet;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author enesb
 */
public class LoginController implements Initializable {
    private String user;
    private String pass;
    @FXML
    private TextField us;
    @FXML
    private PasswordField pa;
    @FXML
    private void tetik(ActionEvent event){
        Statement sta = null;
        conn c=new conn();
        try {
            sta = (Statement) c.call();
        } catch (SQLException ex) {
            System.out.println("sql balantı hatası");
            JOptionPane.showMessageDialog(null, "sql balantı hatası");
        }
        ResultSet rs;
        try {
            rs = sta.executeQuery("select * from login");
            user=us.getText();
            pass=pa.getText();
            while (rs.next()) {
                String a=rs.getString("name");
                String aa=rs.getString("pas");
                if (user.equals(a)&&pass.equals(aa)) {
                    JOptionPane.showMessageDialog(null, "giriş başarılı");
                    c.ekrand(event, "2.fxml",true);
                }
        }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "veri tabanı veri seçme hatası");
        }
        
        
        c.kapat();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
/*
Parent root = FXMLLoader.load(getClass().getResource("ekran2.fxml"));
        st=(Stage)(((Node)event.getSource()).getScene().getWindow());
        Scene sc=new Scene(root);
        st.setScene(sc);
        st.show();
*/
