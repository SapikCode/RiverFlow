package FXMLController;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import Model.DataUserBaru;
import Model.Indeks;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FXMLUser implements Initializable{

    @FXML
    private Button berita;
    @FXML
    private Button lagoon;
    @FXML
    private Button lainnya;
    @FXML
    private Button logout;
    @FXML
    private Label Namauser;
   

    @FXML
    private void dipencetberita (ActionEvent event) throws IOException{
        Parent scene1 = FXMLLoader.load(getClass().getResource("/FXMLView/Berita.fxml"));
        Scene scene = new Scene(scene1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage p = (Stage) berita.getScene().getWindow();
        p.close(); 
    }

    @FXML
    private void dipencetlagoon (ActionEvent event) throws IOException{
         Parent scene1 = FXMLLoader.load(getClass().getResource("/FXMLView/DataRekapSungai.fxml"));
        Scene scene = new Scene(scene1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage p = (Stage) lagoon.getScene().getWindow();
        p.close(); 

    }

    @FXML
    private void dipencetlainnya (ActionEvent event) throws IOException{
         Parent scene1 = FXMLLoader.load(getClass().getResource("/FXMLView/RekapSungai.fxml"));
        Scene scene = new Scene(scene1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage p = (Stage) lainnya.getScene().getWindow();
        p.close(); 
    }

    @FXML
    private void dipencetlogout (ActionEvent event) throws IOException{
         Parent scene1 = FXMLLoader.load(getClass().getResource("/FXMLView/HalamanPemilihan.fxml"));
        Scene scene = new Scene(scene1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage p = (Stage) logout.getScene().getWindow();
        p.close(); 

    }
     java.util.ArrayList<DataUserBaru> listakunbaru = new java.util.ArrayList <DataUserBaru> ();
   
    XStream xstream = new XStream(new StaxDriver());
    Indeks ind;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OpenIndeks();
        OpenXml();
        int indeks = ind.getInd();
        DataUserBaru p = listakunbaru.get(indeks);
        Namauser.setText(p.getNama());
        // TODO 
    }
    void OpenXml() {
        FileInputStream inputDoc;

        try {
            inputDoc = new FileInputStream("listakunbaru.xml");
            int content;
            char c;
            String s = "";
            while ((content = inputDoc.read()) != -1) {
                c = (char) content;
                s += c;
            }

            listakunbaru= (java.util.ArrayList<DataUserBaru>) xstream.fromXML(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    void OpenIndeks() {

        FileInputStream berkasMasuk;

        try {
            berkasMasuk = new FileInputStream("Indeks.xml");
            int isi;
            char c;
            String s = "";
            while ((isi = berkasMasuk.read()) != -1) {

                c = (char) isi;
                s = s + c;

            }
            ind = (Indeks) xstream.fromXML(s);
        } catch (Exception e) {
            System.out.println("terjadi kkesallahn");
        }
    }



    
}
