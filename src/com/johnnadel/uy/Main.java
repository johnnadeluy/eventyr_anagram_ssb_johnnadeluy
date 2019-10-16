package com.johnnadel.uy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception{
        File eventyrFil = new File("./res/eventyr.txt");
        BufferedReader eventyrFilLeser = new BufferedReader(new FileReader(eventyrFil));
        ArrayList<String> eventyrOrdliste = new ArrayList<>();

        //  leser eventyr.txt linje for linje.
        //  hvert ord lagres i en streng og legges inn i
        //  en ArrayList
        while(eventyrFilLeser.readLine() != null){
            String eventyrTxt = eventyrFilLeser.readLine();

            eventyrOrdliste.add(eventyrTxt);
        }

        File nsfFil = new File("./res/nsf2016.txt");
        BufferedReader nsfFilLeser = new BufferedReader(new FileReader(nsfFil));
        ArrayList<String> nsfOrdliste = new ArrayList<>();

        while(nsfFilLeser.readLine() != null){
            String nsfTxt = nsfFilLeser.readLine();

            nsfOrdliste.add(nsfTxt);
        }

        //  itererer gjennom alle strengene i ArrayListene til eventyr.txt og nsf2016.txt
        //  skriver ut alle ordene fra eventyr.txt først
        //  finner deretter anagrammene til eventyr fra ordlisten ved å sammenlikne alle ordene
        //  henter og skriver ut anagrammene på samme linje som eventyr
        for(String eventyrOrd : eventyrOrdliste){
            System.out.print(eventyrOrd);
            for(String nsfOrd : nsfOrdliste){
                if(finnAnagram(eventyrOrd, nsfOrd)){
                    System.out.print(" " + nsfOrd);
                }
            }
            System.out.println(" ");
        }
    }

    //  sorterer bokstavene til et gitt ord i alfabetisk rekkefølge
    //  returnerer strengen til ordet etter at den har blitt omstokket
    private static String sorterOrd(String ord){
        String omstokkBokstaver;

        char[] bokstaveneIOrdet = ord.toCharArray();
        Arrays.sort(bokstaveneIOrdet);

        omstokkBokstaver = new String(bokstaveneIOrdet);

        return omstokkBokstaver;
    }

    //  returnerer true hvis ordene er av samme lengde,
    //  ikke er en duplikasjon av hverandre
    //  og hvis de kun er like etter at de har blitt sortert/omstokket
    private static boolean finnAnagram(String ord1, String ord2){
        if(ord1.length() != ord2.length()){
            return false;
        }

        if (ord1.equals(ord2)){
            return false;
        }

        return sorterOrd(ord1).equals(sorterOrd(ord2));
    }
}
