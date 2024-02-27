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

import Model.DataRekapSungai;
import Model.SuratData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLSuratTugas implements Initializable{
    @FXML
    private Button kembali;
    @FXML
    private Button simpan;

    @FXML
    private void kembalikemenu (ActionEvent event) throws IOException{
        Parent scene1 = FXMLLoader.load(getClass().getResource("/FXMLView/MainDLH.fxml"));
        Scene scene = new Scene(scene1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage p = (Stage) kembali.getScene().getWindow();
        p.close();
    }
    
    @FXML
    private TextField Tsungai;
    @FXML
    private TextField Tpetugas;
    @FXML
    private TextField Ttanggal;
    @FXML
    private TextField Tdeskripsi;
    @FXML
    private Label label;

    @FXML
    private String Sungai, Petugas, Tanggal, Deskripsi;
    XStream xstream = new XStream(new StaxDriver());
    
    ArrayList<SuratData> listsuratdata = new ArrayList<>();

    













    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        OpenXml();
    }
    @FXML
    private void dipencetsimpan (ActionEvent event){
      File f = new File("listsuratdata.xml");
        if (f.exists() && !f.isDirectory()) {
            System.out.println("file nya adaaa");
            OpenXml();
        }

            Sungai = Tsungai.getText();
            Petugas = Tpetugas.getText();
            Tanggal = Ttanggal.getText();
            Deskripsi = Tdeskripsi.getText();
            System.out.println(Sungai);
            System.out.println(Petugas);
            System.out.println(Tanggal);
            System.out.println(Deskripsi);

            listsuratdata.add(new SuratData(Sungai, Petugas, Tanggal, Deskripsi));
        SaveAndCreate();
        label.setText("Data Disimpan");
        }
         void OpenXml() {
        FileInputStream inputDoc;

        try {
            inputDoc = new FileInputStream("listsuratdata.xml");
            int content;
            char c;
            String s = "";
            while ((content = inputDoc.read()) != -1) {
                c = (char) content;
                s += c;
            }

            listsuratdata = (ArrayList<SuratData>) xstream.fromXML(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
     void SaveAndCreate(){
         FileOutputStream outputDoc;
        String xml = xstream.toXML(listsuratdata);
        File f = new File("listsuratdata.xml");
        try {
            byte[] data = xml.getBytes();
            outputDoc = new FileOutputStream("listsuratdata.xml");
            outputDoc.write(data);
            outputDoc.close();
            System.out.println("add data success");
        } catch (Exception error) {
            System.err.println("An error occur: " + error.getMessage());
        }
    }

    
}
