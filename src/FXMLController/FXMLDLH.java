package FXMLController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FXMLDLH implements Initializable{

    @FXML
    private Button keluar;
   
    @FXML
    private Button inputsungai;

    @FXML
    private Button rekap;

    @FXML
    private Button surat;

    @FXML
    private Button inputrekap;
   


    
    @FXML
    private void dipencetinput (ActionEvent event) throws IOException {
         Parent scene1 = FXMLLoader.load(getClass().getResource("/FXMLView/InputSungai.fxml"));
        Scene scene = new Scene(scene1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage p = (Stage) inputsungai.getScene().getWindow();
        p.close();
    }
    @FXML
    private void dipencetrekap (ActionEvent event) throws IOException{
     Parent scene1 = FXMLLoader.load(getClass().getResource("/FXMLView/InputLab.fxml"));
        Scene scene = new Scene(scene1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage p = (Stage) rekap.getScene().getWindow();
        p.close();
    }
    @FXML
    private void dipencetsurattugas (ActionEvent event) throws IOException{
        Parent scene1 = FXMLLoader.load(getClass().getResource("/FXMLView/SuratTugas.fxml"));
        Scene scene = new Scene(scene1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage p = (Stage) surat.getScene().getWindow();
        p.close();
    }
    @FXML
    private void dipencetinputrekap (ActionEvent event) throws IOException{
        Parent scene1 = FXMLLoader.load(getClass().getResource("/FXMLView/InputRekapSungai.fxml"));
        Scene scene = new Scene(scene1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage p = (Stage) inputrekap.getScene().getWindow();
        p.close();

    }
    @FXML
    private void keluardlh (ActionEvent event) throws IOException{
        Parent scene1 = FXMLLoader.load(getClass().getResource("/FXMLView/HalamanPemilihan.fxml"));
        Scene scene = new Scene(scene1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage p = (Stage) keluar.getScene().getWindow();
        p.close();

    }





    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
    }

    
}