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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLRekapSungai implements Initializable{
    @FXML
    private Button kembali;
    @FXML
    private Button simpan;
    @FXML
    private Label label;

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
    private TextField Tfsungai;
    @FXML
    private TextField Tftanggal;
    @FXML
    private TextField Tfsuhu;
    @FXML
    private TextField Tfph;
    @FXML
    private ChoiceBox Tfwarna;
    @FXML
    private ChoiceBox Tfbau;
    @FXML
    private ChoiceBox Tfkondisi;
    @FXML 
    private ChoiceBox Tfgrade;

    private String Namasungai, Tanggal, Suhu, Ph, Warna, Bau, Kondisi, Grade;

    XStream xstream = new XStream(new StaxDriver());
    
    ArrayList<DataRekapSungai> listrekapsungai = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Tfgrade.getItems().addAll("A","B","C");
        Tfbau.getItems().addAll("Tidak Bau","Tidak Sedap");
        Tfkondisi.getItems().addAll("Terawat","Tidak Terawat");
        Tfwarna.getItems().addAll("Biru","Coklat");
        // TODO 
        OpenXml();
    }

    @FXML
    private void dipencetsimpan (ActionEvent event){
      File f = new File("listrekapsungai.xml");
        if (f.exists() && !f.isDirectory()) {
            System.out.println("file nya adaaa");
            OpenXml();
        }

            Namasungai = Tfsungai.getText();
            Tanggal = Tftanggal.getText();
            Suhu = Tfsuhu.getText();
            Ph = Tfph.getText();
            Warna = (String) Tfwarna.getValue();
            Bau = (String) Tfbau.getValue();
            Kondisi = (String) Tfkondisi.getValue();
            Grade = (String) Tfgrade.getValue();
            System.out.println(Namasungai);
            System.out.println(Tanggal);
            System.out.println(Suhu);
            System.out.println(Ph);
            System.out.println(Warna);
            System.out.println(Bau);
            System.out.println(Kondisi);
            System.out.println(Grade);

            listrekapsungai.add(new DataRekapSungai(Namasungai, Tanggal, Suhu, Ph, Warna, Bau, Kondisi, Grade));
        SaveAndCreate();
        label.setText("Data Disimpan");
        }
    
    void OpenXml() {
        FileInputStream inputDoc;

        try {
            inputDoc = new FileInputStream("listrekapsungai.xml");
            int content;
            char c;
            String s = "";
            while ((content = inputDoc.read()) != -1) {
                c = (char) content;
                s += c;
            }

            listrekapsungai = (ArrayList<DataRekapSungai>) xstream.fromXML(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void SaveAndCreate(){
         FileOutputStream outputDoc;
        String xml = xstream.toXML(listrekapsungai);
        File f = new File("listrekapsungai.xml");
        try {
            byte[] data = xml.getBytes();
            outputDoc = new FileOutputStream("listrekapsungai.xml");
            outputDoc.write(data);
            outputDoc.close();
            System.out.println("add data success");
        } catch (Exception error) {
            System.err.println("An error occur: " + error.getMessage());
        }
    }
}

