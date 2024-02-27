package Model;

public class SuratData {
    private String Sungai;
    private String Petugas;
    private String Tanggal;
    private String Deskripsi;
    
public SuratData(String Sungai,String Petugas,String Tanggal,String Deskripsi){
    this.Sungai=Sungai;
    this.Petugas=Petugas;
    this.Tanggal=Tanggal;
    this.Deskripsi=Deskripsi;
}
public String getSungai(){
    return Sungai;
}
public void setSungai(String Sungai){
    this.Sungai=Sungai;
}
public String getPetugas(){
    return Petugas;
}
public void setPetugas(String Petugas){
    this.Petugas=Petugas;
}
public String getTanggal(){
    return Tanggal;
}
public void setTanggal(String Tanggal){
    this.Tanggal=Tanggal;
}
public String getDeskripsi(){
    return Deskripsi;
}
public void setDeskripsi(String Deskripsi){
    this.Deskripsi=Deskripsi;
}
}
