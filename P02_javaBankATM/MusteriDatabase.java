package gitPushes.P02_javaBankATM;

public class MusteriDatabase {

    private String isim;
    private String soyad;
    private String iban;

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public MusteriDatabase(String isim, String soyad, String iban){

        this.isim = isim;
        this.soyad=soyad;
        this.iban=iban;


    }
    @Override
    public String toString() {
        return "Musteri : " +
                "İsim: " + isim +
                ", Soyad: " + soyad +
                ", IBAN: " +iban;
    }

}
