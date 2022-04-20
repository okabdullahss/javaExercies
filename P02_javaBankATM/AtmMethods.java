package gitPushes.P02_javaBankATM;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class AtmMethods {

    // ----------------------------------VARIABLES & NECESSARY OBJ ------------------------------------------------------------

    static boolean kucukHarfKontrol; //  BUNLARIN
    static boolean buyukHarfKontrol ; //    ÜÇÜ DE
    static boolean rakamKontrol ;///           ŞİFRE DEĞİŞİMİNDE KONTROL İÇİN ATANMIŞ variable'lar

    static Scanner scanner = new Scanner(System.in);
    static String defaultKartNo = "1122334455667788";
    static String defaultSifre = "asdf";
    static double defaultBakiye = 1000;


    static String secim; // switch case secimi
    static String sifre; //şifre sorulduğunda girilecek şifre
    static String kartNo;// kartno sorulduğunda girilecek kartno
    static String musteriAdi = "Abdullah OK";
    static int yeniSifreHakki = 3; // şifre değişimi için 3 tane hakkı var

    static List<MusteriDatabase> customer = new ArrayList<>();  // para gönderirken kayıtlı olmayan
                                                                // müşterilerin yeni kayıt yeri



    // ----------------------------------FİŞ İSTEME METHOD ------------------------------------------------------------
    private static void fisIsteme(String islemadi, double bakiye) {



        DateFormat DFormat = DateFormat.getDateInstance();
        Calendar cal = Calendar.getInstance();
        String curr_date = DFormat.format(cal.getTime());
        int curr_hour = LocalDateTime.now().getHour();
        int min = LocalDateTime.now().getMinute();

        System.out.println("===================================");

        System.out.println("İstoç Sanayi Kurumsal Şube");
        System.out.print("Müşteri Adı: "+musteriAdi);
        System.out.println("");
        System.out.print("İşlem Tarihi: ");
        System.out.print(curr_date);
        System.out.println("");
        System.out.print("İşlem Saati: ");
        System.out.println("  "+curr_hour+":"+min);



        System.out.println("===================================");

        System.out.println("İşlem Adı: "+islemadi);
        System.out.println("İşlem sonrası Güncel Bakiye: "+ bakiye);

        System.out.println("===================================");

        System.out.println("İyi günler dileriz");
        System.out.println("REGEX İstanbulⒸ / Büyük Mükellefler");

    }//fiş isteme

    // ----------------------------------GİRİŞ EKRANI METHOD ------------------------------------------------------------
    public static void girisEkrani() {

        System.out.println("Lütfen 16 Haneli Kart Numaranızı giriniz: ");
        kartNo = scanner.nextLine().trim().replace(" ","");
        System.out.println("Lütfen 4 haneli şifrenizi giriniz: ");
        sifre = scanner.nextLine();
    }//giris ekrani

    public static void girisKontrol() {
        if(kartNo.equals(defaultKartNo) && sifre.equals(defaultSifre)){
            System.out.println("Giriş Başarılı. Lütfen Yapmak İstediğiniz İşlemi Seçiniz: \n1-Bakiye Öğrenme\n" +
                    "2-Para Yatırma\n3-Para Çekme\n4-Para Gönderme\n5-Şifre Değiştirme\nÇıkış İçin 0'a basınız: ");

            secim = scanner.nextLine();

            switch (secim) {

                case "0":
                    System.out.println("Menüden çıkış yapılıyor. İyi günler dileriz.");

                case "1":
                    bakiyeOgrenme();
                    break;

                case "2":
                    paraYatirma();
                    break;

                case "3":
                    paraCekme();
                    break;

                case "4":
                    paraGonderme();
                    break;

                case "5":
                    sifreDegisim();
                    break;

                default:
                    System.out.println("Lütfen geçerli bir seçim yapınız: ");
                    break;

            }//switch

        } else System.out.println("Kart no veya şifreniz hatalıdır.");
    }//giris kontrol method





    // ----------------------------------ŞİFRE DEĞİŞİM METHOD ------------------------------------------------------------

    public static void sifreDegisim() {

        System.out.println("Şifre değişimi için lütfen mevcut şifrenizi giriniz: ");
        String mevcutSifre = scanner.nextLine();
        if(mevcutSifre.equals(defaultSifre)){
            System.out.println("Lütfen yeni şifrenizi giriniz: ");
            System.out.println("Yeni oluşturacağınız şifre: \n-4 haneli olmalıdır\n-1 küçük harf\n-1 büyük harf\n-1 rakam içermelidir");
            String yeniSifre = scanner.nextLine();



            for (int i=0; i<yeniSifre.length() ; i++) {

                if(Character.isLowerCase(yeniSifre.charAt(i)) ){
                    kucukHarfKontrol=true;
                    break;
                }
            }
            for (int i=0; i<yeniSifre.length() ; i++) {
                if(Character.isUpperCase(yeniSifre.charAt(i))){
                    buyukHarfKontrol=true;
                    break;
                }
            }
            for (int i=0; i<yeniSifre.length() ; i++) {
                if(Character.isDigit(yeniSifre.charAt(i))){
                    rakamKontrol=true;
                    break;
                }

            }


            if(kucukHarfKontrol && buyukHarfKontrol && rakamKontrol) {

                if(yeniSifre.length()==4 ){

                    while(yeniSifreHakki>0){
                        System.out.println("Lütfen yeni şifrenizi tekrar giriniz: ");
                        String yeniSifre2 = scanner.nextLine();
                        if(yeniSifre2.equals(yeniSifre)){
                            System.out.println("Şifre değişiminiz başarıyla gerçekleşmiştir.");
                            break;
                        }else {
                            yeniSifreHakki--;
                            System.out.println("Girilen şifreler uyuşmamaktadır. Lütfen tekrar deneyiniz. Kalan giriş hakkınız: "+yeniSifreHakki);
                        }
                    }
                    if(yeniSifreHakki==0){
                        System.out.println("3 defa yanlış girdiğiniz için hesabınız bloke olmuştur. Lütfen müşteri hizmetleri ile iletişime geçiniz.");
                    }
                } else System.out.println("Lütfen 4 haneli bir yeni şifre giriniz:"); } else {
                System.out.println("Girmiş olduğunuz yeni şifre \n1adet küçük harf\n1 adet büyük harf\n1 adet rakam\nŞartlarından birini sağlamamaktadır. \nŞifre değişim işlemine tekrar başlamak için 1'e, çıkış için herhangi bir tuşa basınız");
                String sifreDegisimDevamMi = scanner.nextLine();
                if(sifreDegisimDevamMi.equals("1")){
                    sifreDegisim();
                } else {
                    System.out.println("Şifre değişim işlemini tekrarlamadan çıkış yaptınız. İyi günler dileriz.");
                }
            }

        }else System.out.println("Kullanmakta olduğunuz şifreyi yanlış girdiniz."); /*  şifreyi değiştiriken yanlış şifre girdi bişeler yapılabilr  */


    }//sifre degisim


    // ----------------------------------PARA GÖNDERME METHOD ------------------------------------------------------------
    public static void paraGonderme() {
        System.out.print("Para gönderilecek IBAN numarasını giriniz: \nTR");
        String iban = scanner.nextLine();
        System.out.println("Para gönderilecek müşteri Adını girin");
        String ad =scanner.nextLine();
        System.out.println("Para gönderilecek müşteri soyadını girin");
        String soyad = scanner.nextLine();

        boolean access = false;

        for(MusteriDatabase customer : customer){
            if(ad.equalsIgnoreCase(customer.getIsim())
            && soyad.equalsIgnoreCase(customer.getSoyad())
            && iban.equals(customer.getIban())){

                access=true;
            }
        }

        if (iban.length() == 24 && access )  {
            System.out.println("IBAN teyit başarılı. Alıcı: "+ ad +" "+soyad+  "\nLütfen göndermek istediğiniz tutarı giriniz: ");
            double gonderilecekTutar = scanner.nextDouble();
            scanner.nextLine();
            if(gonderilecekTutar>defaultBakiye){
                System.out.println("Para transferi için yeterli bakiyeniz bulunmamaktadır.Mevcut bakiyeniz: "+defaultBakiye+" TL");
            } else {
                defaultBakiye-=gonderilecekTutar;
                System.out.println("Para transferi gerçekleşmiştir. Güncel bakiyeniz: "+defaultBakiye+" TL");
                System.out.println("Fiş istiyormusunuz ?  E/H ");
                String fisIstek = scanner.nextLine();
                if(fisIstek.equalsIgnoreCase("e")){
                    fisIsteme("Para Gönderim",defaultBakiye);
                } else {
                    System.out.println("Para gönderme işleminiz için fiş istemediniz. İyi günler dileriz");
                }

            }

        } else {
            System.out.println("Girilen verilere sahip müşteri bulunamadı. Oluşturmak isterseniz 1'e, istemezseniz herhangi bir diğer tuşa basınız: ");
            String musteriOlsunMu = scanner.nextLine();
            if(musteriOlsunMu.equals("1")){

                customer.add(musteriEkle());
                System.out.println("Yeni müşteri bilgileri eklenmiştir sizi para gönderim menüsüne tekrar yönlendiriyorum...");
                paraGonderme();


            } else {
                System.out.println("Yeni müşteri oluşturmak istemediniz. Sizi ana menüye yönlendiriyorum.");
                girisKontrol();
            }


        }


    }//paraGonderme method
    // ----------------------------------MÜŞTERİ EKLE METODU ------------------------------------------------------------

    public static MusteriDatabase  musteriEkle(){
        System.out.println("Yeni Müşteri İsmi: ");
        String yeniMusteriIsim = scanner.nextLine();
        System.out.println("Yeni Müşteri Soyisim: ");
        String yeniMusteriSoyisim = scanner.nextLine();
        System.out.println("Yeni Müşteri IBAN: ");
        String yeniMusteriIban = scanner.nextLine();

        return new MusteriDatabase(yeniMusteriIsim,yeniMusteriSoyisim,yeniMusteriIban);

    }


    // ----------------------------------PARA ÇEKME METHOD ------------------------------------------------------------
    public static void paraCekme() {
        System.out.println("Lütfen çekmek istediğiniz tutarı giriniz: ");/* FİŞ İSTEME EKLE */
        double tutar = scanner.nextDouble();
        scanner.nextLine();
        if(tutar>defaultBakiye){
            System.out.println("Yetersiz bakiye. Mevcut bakiyeniz: "+defaultBakiye+" TL");
        } else { defaultBakiye-=tutar;
            System.out.println("Para çekimi sonrası mevcut bakiyeniz: "+defaultBakiye+" TL");
            System.out.println("Fiş istiyormusunuz ?  E/H ");
            String fisIstek = scanner.nextLine();
            if(fisIstek.equalsIgnoreCase("e")){
                fisIsteme("Para Çekim",defaultBakiye);
            } else {
                System.out.println("Para çekme işleminiz için fiş istemediniz. İyi günler dileriz");
            }}

    }//paraCekme method


    // ----------------------------------PARA YATIRMA METHOD ------------------------------------------------------------
    public static void paraYatirma() {
        System.out.println("Lütfen yatırmak istediğiniz miktarı giriniz: ");
        double yatirilanTutar = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Paranızı %10 HOŞGELDİN BONUSU ile Kur Korumalı Vadeli Mevduat Hesabına Yatırmak ister misiniz ?\nEvet ise 1'e\nHayır ise herhangi diğer bir tuşa basınız");
        String mevduat =scanner.nextLine();
        if(mevduat.equals("1")){
            defaultBakiye+=(yatirilanTutar*1.1);
            System.out.println("Kur Koruma Vadeli Mevduat(KKVM) Ailesine Hoşgeldiniz ! Bonusunuzla birlikte yeni bakiyeniz: "+defaultBakiye+" TL");
            System.out.println("Fiş istiyormusunuz ?  E/H ");
            String fisIstek = scanner.nextLine();
            if(fisIstek.equalsIgnoreCase("e")){
                fisIsteme("Para Yatırma",defaultBakiye);
            } else {
                System.out.println("Para yatırma işleminiz için fiş istemediniz. İyi günler dileriz");
            }
        } else {
            defaultBakiye+=yatirilanTutar;
            System.out.println("Para yatırma başarılı. Güncel bakiyeniz: "+defaultBakiye+" TL");
            System.out.println("Fiş istiyormusunuz ?  E/H ");
            String fisIstek = scanner.nextLine();
            if(fisIstek.equalsIgnoreCase("e")){
                fisIsteme("Para Yatırma",defaultBakiye);
            } else {
                System.out.println("Para yatırma işleminiz için fiş istemediniz. İyi günler dileriz");
            }
        }

    }//paraYatirma method


    // ----------------------------------BAKİYE ÖĞRENME METHOD ------------------------------------------------------------
    public static void bakiyeOgrenme() {

        System.out.println("Mevcut bakiyeniz: " + defaultBakiye + " TL");

    }//bakiyeOgrenme method

}//class
