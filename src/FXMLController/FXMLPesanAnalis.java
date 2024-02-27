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

import Model.SuratData;
import javafx.collections.ObservableList;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FXMLPesanAnalis implements Initializable {
    
    @FXML
    private Button kembali;
    @FXML
    private Button hapus;
    @FXML
    private Button simpan;

    @FXML
    private void kemenuanalis (ActionEvent event) throws IOException{
         Parent scene1 = FXMLLoader.load(getClass().getResource("/FXMLView/MainAnalis.fxml"));
        Scene scene = new Scene(scene1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage p = (Stage) kembali.getScene().getWindow();
        p.close();
    }

    @FXML
    private TableView Tablesurat;
    @FXML
    private TableColumn <SuratData,String> Tsungai;
    @FXML
    private TableColumn <SuratData,String> Tpetugas;
    @FXML
    private TableColumn <SuratData,String> Ttanggal;
    @FXML
    private TableColumn <SuratData,String> Tdeskripsi;

     ArrayList<SuratData> listsurat = new ArrayList<SuratData>();
    
    ObservableList datasurat = observableArrayList();
    XStream xstream = new XStream(new StaxDriver());

     @FXML
    private void dipencethapus(ActionEvent event) {
        TableView.TableViewSelectionModel selectionModel = Tablesurat.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        int i = selectionModel.getSelectedIndex();

        if (i >= 0) {
            datasurat.remove(i);
            listsurat.remove(i);
        }

        simpanData();
    }

     void OpenData() {
        
        FileInputStream berkasMasuk;

        try {
            berkasMasuk = new FileInputStream("listsuratdata.xml");
            int isi;
            char c;
            String s = "";
            while ((isi = berkasMasuk.read()) != -1) {

                c = (char) isi;
                s = s + c;

            }
         listsurat = (ArrayList<SuratData>) xstream.fromXML(s);
            berkasMasuk.close();
        } catch (Exception e) {
            System.out.println("terjadi kkesallahn");
        }
    }
     void simpanData() {
        String xml = xstream.toXML(listsurat);
        FileOutputStream outDoc;
        try {
            byte[] data = xml.getBytes("UTF-8");
            outDoc = new FileOutputStream("listsuratdata.xml");
            outDoc.write(data);
            outDoc.close();
        } catch (Exception io) {
            System.err.println("An error occurs: " + io.getMessage());
        }
        System.out.println("Data sudah disimpan");
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Tsungai.setCellValueFactory(new PropertyValueFactory <> ("Sungai"));
      Tpetugas.setCellValueFactory(new PropertyValueFactory <> ("Petugas"));
      Ttanggal.setCellValueFactory(new PropertyValueFactory <> ("Tanggal"));
      Tdeskripsi.setCellValueFactory(new PropertyValueFactory <> ("Deskripsi"));
      
      
      OpenData();
      simpanData();
      File f = new File("listsuratdata.xml");
      if (f.exists() && !f.isDirectory()){
          OpenData();
          for(int i = 0; i < listsurat.size(); i++){
              datasurat.add(listsurat.get(i));
          }
      }
      for (int i = 0 ;i<listsurat.size();i++){
          System.out.println(listsurat.toString());
      }
      Tablesurat.setItems(datasurat);
        
    }
    
}
