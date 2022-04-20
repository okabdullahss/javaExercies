package _11_dateTime;

import java.time.LocalTime;

public class Kullanici {

    private String isim;
    private LocalTime time;

    public Kullanici(){

    }

    public Kullanici(String isim, LocalTime time) {
        this.isim = isim;
        this.time = time;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Kullanici{" +
                "isim='" + isim + '\'' +
                ", time=" + time +
                '}';
    }
}
