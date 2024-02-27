package FXMLController;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.awt.Desktop;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FXMLDataRekap implements Initializable {
    @FXML
    private Button kembali;
    @FXML
    private Button lokasi;

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
    private void dipencetlokasi (ActionEvent event) throws IOException, URISyntaxException{
          Desktop.getDesktop().browse(new URI("https://goo.gl/maps/zQ48uUbeb4HjVwM28"));
    }









    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
    }
    
    
}
