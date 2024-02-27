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

public class FXMLLoginRiverFlow implements Initializable{
    @FXML
    private Button login;

    @FXML
    private void dipencetlogin (ActionEvent event) throws IOException{
         Parent scene1 = FXMLLoader.load(getClass().getResource("/FXMLView/HalamanPemilihan.fxml"));
        Scene scene = new Scene(scene1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage p = (Stage) login.getScene().getWindow();
        p.close(); 
    }
    








    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
}
}