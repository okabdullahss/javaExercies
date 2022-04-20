package projects.okulDeneme;

public class Kisi {

    String isim;
    String soyad;
    String kimlikNo;
    int yas;

    public Kisi(){

    }
    public Kisi(String isim, String soyad, String kimlikNo, int yas) {
        setIsim(isim);
        setSoyad(soyad);
        this.kimlikNo = kimlikNo;
        this.yas = yas;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim.toUpperCase();
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad.toUpperCase();
    }

    public String getKimlikNo() {
        return kimlikNo;
    }

    public void setKimlikNo(String kimlikNo) {
        this.kimlikNo = kimlikNo;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }
}
