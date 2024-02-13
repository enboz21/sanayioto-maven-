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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
    private boolean check = true;
    private String pass;
    @FXML
    private Button btn;
    @FXML
    private TextField us;
    @FXML
    private TextField us1;
    @FXML
    private PasswordField pa;

    @FXML
    private void tetik(ActionEvent event) {
        Statement sta = null;
        conn c = new conn();
        try {
            sta = (Statement) c.call();
        } catch (SQLException ex) {
            System.out.println("sql balantı hatası");
            JOptionPane.showMessageDialog(null, "sql balantı hatası");
        }
        ResultSet rs;
        try {
            rs = sta.executeQuery("select * from login");
            user = us.getText();
            if (check) {
                pass = pa.getText();
            } else {
                pass=us1.getText();
            }
            while (rs.next()) {
                String a = rs.getString("name");
                String aa = rs.getString("pas");
                if (user.equals(a) && pass.equals(aa)) {
                    JOptionPane.showMessageDialog(null, "giriş başarılı");
                    c.ekrand(event, "2.fxml", true);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "veri tabanı veri seçme hatası");
        }

        c.kapat();
    }

    @FXML
    public void teke(ActionEvent event) {
        if (check) {
            btn.getStyleClass().remove(1);
            btn.getStyleClass().add("checkboxx");
            pa.setDisable(true);
            pa.setVisible(false);
            us1.setText(pa.getText());
            us1.setDisable(false);
            us1.setVisible(true);
            check = false;
        } else {
            btn.getStyleClass().remove(1);
            btn.getStyleClass().add("checkbox");
            us1.setDisable(false);
            us1.setVisible(false);
            pa.setDisable(false);
            pa.setText(us1.getText());
            pa.setVisible(true);
            check = true;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
/*
Parent root = FXMLLoader.load(getClass().getResource("ekran2.fxml"));
        st=(Stage)(((Node)event.getSource()).getScene().getWindow());
        Scene sc=new Scene(root);
        st.setScene(sc);
        st.show();
 */
