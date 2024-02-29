package ex2;

import java.io.*;
import java.util.Random;

class Vers{
    private String text;

    public Vers(String text) {
        this.text = text;
    }

    public  int nrCuvinte(){
        String[] cuvinte = text.split("\\s+");
        return cuvinte.length;
    }
    public int nrVocale() {
        int nrVocale = 0;
        for(char c: text.toCharArray()) {
            if("aeiouAEIOU".indexOf(c)!= -1){
                nrVocale++;
            }
        }

        return nrVocale;
    }

    public boolean
    seIncheieCu(String grupare) {
        return text.endsWith(grupare);
    }

    public String getText(){
        return text;
    }

    public String toString(){
        return text;
    }
}

public class cantec {
    public static void main(String[] args) {
        try{
            BufferedReader flux_in = new BufferedReader(new FileReader("C:\\Users\\student\\georgiana_java\\lab2\\src\\ex2\\cantec_in.txt"));
            BufferedWriter flux_out = new BufferedWriter(new FileWriter("C:\\Users\\student\\georgiana_java\\lab2\\src\\ex2\\cantec_out.txt"));

            Random random = new Random();

            String linie;
            while((linie = flux_in.readLine()) != null) {
                double rand = random.nextDouble();
                if(rand <0.1){
                    linie = linie.toUpperCase();
                }

                Vers vers = new Vers(linie);
                int nrCuvinte = vers.nrCuvinte();
                int nrVocale = vers.nrVocale();

                flux_out.write(linie + " (" + nrCuvinte + " cuvinte, " + nrVocale + " vocale)");
                if(vers.seIncheieCu("aici")){
                    flux_out.write("*");

                }
                flux_out.newLine();
            }
            flux_in.close();
            flux_out.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}