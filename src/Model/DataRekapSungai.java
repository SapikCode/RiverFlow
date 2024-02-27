package Model;

public class DataRekapSungai {

    private String Namasungai;
    private String Tanggal;
    private String Suhu;
    private String Ph;
    private String Warna;
    private String Bau;
    private String Kondisi;
    private String Grade;
    
    public DataRekapSungai (String Namasungai,String Tanggal,String Suhu,String Ph,String Warna,String Bau,String Kondisi,String Grade){
        this.Namasungai=Namasungai;
        this.Tanggal=Tanggal;
        this.Suhu=Suhu;
        this.Ph=Ph;
        this.Warna=Warna;
        this.Bau=Bau;
        this.Kondisi=Kondisi;
        this.Grade=Grade;
    }
        public String getNamasungai(){
            return Namasungai;
        }
        public void setNama(String Namasungai){
            this.Namasungai=Namasungai;
        }
        public String getTanggal(){
            return Tanggal;
        }
        public void setTanggal(String Tanggal){
            this.Tanggal=Tanggal;
        }
        public String getSuhu(){
            return Suhu;
        }
        public void setSuhu(String Suhu){
            this.Suhu=Suhu;
        }
        public String getPh(){
            return Ph;
        }
        public void Ph(String Ph){
            this.Ph=Ph;
        }
        public String getWarna(){
            return Warna;
        }
        public void setWarna(String Warna){
            this.Warna=Warna;
        }
        public String getBau(){
            return Bau;
        }
        public void setBau(String Bau){
            this.Bau=Bau;
        }
        public String getKondisi(){
            return Kondisi;
        }
        public void setKondisi(String Kondisi){
            this.Kondisi=Kondisi;
        }
        public String getGrade(){
            return Grade;
        }
        public void setGrade(String Grade){
            this.Grade=Grade;
        }
    }
    





    

