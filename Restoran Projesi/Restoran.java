package projects.Restoran_Projesi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Restoran {

    String[] anaYemek      = {"1-Kaburga Dolma","2-Kuzu Kafes","3-Kuzu Tandır","4-Beyti Sarma","5-Büryan"};
    double[] anaYemekFiyat = {90,120,110,80,100};
    String anaYemekPorsyn ;

    String[] araSicak      = {"1-Reyhani","2-Şakşuka","3-Acılı Ezme","4-Fırında Mantar","5-Fındık Lahmacun"};
    double[] araSicakFiyat = {25,35,20,40,30};
    String araSicakPorsyn;

    String[] tatli         = {"1-Künefe","2-Şöbiyet","3-Havuç Dilim","4-Kadayıf","5-Katmer"};
    double[] tatliFiyat    = {45,50,30,55,65};
    String tatliPorsyn;

    String[] icecek        = {"1-Şalgam","2-Pepsi","3-Açık Ayran","4-IceTea","5-Su"};
    double[] icecekFiyat   = {10,15,14,15,7};
    String icecekPors;


    public static void main(String[] args) {
        Methods asdf = new Methods();

        asdf.anaYemekSecim();
    }




}
