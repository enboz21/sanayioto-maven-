/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package araba;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author enesb
 */
public class conn {
    private static Connection c;

    public conn() {
        c=null;
    }
    
    public Statement call() throws SQLException {
        System.out.println("burda");
        c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/data/ara.sqlite");
        System.out.println("bura 1");
        Statement st = (Statement) c.createStatement();
        System.out.println("bura2");
        return st;
    }
    public void kapat(){
        try {
            c.close();
        } catch (SQLException ex) {
            System.out.println("zaten kapalı");
            JOptionPane.showMessageDialog(null, "zaten kapalı");
        }
    }
    public void ekrand(ActionEvent event,String ekran,boolean a){
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("2.fxml"));
            Stage st=(Stage)(((Node)event.getSource()).getScene().getWindow());
            Scene sc=new Scene(root);
            st.setScene(sc);
            st.setResizable(a);
            st.show();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ekran bulunamadı");
        }
    }
}
