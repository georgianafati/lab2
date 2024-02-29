package ex1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        try{
            BufferedReader flux_in = new BufferedReader(new FileReader("C:\\Users\\student\\georgiana_java\\lab2\\src\\ex1\\judete.txt"));

            String linie;
            StringBuilder sb = new StringBuilder();
            while ((linie = flux_in.readLine()) != null) {
                sb.append(linie).append("\n");
            }

            String[] judete = sb.toString().split("\n");

            Arrays.sort(judete);

            System.out.println("Judetele ordonate:");

            for (String judet : judete) {
                System.out.println(judet);
            }

            System.out.println("\nIntrodu judetul pentru a-l cauta:");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String judetCautat = reader.readLine().trim();
            int pozitie = Arrays.binarySearch(judete, judetCautat);
            if (pozitie >= 0) {
                System.out.println("Judetul " + judetCautat + " se afla pe pozitia " + (pozitie + 1) + " in lista");
            }
            else {
                System.out.println("Judetul " + judetCautat + " nu a fost gasit");
            }
            flux_in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
