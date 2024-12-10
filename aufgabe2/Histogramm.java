// Histogramm.java
package aufgabe2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Histogramm liest ganze Zahlen zwischen 1 und 6 ein und
 * gibt deren Hufigkeitsverteilung als Histogramm aus.
 * @author Atom
 * @version 0
 */
public final class Histogramm {
    private Histogramm() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        final int maxWert = 6;
        int[] anzahl = new int[maxWert];
        ArrayList<Integer> rand = new ArrayList<>();
        //---------------------------------------------------- Zahlen einlesen
        System.out.println("Möchtest du zufällige Zahlen eingeben? Dann antworte mit einem 'R'");
        if(EINGABE.next().toLowerCase().contains("r")){
            int menge = 0;
            System.out.println("Wie viele Zahlen möchtest du eingeben?"
                + "Bei ungültiger Eingabe wird der MaxWert genommen");
            try{
                String txt = EINGABE.next();
                menge = Integer.parseInt(txt);
            } catch(NumberFormatException ex){
                menge = Integer.MAX_VALUE;
            }
            for (int i = 0; i < menge; i++) {
                int number = (int)(Math.random()*maxWert)+1;
                if (number >= 1 && number <= maxWert) {
                    anzahl[number - 1]++;
                } else {
                    System.out.println("Zahl außerhalb von 1 bis 6");
                }
            }

        }
        else{
            System.out.println("Ganze Zahlen zwischen 1 und " + maxWert
                + " eingeben (Ende mit Strg-D/Strg-Z):");

            while (EINGABE.hasNextInt()) {
                int number = EINGABE.nextInt();

                if (number >= 1 && number <= maxWert) {
                    anzahl[number - 1]++;
                } else {
                    System.out.println("Zahl außerhalb von 1 bis 6");
                }
            }
        }
        //------------------------------------------------ Histogramm ausgeben
        System.out.println("\nAnzahl der vergebenen Werte \n");
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < maxWert; i++) {
            System.out.printf(" - %d: %d %n", i + 1, anzahl[i]);
            if (anzahl[i]<min && anzahl[i] != 0){
                min = anzahl[i];
            }
        }
        System.out.println("Als skalierter Graph:");
        int relAnzahl = 0;
        for (int j = 0; j < maxWert; j++) {
            relAnzahl = (int)(anzahl[j] / min);
            for (int k = 0; k < relAnzahl; k++) {
                System.out.print(j+1);
            }
            System.out.println("");
        }
        System.out.println("Als verschobener Graph:");
        for (int i = 0; i < maxWert; i++) {
            relAnzahl = anzahl[i] - min;
            System.out.println(relAnzahl);
             for (int j = 0; i < 5; j++) {
                System.out.print(i+1);
            }
            System.out.println("");
        }
       
    }
}

