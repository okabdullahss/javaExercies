package projects.okulDeneme;

public class Ogretmen extends Kisi{

    String bolum;
    String sicilNo;

    public Ogretmen(){
    }

    public Ogretmen(String isim, String soyad, String kimlikNo, int yas, String bolum, String sicilNo) {
        super(isim, soyad, kimlikNo, yas);
        this.bolum = bolum;
        this.sicilNo = sicilNo;
    }

    @Override
    public String toString() {
        return "Ogretmen{" +
                "isim='" + isim + '\'' +
                ", soyad='" + soyad + '\'' +
                ", kimlikNo='" + kimlikNo + '\'' +
                ", yas=" + yas +
                ", bolum='" + bolum + '\'' +
                ", sicilNo='" + sicilNo + '\'' +
                '}';
    }
}//class
