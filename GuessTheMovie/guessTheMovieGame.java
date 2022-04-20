package gitPushes;


import java.util.*;

public class guessTheMovieGame {
    //    5          9            8          9          4          9            12              7
    static List<String> films = new ArrayList<>(Arrays.asList("JOKER", "INCEPTION", "PIYANIST", "GREENMILE", "LEON", "GODFATHER", "JURASSICPARK", "TITANIC"));

    static Scanner scanner = new Scanner(System.in);
/*
 TASK :
  yukarıdaki film listinde bulunan filmlerden herhangi birisini kullanıcının filim ismini  görmeden
  filmin index nosuna göre sectiriniz
  seçilen filmin  ismini filmin harf saysının 2 katı kadar hak tanıyarak tahmin etmesini
  sağlayan method create ediniz...



 */

    public static void main(String[] args) {



        Collections.shuffle(films);
        String letter ="";


        int lives=1;

        System.out.println("۩ ۩ ۩ GUESS THE MOVIE ! ۩ ۩ ۩");
        System.out.println("Please make your choice between 1 and "+films.size()+": ");
        int choice = scanner.nextInt();
        String chosenFilm =films.get(choice);
        String hiddenFilm=chosenFilm.replaceAll("\\w", "-");
        System.out.println(hiddenFilm);

        lives = (chosenFilm.length()) * 2;
        int indxOfLetter = 0;

        while (lives > 0) {


            System.out.println("You have " + lives + " tries left to guess the name");
            letter=scanner.next().toUpperCase();

            String[] arrChosen = chosenFilm.split("");
            String[] arrHidden = hiddenFilm.split("");

            if(letter.equalsIgnoreCase(chosenFilm) && lives==(chosenFilm.length()) * 2){
                System.out.println("֍֍ CONGRATULATIONS! ֍֍ GUESSED IT BY 1 SHOT! ֍֍ NEW RECORD !!");
                break;
            }
            if(letter.length()>1){
                // System.out.println("Please enter only 1 character");


                if(chosenFilm.contains(letter)){

                    hiddenFilm=""+ hiddenFilm.substring(0,chosenFilm.indexOf(letter) ) +
                            letter +
                            hiddenFilm.substring((chosenFilm.indexOf(letter))+letter.length());

                }

                System.out.println(hiddenFilm);
                lives--;




            } else {

                if (chosenFilm.contains(letter)){

                    for (int i=0; i<arrChosen.length ; i++) {
                        if(arrChosen[i].equalsIgnoreCase(letter)){
                            arrHidden[i]=arrChosen[i];
                        }
                    }

                    hiddenFilm="";
                    for (int i=0; i <arrHidden.length ; i++) {
                        hiddenFilm+=arrHidden[i];
                    }


                }//if chosenFilm.Contains(letter)

                System.out.println(hiddenFilm);

                lives--;
            }//else only 1 character

            if(hiddenFilm.equalsIgnoreCase(chosenFilm) && lives>0 ){
                System.out.println("Kudos !  You have guessed it right !");
                System.out.println("Your Score is: "+lives*100 );
                break;


            }else if(lives==0){
                System.out.println("Game is over :( you dont have any lives left");
                break;
            }

        }//while lives >0





    }//main method



}

