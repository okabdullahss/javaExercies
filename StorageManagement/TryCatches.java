package projects.P11_depoYonetimi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatches {
    static int input;
    static String str;
    public static int intInput(){

        Scanner scanner = new Scanner(System.in);
        try{
            input = scanner.nextInt();

        }catch(InputMismatchException e){
            System.out.println("Invalid input, please try again ");
            intInput();
        }

        return input;
    }//intGirisi()




}
