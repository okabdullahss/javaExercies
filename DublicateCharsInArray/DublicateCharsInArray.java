package projects;

import java.util.*;

public class DublicateCharsInArray {
    /*       Write a code that returns the duplicate chars in a String array.  (interview Question)
       String str=“Javaisalsoeasy”
       Output: [a, s]        */
    public static void main(String[] args) {
        String str="Javaisalsoeasy";
        char[] arr = str.toCharArray();
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        //Arrays.toString(arr) = [J, a, v, a, i, s, a, l, s, o, e, a, s, y]

        ArrayList<Character> output = new ArrayList<>();

        for (int i = 0; i <arr.length; i++){
            for (int j = i+1; j < arr.length; j++){
                if(arr[i] == arr[j] && !output.contains(arr[j])) {
                    System.out.println(arr[j]);
                    output.add(arr[j]);
                }
            }
        }
        System.out.println("output = " + output); //output = [a, s]

    }
}//class