package projects.okulDeneme;

public class Ogrenci extends Kisi {

    String numara;
    String sinif;

    public Ogrenci(){

    }
    public Ogrenci(String isim, String soyad, String kimlikNo, int yas, String numara, String sinif) {
        super(isim, soyad, kimlikNo, yas);
        this.numara = numara;
        this.sinif = sinif;
    }

    @Override
    public String toString() {
        return "Ogrenci{" +  "isim='" + isim +", soyad='" + soyad  + ", kimlikNo='" + kimlikNo+", yas=" + yas + ", numara='" + numara + '\'' +
                ", sinif='" + sinif + '\'' +
                '}';
    }
}//class
