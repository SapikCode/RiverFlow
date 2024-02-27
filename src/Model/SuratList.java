package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SuratList {
      private ObservableList<SuratData> listsurat;
    
    public SuratList(){
        listsurat = FXCollections.observableArrayList();
        
    }
    public ObservableList<SuratData> getSurat(){
        return this.listsurat;
    }
    public void setData (String Sungai, String Petugas ,String Tanggal,String Deskripsi){
        listsurat.add(new SuratData(Sungai, Petugas, Tanggal, Deskripsi));
    }
    public void showData(){
        for (int i = 0 ; i< 1 ; i++){
            System.out.println(listsurat.toString());
        }
    }
}
