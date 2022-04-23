package projects;


import java.util.HashMap;
import java.util.Map;

public class RepetitiveCharsWihtMaps {

    public static void main(String[] args) {

          /*
    Hellooo    output: H=1   e=1   l=2   o=3
     */

        String input = "aaaabbbddh";

        Map<String,Integer> output = new HashMap<>();
        int sayac =0;
        String arr[] = input.split("");
        for (String each: arr) {
            if(!output.containsKey(each)){
                output.put(each,1);
            } else {
                int eski = output.get(each);
                output.replace(each,eski,++eski);
            }

        }

        System.out.println(output);

//           another way of doing this
//        for (int i = 0; i <arr.length ; i++) {
//            String harf ="";
//            int sayac=0;
//            for (int j = i; j <arr.length ; j++) {
//                if(arr[i].equalsIgnoreCase(arr[j])){
//                    sayac++;
//                    harf=arr[i];
//                }
//
//
//            } if(!output.containsKey(harf)){
//                output.put(harf,sayac);
//            }
//        }




    }//main

}//class
