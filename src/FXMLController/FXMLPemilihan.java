
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

public class FXMLPemilihan implements Initializable  {
@FXML
private Button pilihansatu;
@FXML
private Button pilihandua;
@FXML
private Button pilihantiga;
@FXML
private Button daftar;
@FXML 
private void dipencetdlh(ActionEvent event) throws IOException{
     Parent scene1 = FXMLLoader.load(getClass().getResource("/FXMLView/LoginDLH.fxml"));
        Scene scene = new Scene(scene1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage p = (Stage) pilihansatu.getScene().getWindow();
        p.close();

}
@FXML 
private void dipencetanalis(ActionEvent event) throws IOException{
    Parent scene1 = FXMLLoader.load(getClass().getResource("/FXMLView/LoginAnalis.fxml"));
        Scene scene = new Scene(scene1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage p = (Stage) pilihandua.getScene().getWindow();
        p.close();
    
}
@FXML 
private void dipencetuser(ActionEvent event) throws IOException{
    Parent scene1 = FXMLLoader.load(getClass().getResource("/FXMLView/LoginUser.fxml"));
        Scene scene = new Scene(scene1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage p = (Stage) pilihantiga.getScene().getWindow();
        p.close();
    
}
@FXML
private void dipencetdaftar (ActionEvent event) throws IOException{
    Parent scene1 = FXMLLoader.load(getClass().getResource("/FXMLView/FXMLPendaftaranAkun.fxml"));
        Scene scene = new Scene(scene1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage p = (Stage) daftar.getScene().getWindow();
        p.close();
}









    @Override
    public void initialize(URL url, ResourceBundle rb) {
    // TODO 
    }



    
}
