package projects.Restoran_Projesi;

public class Siparis {

    private String isim;
    private double fiyat;
    private String porsiyon;

    Siparis(){

    }

    public Siparis(String isim, double fiyat, String porsiyon) {
        this.isim = isim;
        this.fiyat = fiyat;
        this.porsiyon = porsiyon;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public String getPorsiyon() {
        return porsiyon;
    }

    public void setPorsiyon(String porsiyon) {
        this.porsiyon = porsiyon;
    }


    public String toString() {



        return isim + "    "+ fiyat +"    "+porsiyon+"\n";
    }
}//class

