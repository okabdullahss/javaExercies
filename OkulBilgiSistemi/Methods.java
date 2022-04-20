package projects.okulDeneme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Methods {

    static Scanner scanner = new Scanner(System.in);
    static List<Ogrenci> ogrenciList = new ArrayList<>();
    static List<Ogretmen> ogretmenList = new ArrayList<>();
    static String kisiTuru;

    public static void anaMenu() {
        System.out.println("===================================");
        System.out.println("ÖĞRENCİ ve ÖĞRETMEN YÖNETİM PANELİ");
        System.out.println("===================================");
        System.out.println("1-ÖĞRENCİ İŞLEMLERİ\n2-ÖĞRETMEN İŞLEMLERİ\nQ-ÇIKIŞ");
        System.out.println("Lütfen Kişi Türü seçiniz: ");
        String secim = scanner.nextLine().toUpperCase();

        switch (secim) {
            case "1":
                kisiTuru = "OGRENCI";
                islemMenusu();
                break;
            case "2":
                kisiTuru = "OGRETMEN";
                islemMenusu();
                break;
            case "Q":
                cikis();
                break;
            default:
                System.out.println("Hatalı giriş yaptınız tekrar deneyiniz:");
                anaMenu();
                break;

        }


    }//anaMenu()

    public static void cikis() {
        System.out.println("Çıkış yaptınız iyi günler dileriz...");
    }

    public static void islemMenusu() {

        System.out.println("=======" + kisiTuru + " İŞLEMLERİ=================");

        System.out.println("1-EKLEME\n2-ARAMA\n3-LİSTELEME\n4-SİLME\n5-ANA MENÜ");

        System.out.println("Lütfen işlem seçiniz: ");
        String secimIslem = scanner.nextLine();

        switch (secimIslem) {
            case "1":
                ekle();
                islemMenusu();
                break;
            case "2":
                ara();
                islemMenusu();
                break;
            case "3":
                listele();
                islemMenusu();
                break;
            case "4":
                silme();
                islemMenusu();
                break;
            case "5":
                anaMenu();
                break;
            default:
                System.out.println("Yanlış giriş yaptınız tekrar giriniz:");
                islemMenusu();
                break;

        }


    }//islemMenuss()


    public static void ara() {



        System.out.println(kisiTuru + " ARAMA SAYFASI========== ");
        System.out.println("Lütfen arama için isim girniz: ");
        String isim = scanner.nextLine();
        System.out.println("Lütfen arama için soyad giriniz: ");
        String soyad = scanner.nextLine();
        if (kisiTuru.equalsIgnoreCase("OGRENCI")) {

            int ogrenciSayac =0;

            for (int i = 0; i < ogrenciList.size(); i++) {
                if (ogrenciList.get(i).isim.equalsIgnoreCase(isim)
                        && ogrenciList.get(i).soyad.equalsIgnoreCase(soyad)) {
                    System.out.println("Aradığınız öğrenci bulundu. Bilgileri: " + ogrenciList.get(i));
                    ogrenciSayac++;
                }
            }
            if(ogrenciSayac==0) System.out.println("Aradığınız kriterlere uygun öğrenci bulunamamıştır");
        } else {
            int ogretmenSayac =0;
            for (int i = 0; i < ogretmenList.size(); i++) {
                if (ogretmenList.get(i).isim.equalsIgnoreCase(isim)
                        && ogretmenList.get(i).soyad.equalsIgnoreCase(soyad)) {
                    System.out.println("Aradığınız öğretmen bulundu. Bilgileri: " + ogretmenList.get(i));
                    ogretmenSayac++;
                }
            }
if(ogretmenSayac==0) System.out.println("Aradığınız kriterlere uygun öğretmen bulunamamıştır");
        }
    }//ara()

    public static void ekle() {
        System.out.println(" İsmi giriniz: ");
        String isim = scanner.nextLine();
        System.out.println(" soyad giriniz: ");
        String soyad = scanner.nextLine();
        System.out.println(" Kimlik No giriniz: ");
        String kimlikNo = scanner.nextLine();
        System.out.println(" Yaş giriniz: ");
        int yas = scanner.nextInt();
        scanner.nextLine();
        if (kisiTuru.equalsIgnoreCase("OGRENCI")) {
            System.out.println(" Numara giriniz: ");
            String numara = scanner.nextLine();
            System.out.println(" Sınıf giriniz: ");
            String sinif = scanner.nextLine();
            Ogrenci ogr1 = new Ogrenci(isim, soyad, kimlikNo, yas, numara, sinif);
            ogrenciList.add(ogr1);
            System.out.println(isim.toUpperCase() +" "+ soyad.toUpperCase()+" adlı öğrenci sistemimize eklenmiştir.");
        } else {
            System.out.println(" Bölüm giriniz: ");
            String bolum = scanner.nextLine();
            System.out.println(" Sicil no giriniz: ");
            String sicilNo = scanner.nextLine();
            Ogretmen ogrt1 = new Ogretmen(isim, soyad, kimlikNo, yas, bolum, sicilNo);
            ogretmenList.add(ogrt1);
            System.out.println(isim.toUpperCase() +" "+soyad.toUpperCase()+" adlı öğretmen sistemimize eklenmiştir.");
        }


    }//ogrenciEkle()


    public static void listele() {
        System.out.println(kisiTuru + " LİSTESİ AŞAĞIDAKİ GİBİDİR ");

        if (kisiTuru.equalsIgnoreCase("OGRENCI")) {
            System.out.println("İSİM        SOYAD     KİMLİK NO  YAŞ  NUMARA  SINIF");
            System.out.println("=====================================================");
            for (int i=0; i <ogrenciList.size() ; i++) {
                System.out.printf("%-11S  %-9S  %-9S  %-2d  %-5S  %-5S\n",ogrenciList.get(i).isim,
                        ogrenciList.get(i).soyad,ogrenciList.get(i).kimlikNo,
                        ogrenciList.get(i).yas,ogrenciList.get(i).numara,
                        ogrenciList.get(i).sinif);
            }
            System.out.println("");

        } else {
            System.out.println("İSİM        SOYAD     KİMLİK NO  YAŞ   BÖLÜM   SİCİLNO");
            System.out.println("=====================================================");
            for (int i=0; i <ogretmenList.size() ; i++) {
                System.out.printf("%-9S  %-9S  %-9S  %-2d  %-10S  %-5S\n",ogretmenList.get(i).isim,
                        ogretmenList.get(i).soyad,ogretmenList.get(i).kimlikNo,
                        ogretmenList.get(i).yas,ogretmenList.get(i).bolum,
                        ogretmenList.get(i).sicilNo);
            }
            System.out.println("");
        }

    }//listele()

    public static void silme() {
        System.out.println("Lütfen silmek istediğiniz kişinin kimlik nosunu giriniz: ");
        String kimlikNo = scanner.nextLine();


        if (kisiTuru.equalsIgnoreCase("OGRENCI")) {
            int sayacOgrenci=0;

            for (Ogrenci w: ogrenciList) {
                if(w.kimlikNo.equalsIgnoreCase(kimlikNo)){
                    System.out.println(kimlikNo + " Kimlik nolu"+w.isim.toUpperCase() +" "+w.soyad.toUpperCase() +" öğrenci silinmiştir");
                    ogrenciList.remove(w);
                    sayacOgrenci++;
                }
            }

            if(sayacOgrenci==0){
                System.out.println("Bu kimlik no'ya ait öğrenci bulunamamıştır");
            }
        } else {

            int sayacOgretmen=0;

            for (Ogretmen w: ogretmenList) {
                if(w.kimlikNo.equalsIgnoreCase(kimlikNo)){
                    System.out.println(kimlikNo + " Kimlik nolu"+w.isim.toUpperCase() +" "+w.soyad.toUpperCase() +" öğretmen silinmiştir");
                    ogretmenList.remove(w);
                    sayacOgretmen++;
                }
            }
            if(sayacOgretmen==0){
                System.out.println("Bu kimlik no'ya ait öğretmen bulunamamıştır");
            }
        }


    }//silme()


}//class
