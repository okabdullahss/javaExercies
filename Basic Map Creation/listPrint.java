package projects;

import java.util.*;

public class listPrint {

    public static void yazdir(Map<Integer,String> sinif) {


        Set<Integer> keySet = sinif.keySet(); // 100 101 102
        Collection<String> values = sinif.values();// length=3    1)Abdullah, OK, JavaDeveloper     2)Sena, OK, C#       3)Fatih, OK, QA Tester


        System.out.println("Numara     İsim       Soyad      Branş");
        System.out.println("=======================================");
        for (Integer each: keySet ) {
            String arr[] = sinif.get(each).split(",");
            int index =0;
            System.out.printf("%-4d     %-8s    %-4S     %-10s\n",each,arr[index],arr[index+1],arr[index+2]);

        }








    }//yazdir()

}//class
