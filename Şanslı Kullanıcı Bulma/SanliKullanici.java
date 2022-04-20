package _11_dateTime;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
   Bu uygulama kulanıcıların bir ArrayListe kayıt zamanını da alarak
   ekleyen ve sonrasında her dakikanın ilk 10 saniyesinde kaydolanları
   şanslı kullanıcı olarak ekrana yazdıran bir uygulamadır.
   Bunun için;

   1- Bir Kullanici class oluşturun fields: isim , time (LocalDateTime cinsinden)
   2- Kayıt isminde bir class oluşturun ve register isminde bir metod
   ekleyerek Kullanıcıdan user ismini alarak ArrayList e ekleyin ve bu list i
   return edin.
   3- Kayıt classı na aynı zamanda kendine verilen
   ArrayListteki userlardan her dakikanın ilk 10  saniyesinde kaydolanları
   yazdıran printHappyUsers isminde bir metod daha ekleyiniz.

   İpucu Çalışacak main metodu aşağıdaki gibi olmalıdır.

   public static void main(String[] args) {
   Registration userReg = new Registration();
   ArrayList<User> register = userReg.register();
    userReg.printHappyUsers(register);
   }

   */
public class SanliKullanici {


   static List<Kullanici> kayıtList = new ArrayList<>();
   static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {





        while(true){

            System.out.println("kullanici girmek için 1'e basınız: Çıkış yapmak için herhanbi başka bir tuşa basınız ");
            int secim = scanner.nextInt();scanner.nextLine();
            if(secim==1){

                System.out.print("isim: ");
                String isim = scanner.nextLine();
                Kullanici k3 = new Kullanici(isim,LocalTime.now());
                kayıtList.add(k3);
            } else {
                System.out.println(kayıtList);
                break;
            }
        }

        sansliKullanici(kayıtList);



    }

    public static void sansliKullanici(List<Kullanici> kayıtList) {

        for (Kullanici each: kayıtList) {
            if(each.getTime().getSecond()<10){
                System.out.println("Şanslı Kullanıcı !!: "+each.getIsim() + " giriş saati: "+each.getTime());
            } else {
                System.out.println("malesef :( ilk on saniye dışında giriş yaptınız... "+ each.getIsim()+" giriş saati: "+each.getTime());
            }
        }

    }


}
