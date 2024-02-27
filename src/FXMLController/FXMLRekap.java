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
import Model.RekapList;
import javafx.collections.ObservableList;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FXMLRekap implements Initializable  {

    @FXML
    private Button kembali;
    @FXML
    private Button hapus;
    @FXML
    private Button simpan;
    @FXML
    private Label label;
    @FXML
    private void kembalikemenu (ActionEvent event) throws IOException{
        Parent scene1 = FXMLLoader.load(getClass().getResource("/FXMLView/MainUser.fxml"));
        Scene scene = new Scene(scene1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage p = (Stage) kembali.getScene().getWindow();
        p.close();
        
    }




    @FXML 
    private TableView <DataRekapSungai> Tablerekap;
    @FXML
    private TableColumn <DataRekapSungai,String> Tnama;
    @FXML
    private TableColumn <DataRekapSungai,String> Ttanggal;
    @FXML
    private TableColumn <DataRekapSungai,String> Tsuhu;
    @FXML
    private TableColumn <DataRekapSungai,String> Tph;
    @FXML
    private TableColumn <DataRekapSungai,String> Twarna;
    @FXML
    private TableColumn <DataRekapSungai,String> Tbau;
    @FXML
    private TableColumn <DataRekapSungai,String> Tkondisi;
    @FXML
    private TableColumn <DataRekapSungai,String> Tgrade;

    ArrayList<DataRekapSungai> listrekap = new ArrayList<DataRekapSungai>();
    
    ObservableList DataRekap = observableArrayList();
    XStream xstream = new XStream(new StaxDriver());

    @FXML
    private void dipencethapus (ActionEvent event){
         TableView.TableViewSelectionModel selectionModel = Tablerekap.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        int i = selectionModel.getSelectedIndex();

        if (i >= 0) {
            DataRekap.remove(i);
            listrekap.remove(i);
        }

        simpanData();
    }
    @FXML
    private void dipencetsimpan (ActionEvent event){
        label.setText("Data Diperbarui");
    }
    

   void OpenData() {
        
        FileInputStream berkasMasuk;

        try {
            berkasMasuk = new FileInputStream("listrekapsungai.xml");
            int isi;
            char c;
            String s = "";
            while ((isi = berkasMasuk.read()) != -1) {

                c = (char) isi;
                s = s + c;

            }

            listrekap = (ArrayList<DataRekapSungai>) xstream.fromXML(s);
            berkasMasuk.close();
        } catch (Exception e) {
            System.out.println("terjadi kkesallahn");
        }
    }
    void simpanData() {
        String xml = xstream.toXML(listrekap);
        FileOutputStream outDoc;
        try {
            byte[] data = xml.getBytes("UTF-8");
            outDoc = new FileOutputStream("listrekapsungai.xml");
            outDoc.write(data);
            outDoc.close();
        } catch (Exception io) {
            System.err.println("An error occurs: " + io.getMessage());
        }
        System.out.println("Data sudah disimpan");
    }

     @Override
    public void initialize(URL url, ResourceBundle rb) {
       Tnama.setCellValueFactory(new PropertyValueFactory <> ("Namasungai"));
      Ttanggal.setCellValueFactory(new PropertyValueFactory <> ("Tanggal"));
      Tsuhu.setCellValueFactory(new PropertyValueFactory <> ("Suhu"));
      Tph.setCellValueFactory(new PropertyValueFactory <> ("Ph"));
      Twarna.setCellValueFactory(new PropertyValueFactory <> ("Warna"));
      Tbau.setCellValueFactory(new PropertyValueFactory <> ("Bau"));
      Tkondisi.setCellValueFactory(new PropertyValueFactory <> ("Kondisi"));
      Tgrade.setCellValueFactory(new PropertyValueFactory <> ("Grade"));
      
      OpenData();
      File f = new File("listrekapsungai.xml");
      if (f.exists() && !f.isDirectory()){
          OpenData();
          for(int i = 0; i < listrekap.size(); i++){
              DataRekap.add(listrekap.get(i));
          }
      }
      for (int i = 0 ;i<listrekap.size();i++){
          System.out.println(listrekap.toString());
      }
      Tablerekap.setItems(DataRekap);
    }
    
}
