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

public class FXMLBerita implements Initializable {

    @FXML
    private Button kembali;
    @FXML
    private Button selsatu;
    @FXML
    private Button seldua;
    @FXML
    private Button seltiga;

    @FXML
    private void kembaliuser (ActionEvent event) throws IOException{
          Parent scene1 = FXMLLoader.load(getClass().getResource("/FXMLView/MainUser.fxml"));
        Scene scene = new Scene(scene1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage p = (Stage) kembali.getScene().getWindow();
        p.close();

    }
    @FXML
    private void dipencetselsatu (ActionEvent event) throws IOException, URISyntaxException{
        Desktop.getDesktop().browse(new URI("https://www.idntimes.com/hype/viral/seo-intern/pandawara-group-viral-karena-aksi-bersih-sungai"));
    }
    @FXML
    private void dipencetseldua (ActionEvent event) throws IOException, URISyntaxException{
        Desktop.getDesktop().browse(new URI("https://jogja.tribunnews.com/2023/05/10/dlh-kota-yogyakarta-gelar-pengujian-kualitas-air-sungai"));
    }
    @FXML
    private void dipencetseltiga (ActionEvent event) throws IOException, URISyntaxException{
         Desktop.getDesktop().browse(new URI("https://jogja.tribunnews.com/2022/09/28/air-sungai-di-kota-yogyakarta-semakin-tercemar-kondisi-kali-code-paling-baik"));
    }
    









    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
    }
    
}
