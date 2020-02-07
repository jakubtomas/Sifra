package sample;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
public static ArrayList<Character> letter = new ArrayList<>();
//public static ArrayList<Character> pomocna = new ArrayList<>();
public static ArrayList<Character>  charpasword = new ArrayList<>();
public static ArrayList<Character>  vysledok = new ArrayList<>();
public static ArrayList<Integer> number = new ArrayList<Integer>();
public static ArrayList<Integer> password = new ArrayList<Integer>();
public static ArrayList<Integer> sifra = new ArrayList<Integer>();

    public static int[] mojepole;
public static ArrayList<String> result = new ArrayList<String>();



    public void printdocument() {

        String heslo = "abcd";

        try {

            File myFile = new File("src\\text.txt");

            Scanner myReader = new Scanner(myFile);

            // kolko je tych riadok nepoznam pocet riadkov pouzije while
            String data = null;
            while (myReader.hasNextLine()) {
                 data = myReader.nextLine();// cely riadok ulozi do premmennej data
                System.out.println(data); // vypise

                System.out.println(data.length());

                System.out.println(data.charAt(0));

            }

            for (int i = 0; i < data.length(); i++) { // text from file
                letter.add(data.charAt(i));
               // number.add((int) data.charAt(i));

            }

            System.out.println(letter);

            for (int i = 0; i < heslo.length(); i++) { /// heslo

                charpasword.add(Character.toUpperCase(heslo.charAt(i))); /// tu mam velke pismena okey

            }
            System.out.println(charpasword);

            int velkosthesla = charpasword.size();
            int pocitanie = 0;

            for (int i = 0; i < letter.size(); i++) {
                if (pocitanie == velkosthesla) {
                    pocitanie = 0;
                }

                int value = (int)letter.get(i);

                if (value < 91 && value > 64 || value < 123 && value > 96) {
                    vysledok.add((char) (letter.get(i) + charpasword.get(pocitanie)       ));
                    pocitanie++;
                } else {
                    vysledok.add(letter.get(i));
                }



            }
            System.out.println("and result is =============");
            System.out.println((int)vysledok.get(0));
            //System.out.println();

            String kon = "";
            for (int i = 0; i < vysledok.size(); i++) {
                kon += String.valueOf(vysledok.get(i));
            }

            System.out.println(" zelena " + kon);




            File file = new File("Filename.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintWriter pw = new PrintWriter(file);
            pw.println(kon);
            pw.close();
            System.out.println("done ");




            //System.out.println(password.get(3));
            /*int count = password.size();
            int pocitadlo = 0;

            for (int i = 0; i < number.size(); i++) { /// heslo
                //letter.add(data.charAt(i));

                if (pocitadlo == count) { //
                    pocitadlo = 0;
                }
                //System.out.println(pocitadlo);

                if (number.get(i) < 91 && number.get(i) > 64 || number.get(i) < 123 && number.get(i) > 96) {

                    sifra.add(number.get(i) + password.get(pocitadlo));
                    pocitadlo++;
                } else {
                    System.out.println(number.get(i));
                    sifra.add(number.get(i));
                }






            }
            System.out.println(number);
            System.out.println(password);
            System.out.println(sifra);

            */
            
            // dalej potrebujeme zatvorit subor
            myReader.close(); // zatvorim subor


         } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    private static int getShift(String key, int i) {

        if(key.charAt(i % key.length()) < 65 || key.charAt(i % key.length()) > 90){ //znak v ASCII

            throw new IllegalArgumentException("" +
                    "Klic retezec neobsahuje jen velka pismena");
        }
        return ((int)key.charAt(i % key.length())) - 65;
    }


    // Potrebne zmenit adresu suboru projektu
    public void printFileInfo() {
        /*File myfile = new File( "src\\text.txt");*/
        File myfile = new File( "C:\\Users\\install\\IdeaProjects\\readfile\\src\\text.txt");
        // ci je na zapis, na citannie alebo na upravu


        if (myfile.exists()) {
            System.out.println("File name " + myfile.getName());
            System.out.println("absolute path " + myfile.getAbsolutePath());
            System.out.println("size " + myfile.length());
            System.out.println("Rendable " + myfile.canRead());
            System.out.println("time" );
        } else {
            System.out.println("File not found");
        }
    }



    public void changeLetter() {

    }

}
