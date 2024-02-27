package Model;

public class DataUserBaru {

    private String Nama;
    private String Username;
    private String Password;
    private String Tanggal;
    private String JKelamin;
    private String Email;
    private String Nohp;
    private String Domisili;
    private String Pilihan;

    public DataUserBaru (String Nama,String Username,String Password,String Tanggal,String JKelamin,String Email,String Nohp,String Domisili,String Pilihan){
        this.Nama=Nama;
        this.Username=Username;
        this.Password=Password;
        this.Tanggal=Tanggal;
        this.JKelamin=JKelamin;
        this.Email=Email;
        this.Nohp=Nohp;
        this.Domisili=Domisili;
        this.Pilihan=Pilihan;
    }
    public String getNama(){
        return Nama;
    }
    public void setNama(String Nama){
        this.Nama=Nama;
    }
    public String getUsername(){
        return Username;
    }
    public void setUsername(String Username){
        this.Username=Username;
    }
    public String getPassword(){
        return Password;
    }
    public void setPassword(String Password){
        this.Password=Password;
    }
    public String getTanggal(){
        return Tanggal;
    }
    public void setTanggal(String Tanggal){
        this.Tanggal=Tanggal;
    }
    public String getJKelamin(){
        return JKelamin;
    }
    public void setJKelamin(String JKelamin){
        this.JKelamin=JKelamin;
    }
    public String getEmail(){
        return Email;
    }
    public void setEmail(String Email){
        this.Email=Email;
    }
    public String getNohp(){
        return Nohp;
    }
    public void setNohp(String Nohp){
        this.Nohp=Nohp;
    }
    public String getDomisili(){
        return Domisili;
    }
    public void setDomisili(String Domisili){
        this.Domisili=Domisili;
    }
    public String getPilihan(){
        return Pilihan;
    }
    public void setPilihan(String Pilihan){
        this.Pilihan=Pilihan;
    }
}

