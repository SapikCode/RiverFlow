package FXMLController;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import Model.DataUserBaru;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLPendaftaranAkun implements Initializable {
    @FXML
    private Button logindaftar;
    
    @FXML
    private ChoiceBox Tfjekel;

    @FXML
    private ChoiceBox Tfpilihlog;

    @FXML
    private TextField Tfnama;

    @FXML
    private TextField Tfusername;

    @FXML
    private TextField Tfpassword;

    @FXML
    private TextField Tftanggal;

    @FXML
    private TextField Tfemail;

    @FXML
    private TextField Tfnohp;

    @FXML
    private TextField Tfdomisili;

    @FXML
    private Button simpan;

    @FXML
    private void dipencetlogindaftar (ActionEvent event) throws IOException{
        Parent scene1 = FXMLLoader.load(getClass().getResource("/FXMLView/HalamanPemilihan.fxml"));
        Scene scene = new Scene(scene1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage p = (Stage) logindaftar.getScene().getWindow();
        p.close();
    }






    //data
    private String Nama,Username,Password,Tanggal,JKelamin,Email,Nohp,Domisili,Pilihan;
    XStream xstream = new XStream(new StaxDriver());

      ArrayList<DataUserBaru> listakunbaru = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    Tfjekel.getItems().addAll("Pria","Wanita");
    Tfpilihlog.getItems().addAll("DLH","Analis","User");

    OpenXml();
    }
    @FXML
    private void dipencetsimpan (ActionEvent event) throws IOException{
        
         File f = new File("listakunbaru.xml");
        if (f.exists() && !f.isDirectory()) {
            System.out.println("file nya adaaa");
            OpenXml();
        }
        Nama = (String) Tfnama.getText();
        Username = (String) Tfusername.getText();
        Password = (String) Tfpassword.getText();
        Tanggal = (String) Tftanggal.getText();
        JKelamin = (String) Tfjekel.getValue();
        Email = (String) Tfemail.getText();
        Nohp = (String) Tfnohp.getText();
        Domisili = (String) Tfdomisili.getText();
        Pilihan = (String) Tfpilihlog.getValue();
        listakunbaru.add(new DataUserBaru(Nama,Username,Password,Tanggal,JKelamin,Email,Nohp,Domisili,Pilihan));
        SaveAndCreate();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLView/HalamanPemilihan.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage Keluar = (Stage) simpan.getScene().getWindow();
        Keluar.close();

        //TODO
        }
        void OpenXml(){
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

            listakunbaru = (ArrayList<DataUserBaru>) xstream.fromXML(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }

        void SaveAndCreate(){
            FileOutputStream outputDoc;
        String xml = xstream.toXML(listakunbaru);
        File f = new File("listakunbaru.xml");
        try {
            byte[] data = xml.getBytes();
            outputDoc = new FileOutputStream("listakunbaru.xml");
            outputDoc.write(data);
            outputDoc.close();
            System.out.println("add data success");
        } catch (Exception error) {
            System.err.println("An error occur: " + error.getMessage());
        }
        }

    
}
