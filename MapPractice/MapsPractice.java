package projects;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapsPractice {

    public static void main(String[] args) {
/*
return the list of names who knows the required programming language
 */
  Map<Integer,String> map1 = new HashMap<>();

  map1.put(101,"Joe, Biden, java");
  map1.put(102,"Dimitri, Medmedev, java");
  map1.put(103,"Angela, Merkel, C#");

  String requiredLang = "JAVA";



        System.out.println(languagePros(map1, requiredLang));

    }//main

    private static List<String> languagePros(Map<Integer, String> map1,String language) {
        List<String> list1 = new ArrayList<>();

        for (String each: map1.values() ) {
            String arr[] = each.split(", ");

            if(arr[2].equalsIgnoreCase(language)){
                list1.add(arr[0]);
            }

        }



        return list1;
    }

}//class
