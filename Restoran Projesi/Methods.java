package projects.Restoran_Projesi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Methods extends Restoran{

    static double toplamTutar;//fişin en altındaki toplam tutar

    Scanner scanner = new Scanner(System.in);

   public List<Siparis> siparis = new ArrayList<>();



//----------------------------------------------------------------------------------------------------------------------------------------------
    public void anaYemekSecim(){


        System.out.println("ANA YEMEKLER");
        System.out.println("===========================");
        for (int i = 0; i <anaYemek.length ; i++) {
            System.out.printf("%-14S      %5.1fTL\n",anaYemek[i],anaYemekFiyat[i]);
        }
        System.out.println("===========================");
        System.out.println("");
        System.out.println("Lütfen ANA YEMEK tercihinizi yapınız, bittiğinde devam etmek için 0'ı tuşlayınız: ");

       while(true){
           int secim = scanner.nextInt();scanner.nextLine();
           if(secim==0){
               System.out.println("Ara Sıcak seçimine devam edebilrsiniz:  ");
               break;
           }else {
               System.out.println(anaYemek[secim-1]+" Tek Porsiyon(T) Duble Porsiyon(D)?   T/D ?");
               String porsSecim = scanner.nextLine().toUpperCase();

               siparis.add(new Siparis(anaYemek[secim-1],anaYemekFiyat[secim-1],porsSecim));
               System.out.println((anaYemek[secim-1])+" secim tamamlandı. porsiyon: "+porsSecim+" seçimlere devam edebilrsiniz");

           }
       }

       araSicakSecim();


    }//anaYemekSecim();
//----------------------------------------------------------------------------------------------------------------------------------------------

    public void araSicakSecim() {

        System.out.println("ARA SICAKLAR");
        System.out.println("===========================");
        for (int i = 0; i <araSicak.length ; i++) {
            System.out.printf("%-14S      %5.1fTL\n",araSicak[i],araSicakFiyat[i]);
        }
        System.out.println("===========================");

        System.out.println("Lütfen ARA SICAK tercihinizi yapınız, bittiğinde devam etmek için 0'ı tuşlayınız: ");
        while(true){
            int secim = scanner.nextInt();scanner.nextLine();
            if(secim==0){
                System.out.println("Tatlı seçimine devam edebilrsinz: ");
                break;
            }else {
                System.out.println(araSicak[secim-1]+" Tek Porsiyon(T) Duble Porsiyon(D)?   T/D ?");
                String porsSecim = scanner.nextLine().toUpperCase();
                siparis.add(new Siparis(araSicak[secim-1],araSicakFiyat[secim-1],porsSecim));
                System.out.println((araSicak[secim-1])+". secim tamamlandı. porsiyon: "+porsSecim+" seçimlere devam edebilrsiniz");

            }
        }

        tatliSecim();
    }//araSicakSecim()

//----------------------------------------------------------------------------------------------------------------------------------------------

    private void tatliSecim() {
        System.out.println("TATLILAR");
        System.out.println("===========================");
        for (int i = 0; i <tatli.length ; i++) {
            System.out.printf("%-14S      %5.1fTL\n",tatli[i],tatliFiyat[i]);
        }
        System.out.println("===========================");

        System.out.println("Lütfen TATLI tercihinizi yapınız, bittiğinde devam etmek için 0'ı tuşlayınız: ");
        while(true){
            int secim = scanner.nextInt();scanner.nextLine();
            if(secim==0){
                System.out.println("İçecek seçimine devam edebilrsiniz: ");
                break;
            }else {
                System.out.println(tatli[secim-1]+" Tek Porsiyon(T) Duble Porsiyon(D)?   T/D ?");
                String porsSecim = scanner.nextLine().toUpperCase();
                siparis.add(new Siparis(tatli[secim-1],tatliFiyat[secim-1],porsSecim));
                System.out.println((tatli[secim-1])+". secim tamamlandı. porsiyon: "+porsSecim+" seçimlere devam edebilrsiniz");

            }
        }

        icecekSecim();


    }//tatliSecim()



//----------------------------------------------------------------------------------------------------------------------------------------------

    private void icecekSecim() {

        System.out.println("MEŞRUBAT");
        System.out.println("===========================");
        for (int i = 0; i <icecek.length ; i++) {
            System.out.printf("%-14S      %5.1fTL\n",icecek[i],icecekFiyat[i]);
        }
        System.out.println("===========================");

        System.out.println("Lütfen ana yemek tercihinizi yapınız, bittiğinde devam etmek için 0'ı tuşlayınız: ");
        while(true){
            int secim = scanner.nextInt();scanner.nextLine();
            if(secim==0){
                break;
            }else {
                System.out.println(icecek[secim-1]+"Tek Porsiyon(T) Duble Porsiyon(D)?   T/D ?");
                String porsSecim = scanner.nextLine().toUpperCase();
                siparis.add(new Siparis(icecek[secim-1],icecekFiyat[secim-1],porsSecim));
                System.out.println((icecek[secim-1])+". secim tamamlandı. porsiyon: "+porsSecim+" seçimlere devam edebilrsiniz");

            }
        }
        fisYazdir();

    }//icecekSecim()



//----------------------------------------------------------------------------------------------------------------------------------------------

    public void  fisYazdir() {



        LocalTime tarihSaat= LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm");
        LocalDateTime asd = LocalDateTime.now();

        DateTimeFormatter qqq = DateTimeFormatter.ofPattern("dd/MM/yy");

        System.out.println("ANTEPLİ  ÜSTADIM  LEZZET  SOFRASI");
        System.out.println("Saat: "+qqq.format(asd)+"           "+formatter.format(tarihSaat) );
        System.out.println("");

        System.out.println("SİPARİŞ          PORS       FİYAT");
        System.out.println("====================================");
        for (int i = 0; i <siparis.size() ; i++) {
            if(siparis.get(i).getPorsiyon().equalsIgnoreCase("d")){
                System.out.printf("%-15S     %-2S     %7.1fTL\n",siparis.get(i).getIsim(),siparis.get(i).getPorsiyon(),siparis.get(i).getFiyat()*2);
            } else {
                System.out.printf("%-15S     %-2S     %7.1fTL\n",siparis.get(i).getIsim(),siparis.get(i).getPorsiyon(),siparis.get(i).getFiyat());
            }


        }
        System.out.println("====================================");
        for (int i = 0; i <siparis.size() ; i++) {

            if(siparis.get(i).getPorsiyon().equalsIgnoreCase("d")){
                toplamTutar+=siparis.get(i).getFiyat()*2;

            }else {
                toplamTutar+=siparis.get(i).getFiyat();
            }

        }
        System.out.println("GENEL TOPLAM:                  "+toplamTutar+"TL");


        System.out.println("AFİYET OLSUN YİNE BEKLERİZ");
        System.out.println("");
        degerlendirme();

    }



//----------------------------------------------------------------------------------------------------------------------------------------------
private void degerlendirme() {
        int puan;

        List<Integer> puanlar = new ArrayList<Integer>();

    System.out.println("Lütfen Yediğiniz Yemeklerimizi Değerlendiriniz: 1 çok kötü 5 çok iyi");
    for (int i=0; i<siparis.size() ; i++) {
        System.out.print(siparis.get(i).getIsim()+": ");
        puan=scanner.nextInt();
        puanlar.add(puan);
    }


    System.out.println("================================");

    for (int i = 0; i <siparis.size() ; i++) {
        System.out.printf("%-15S:    %5s\n",siparis.get(i).getIsim(),yildiz(puanlar.get(i)));
    }
    System.out.println("================================");

    int basari=0;
    for (int i = 0; i <puanlar.size() ; i++) {
        basari+=puanlar.get(i);
    }
    System.out.println("Siz değerli müşterimizden aldığımız puanımız: "+puanlar.size()*5+" üzerinden "+basari);
    System.out.println("Değerlendirmeniz için teşekkür ederiz. Kendimizi ve Lezzetlerimizi geliştirmeye devam edeceğiz");





}//degerlendirme()
//----------------------------------------------------------------------------------------------------------------------------------------------

    public String yildiz(int a){
        String x="";
        for (int i = 0; i <a ; i++) {
            x+="*";
        } return x;
    }

}//class
