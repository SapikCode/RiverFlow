package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RekapList {
     private ObservableList<DataRekapSungai> listrekap;
    
    public RekapList(){
        listrekap = FXCollections.observableArrayList();
        
    }
    public ObservableList<DataRekapSungai> getDataRekap(){
        return this.listrekap;
    }
    public void setData (String Namasungai, String Tanggal,String Suhu,String Ph,String Warna,String Bau,String Kondisi,String Grade){
        listrekap.add(new DataRekapSungai(Namasungai, Tanggal, Suhu, Ph, Warna, Bau, Kondisi, Grade));
    }
    public void showData(){
        for (int i = 0 ; i< 1 ; i++){
            System.out.println(listrekap.toString());
        }
    }
        
}


