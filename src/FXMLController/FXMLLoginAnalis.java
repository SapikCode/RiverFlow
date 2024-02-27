package FXMLController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLLoginAnalis implements Initializable{

@FXML
private Button buttonanalis;

@FXML 
private Label gagal;

java.util.ArrayList<DataUserBaru> listakunbaru = new java.util.ArrayList<>();

    DataUserBaru datauser;
    Indeks ind;

     XStream xstream = new XStream(new StaxDriver());


      @FXML
    private TextField TfNama;

    @FXML
    private TextField TfPass;

    @FXML
    private void loginanalis (ActionEvent event) throws IOException{
         for (int i = 0; i < listakunbaru.size(); i++) {
            datauser = listakunbaru.get(i);
            if(TfNama.getText().equals("") && TfPass.getText().equals("")){
                gagal.setText("Tidak Bisa Masuk , Coba Lagi");
                break;
            }
            if (TfNama.getText().equals(datauser.getUsername()) && TfPass.getText().equals(datauser.getPassword())) {
                ind = new Indeks(i);
                FileOutputStream outputDoc;
                String xml = xstream.toXML(ind);
                File f = new File("Indeks.xml");
                try {
                    byte[] data = xml.getBytes();
                    outputDoc = new FileOutputStream("Indeks.xml");
                    outputDoc.write(data);
                    outputDoc.close();
                    System.out.println("add data success");
                } catch (Exception error) {
                    System.err.println("An error occur: " + error.getMessage());
                }
                Parent scene2 = FXMLLoader.load(getClass().getResource("/FXMLView/MainAnalis.fxml"));
                Scene scene = new Scene(scene2);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Dashboard");
                stage.show();
                Stage Keluar = (Stage) buttonanalis.getScene().getWindow();
                Keluar.close();
                
               
            
            } 
            else{
                gagal.setText("Tidak Bisa Masuk , Coba Lagi");
                 
            }

    }
}







    @Override
    public void initialize(URL location, ResourceBundle resources) {

        OpenXmlUser();
        // TODO
    }

    void OpenXmlUser(){
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

            listakunbaru = (java.util.ArrayList<DataUserBaru>) xstream.fromXML(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}






    

   